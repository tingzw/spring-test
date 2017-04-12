package com.tingzw.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLucene {

    // 待索引文件存放路径
    private static String source_file_path = "F:\\Lucene\\index_text";

    // 生成的全文索引文件存储路径
    private static String indexDir = "F:\\Lucene\\index_dir";

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 中文分词器IKAnalyzer,从http://code.google.com/p/ik-analyzer/downloads/list 下载最新源码放入项目中使用
    private static Analyzer analyzer = new IKAnalyzer();

    @Test
    public void testAnalyzer()throws Exception{
        String text="基于java语言开发的轻量级的中文分词工具包，一个轻量级框架 this is a  spring!";

        // 创建分词对象
        Analyzer analyzer = new IKAnalyzer(true);
      /*  Analyzer analyzer = new SimpleAnalyzer(Version.LUCENE_48);*/
        StringReader reader = new StringReader(text);

        // 分词
        TokenStream ts = analyzer.tokenStream("", text);
        ts.reset();
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);

        //获取词与词之间的位置增量
        PositionIncrementAttribute postiona = ts.addAttribute(PositionIncrementAttribute.class);
        //获取各个单词之间的偏移量
        OffsetAttribute offseta = ts.addAttribute(OffsetAttribute.class);
        //获取每个单词信息
        CharTermAttribute chara = ts.addAttribute(CharTermAttribute.class);
        //获取当前分词的类型
        TypeAttribute typea = ts.addAttribute(TypeAttribute.class);
        while(ts.incrementToken()){
            System.out.print("位置增量" +postiona.getPositionIncrement()+":\t");
            System.out.println(chara + "\t[" + offseta.startOffset() + " - " + offseta.endOffset() + "]\t<" + typea +">");
        }

       /* // 遍历分词数据
        while(ts.incrementToken()){
            System.out.print(term.toString()+" | ");
        }*/

        reader.close();
        System.out.println();
    }

    @Test
    public void createIndex() {
        Directory directory = null;
        try {
            // lucene有两种数据存储方式,文件系统或者内存,这里使用文件系统存储索引数据
            directory = new SimpleFSDirectory(new File(indexDir));

            // 生成全文索引的配置对象
            IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_48, analyzer);
            // 设置生成全文索引的方式为创建或者追加
            config.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            // 创建真正生成全文索引的writer对象
            IndexWriter indexWriter = new IndexWriter(directory, config);

            // 读取待索引文件夹下的所有的.txt文件
            File sourceFiles = new File(source_file_path);
            String txtFiles[] = sourceFiles.list(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    if (name.endsWith(".txt")) { // 这里只对.txt文件创建索引
                        return true;
                    }
                    return false;
                }
            });

            // 遍历所有txt文件写入全文索引,如果数据来源是数据库则遍历数据库查询结果集即可
            for (String txtFile : txtFiles) {
                String file = source_file_path + File.separator + txtFile;
                File input_txt_file = new File(file);

                System.out.println("开始对" + txtFile + "建立索引");

                Document doc = new Document(); // 约等于数据库的一行记录

                // 以下生成各个字段的数据值
                StringField name = new StringField("filename", input_txt_file.getName(), Store.YES);
                TextField content = new TextField("content", readFileContent(file, "gbk"), Store.YES);
                StringField path = new StringField("path", input_txt_file.getAbsolutePath(), Store.YES);
                StoredField date = new StoredField("date", df.format(new Date()));
                LongField size = new LongField("size", input_txt_file.length(), Store.YES);

                // 向Document对象中加入各个字段的值
                doc.add(name);
                doc.add(content);
                doc.add(path);
                doc.add(date);
                doc.add(size);

                // 向IndexWriter中增加新的一行记录
                indexWriter.addDocument(doc);
                // 提交数据内容
                indexWriter.commit();
            }
            indexWriter.close();
            directory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        String queryString = "服务器"; //查询条件
        String query_fields[] = new String[]{"filename", "content"};//对哪几个字段进行查询检索
        File file_index_dir = new File(indexDir);
        try {
            Directory directory = new SimpleFSDirectory(file_index_dir);
            IndexReader indexReader = DirectoryReader.open(directory);

            // 创建搜索类
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);

            QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_48, query_fields, analyzer);

            queryParser.setDefaultOperator(QueryParser.OR_OPERATOR);//多个关键字时采取 or 操作

            Query query = queryParser.parse(queryString);

            TopDocs topDocs = indexSearcher.search(query, 10000);//查询前多少条满足条件的数据

            System.out.println("一共查到:" + topDocs.totalHits + "记录");

            ScoreDoc[] scoreDoc = topDocs.scoreDocs;

            for (int i = 0; i < scoreDoc.length; i++) {
                // 内部编号
                int doc = scoreDoc[i].doc;
                System.out.println("内部编号:" + doc);

                // 根据文档id找到文档
                Document mydoc = indexSearcher.doc(doc);

                System.out.println("文档路径:" + mydoc.get("path")); //读取path字段的值

                System.out.println(mydoc.getField("content"));


            }

            //测试分页及高亮结果显示
            if (topDocs.totalHits > 0) {
                higherIndex(analyzer, indexSearcher, query, topDocs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 分页，高亮显示
     *
     * @param analyzer
     * @param isearcher
     * @param query
     * @param topDocs
     * @throws IOException
     * @throws InvalidTokenOffsetsException
     */
    public void higherIndex(Analyzer analyzer, IndexSearcher isearcher, Query query, TopDocs topDocs) throws IOException,
            InvalidTokenOffsetsException {
        TopScoreDocCollector results = TopScoreDocCollector.create(topDocs.totalHits, false);
        isearcher.search(query, results);
        // 分页取出指定的doc(开始条数, 取几条)
        ScoreDoc[] docs = results.topDocs(0, 2).scoreDocs;
        for (int i = 0; i < docs.length; i++) {
            Document targetDoc = isearcher.doc(docs[i].doc);
            System.out.println("内容：" + targetDoc.toString());
        }
        // 关键字高亮显示的html标签，需要导入lucene-highlighter-3.5.0.jar
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>", "</font>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
        for (int i = 0; i < docs.length; i++) {
            Document doc = isearcher.doc(docs[i].doc);
            // 标题增加高亮显示
            TokenStream tokenStream1 = analyzer.tokenStream("filename", new StringReader(doc.get("filename")));
            String title = highlighter.getBestFragment(tokenStream1, doc.get("filename"));
            // 内容增加高亮显示
            TokenStream tokenStream2 = analyzer.tokenStream("content", new StringReader(doc.get("content")));
            String content = highlighter.getBestFragment(tokenStream2, doc.get("content"));

            System.out.println(doc.getField("size"));
            System.out.println(doc.get("filename") + " : " + title + " : " + content);
        }
    }

    public static String readFileContent(String FileName, String charset) {
        InputStream fis = null;
        BufferedReader reader = null;
        StringBuffer result = new StringBuffer();
        try {
            fis = new FileInputStream(FileName);
            reader = new BufferedReader(new InputStreamReader(fis, charset));
            String line = new String();

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
        //System.out.println("内容:" + result.toString());
        return result.toString();
    }
}