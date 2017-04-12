package com.tingzw.file;

import java.io.File;

/**
 * @author tingzw
 * @date 2017-03-28 15:23
 **/
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\eclipse_workspace\\appCoupon\\lib");

        File[] files = file.listFiles();
        for (File _file : files) {
            System.out.println(_file.getName());
        }
    }
}
