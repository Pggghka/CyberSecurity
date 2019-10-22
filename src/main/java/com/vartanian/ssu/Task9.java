package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Task9 {

    public String decrypt(byte[] text, String keyWord) {
        byte[] result = new byte[text.length];
        byte[] keyarr = keyWord.getBytes();
        for(int i = 0; i < text.length;i++) {
            result[i] = (byte) (text[i] ^ keyarr[i% keyarr.length]);
        }
        return new String(result, StandardCharsets.UTF_8);
    }

    public byte[] encrypt(String text, String keyWord){
        try {
            byte[] arr = text.getBytes("windows-1251");
            byte[] keyArr = keyWord.getBytes("windows-1251");
            byte[] result = new byte[arr.length];
            for(int i = 0; i < arr.length; i++)
                result[i] = (byte) (arr[i] ^ keyArr[i % keyArr.length]);
            return result;
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
            return null;
        }
    }

    public void go(){
        Scanner in = new Scanner(System.in);
        workingWithFile wwf = new workingWithFile();
        String text = StringUtils.upperCase(wwf.readFile("XOR.txt"));
        System.out.println("Enter your key: "); String key = in.next().toUpperCase();
        boolean Encryption = false;
        System.out.println("Do you want to Encrypt(1) or Decrypt(0)? : ");

        String cypher = "";
        if(in.nextInt()==1){
            cypher = encrypt(text, key).toString();
        } else {
            byte[] byteText = new byte[text.getBytes().length];
            for (int i = 0; i< text.length(); i++) byteText[i] = (byte)(text.charAt(i));
            cypher = decrypt(byteText, key);
        }

        System.out.println(cypher);
        wwf.writeToFile("XOR.txt", cypher);

        // [B@255316f2
    }
}
