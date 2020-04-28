package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Task6 {
    public void go(){
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        String[][] array = new String[33][33];

        for(int i = 0; i < russianAlphabet.length(); i++){
            String curStr = russianAlphabet.substring(i,russianAlphabet.length()) + russianAlphabet.substring(0,i);
            for (int j = 0; j < russianAlphabet.length();j++){
                array[i][j] =curStr.charAt(j)+"";
            }
        }

        for(int i = 0; i < russianAlphabet.length(); i++){
            System.out.println();
            for (int j = 0; j < russianAlphabet.length();j++){
                System.out.print(array[i][j] + " ");
            }
        }
        System.out.println();
        Scanner in = new Scanner(System.in);
        workingWithFile wwf = new workingWithFile();
        String word = StringUtils.upperCase(wwf.readFile("viznerCypher.txt"));
        System.out.println("Enter key: "); String key = in.next().toUpperCase();

        System.out.println(russianAlphabet);
        boolean Encryption = false;
        System.out.println("Do you want to Encrypt(1) or Decrypt(0)? : ");
        if(in.nextInt()==1)Encryption = true;
        //How many symbolls add
        int modInd = word.length() % key.length();
        //How many times add word
        int fullCon = word.length() / key.length();
        String newKey = "";
        String cypherText = "";

        // newKey - ключключключ
        for (int i = 0; i < fullCon; i++) newKey+=key;
        for (int i = 0; i < modInd; i++) newKey+=key.charAt(i);



        System.out.println("Ключ по тексту - " + newKey);
        for(int i = 0; i<word.length() ;i++){
            int indexWord = russianAlphabet.indexOf(word.charAt(i));
            int indexKey = russianAlphabet.indexOf(newKey.charAt(i));
            System.out.println(indexKey + " " + indexWord );
            if (Encryption)cypherText += array[indexKey][indexWord];
            else {
                System.out.println(Arrays.toString(array[indexKey]));
                String a = Arrays.toString(array[indexKey]).replace(", ", "").replace("[", "").replace("]", "");
                cypherText += russianAlphabet.charAt(a.indexOf(russianAlphabet.charAt(indexWord)));
            }
        }
        System.out.println(cypherText+" --- Check the file \"viznerCypher.txt\"");
        wwf.writeToFile("viznerCypher.txt", cypherText);
    }
}
