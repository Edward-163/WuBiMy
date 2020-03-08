package com.demo.wubi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Demo.trimFour();
    }

    /**
     * 4码字去掉末笔码,变为单字全<=3码
     */
    public static void trimFour() {
        try {
            FileReader fileReader = null;
            fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\6.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = null;
            fileWriter = new FileWriter("C:\\Users\\Administrator\\Desktop\\7.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            List<String> list = new ArrayList<>();
            Boolean flag = true;

            while (flag) {
                String lineStr = null;
                lineStr = bufferedReader.readLine();

                if (!Optional.ofNullable(lineStr).isPresent()) {
                    flag = false;
                } else {
                    String[] split = lineStr.split(" ");
                    if (split[0].length() == 4) {
                        StringBuilder stringBuilder = new StringBuilder(lineStr);
                        lineStr = stringBuilder.deleteCharAt(3).toString();
                        bufferedWriter.write(lineStr);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();
                    } else {
                        bufferedWriter.write(lineStr);
                        bufferedWriter.newLine();
                        bufferedWriter.flush();

                    }
                }
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
