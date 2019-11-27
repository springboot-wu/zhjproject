package com.zhj.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class MapToStrUtils {

    public static String  getMapToStr(Map<String,Object> params,String key){
     String value = null;
     if(params != null){
         Object o = params.get(key);
         if(StringUtils.isNotEmpty((CharSequence) o)){
             value = o.toString();
         }
     }
     return value;
    }
}
