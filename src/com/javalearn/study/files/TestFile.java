package com.javalearn.study.files;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestFile {
    public static void main(String[] args) {
//        File myfile = new File("C:\\Users\\Klaus\\Documents\\file.txt");
//        if (myfile.exists()){
//            System.out.println(myfile.getAbsolutePath());
//            File parent = new File(myfile.getParent());
//            Stream.of(parent.list()).forEach(System.out::println);
//        }

        try (InputStream is = new FileInputStream("test.txt")) {
            is.skip(7);
            System.out.println(new String(is.readNBytes(4)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (StringWriter sw = new Fil){
//
//        }

    }
}
