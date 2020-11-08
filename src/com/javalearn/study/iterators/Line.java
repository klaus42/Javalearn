package com.javalearn.study.iterators;

import java.util.Iterator;

public class Line implements Iterable<String> {
    private String line;

    public Line(String line) {
        this.line = line;
    }

    public Line() {
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public Iterator<String> iterator() {
        return new WordIterator();
    }

    private class WordIterator implements Iterator<String> {

        private int idx;
        private int charCounter;
        private String trimmedLine;

        @Override
        public boolean hasNext() {
            while (idx<line.length()){
                if (line.charAt(idx)!=' '){
                        charCounter++;
                } else {
                    if (charCounter==5){
                        charCounter=0;
                        return  true;
                    }
                    charCounter=0;
                }
                idx++;
            }
            if (charCounter==5){
                charCounter=0;
                return  true;
            }
            return false;
        }

        @Override
        public String next() {

            String st="";

            for (int i=idx-5;i<idx;i++){
                st +=line.charAt(i);
            }

            return st;
        }
    }
}
