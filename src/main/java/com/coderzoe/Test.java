package com.coderzoe;

import org.apache.log4j.Logger;

/**
 * @author yhs
 * @date 2020/5/22 23:05
 * @description
 */
public class Test {
    static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        logger.debug("hello");
        logger.warn("hello");
    }
}
