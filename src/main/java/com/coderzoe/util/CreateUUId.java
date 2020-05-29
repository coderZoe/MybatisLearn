package com.coderzoe.util;

import java.util.UUID;

/**
 * @author yhs
 * @date 2020/5/29 19:39
 * @description
 */
public class CreateUUId {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
