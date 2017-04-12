package com.tingzw.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tingzw
 * @date 2017-04-06 10:18
 **/
public class LogBackAction {
    //定义一个全局的记录器，通过LoggerFactory获取
    private final static Logger LOG = LoggerFactory.getLogger(LogBackAction.class);

    private final static Logger monitorLogger = LoggerFactory.getLogger("debugFile");

    /**
     * @param args
     */
    public static void main(String[] args) {
        LOG.info("logback 成功了");
        LOG.error("logback 成功了");


        LOG.warn("logback 警告");

        LOG.debug("logback --调试");

        monitorLogger.info("logback --monitorLogger ");


        // print internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }
}
