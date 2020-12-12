package com.apple.developer.util;

@SuppressWarnings("all")

public class CheckEmpty {
    public static boolean checkEmpty(String str) {
//        if(str==null || str.length()==0){
//            return true;
//        }else{
//            return false;
//        }
        if (str == null || str.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
