package com.coderzoe.dao;

import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @author yhs
 * @date 2020/5/22 22:34
 * @description
 */
public class Log4JTest {
    final static Logger logger = Logger.getLogger(Log4JTest.class);
    @Test
    public void testLog4j(){
        logger.info("info:进入了testLog4j方法");
        logger.debug("debug:进入了testLog4j方法");
        logger.error("error:进入了testLog4j方法");
        logger.warn("warn:进入了testLog4j方法");
    }
}
