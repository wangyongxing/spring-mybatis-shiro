/**
 * qccr.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.wyx.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yaojiafeng
 * @since $Revision:1.0.0, $Date: 16/5/24 下午6:35 $
 */
public class LogUtils {

    protected static Logger logger = LoggerFactory.getLogger("monitor");

    protected static Logger invokeLogger = LoggerFactory.getLogger("invoke");


    public static void invokeMessage(String method, String input, String output) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("method:").append(method).append("|");
        stringBuilder.append("input:").append(input).append("|");
        stringBuilder.append("output:").append(output).append("|");
        invokeLogger.info(stringBuilder.toString());
    }

}