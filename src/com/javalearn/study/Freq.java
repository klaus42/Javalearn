package com.javalearn.study;

import java.util.HashMap;

public class Freq {
    public static void main(String args[]){
        String word ="Подоконник";

        HashMap<Character,Integer> wmap = new HashMap<Character, Integer>();

        for (int i=0;i<word.length();i++){
            if (wmap.containsKey(word.charAt(i))){
                wmap.replace(word.charAt((i)),wmap.get(word.charAt(i))+1);
            } else {
                wmap.put(word.charAt(i),1);
            }

        }

    }
}
