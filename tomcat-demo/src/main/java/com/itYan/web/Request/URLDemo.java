package com.itYan.web.Request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String username = "修";

        //1. URL encoding
        String encode = URLEncoder.encode(username, "utf-8");
        System.out.println(encode);

        //2. URL decoding
        String decode = URLDecoder.decode(encode, "ISO-8859-1");
        //String decode = URLDecoder.decode(encode, "utf-8");
        System.out.println(decode);

        //3. convert to byte array
        byte[] bytes = decode.getBytes("ISO-8859-1");
        for (byte b : bytes) {
            System.out.print(b + " ");
        }
        System.out.println();

        //4. convert byte array to string
        String s = new String(bytes, "UTF-8");
        System.out.println(s);
    }
}
