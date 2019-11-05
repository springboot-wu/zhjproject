package com.zhj.util;

/**
 * @author ： 朱福
 * @date ：Created in 2019/10/28 14:36
 * @description：
 * @package ：com.zhj.util
 * @version:
 */
public class LikeUtil {
    //模糊查询调用（不为空时本身拼接一个%%返回）
    public  static String  LikeCha(String name) {
        if(name !=null && name !="") {

            return "%"+name+"%";
        }else {
            return null;
        }
    }
}
