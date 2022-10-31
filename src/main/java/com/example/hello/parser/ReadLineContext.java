package com.example.hello.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.io.*;


public class ReadLineContext<T> {
    private Parser<T> parser;

    public ReadLineContext(Parser<T> parser) {
        this.parser = parser;
    }

    public List<T> readByLine(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
        String str;

        br.readLine();
        while ((str = br.readLine()) != null) {
            try {
                result.add(parser.parse(str));
            } catch (Exception e) {
                System.out.printf("파싱중 문제가 생겨 이 라인은 넘어갑니다. 파일내용:%s\n", str.substring(0,20));
            }
        }
        br.close();
        return result;
    }

}
