package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Task6 {
    public void go(){
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        Scanner in = new Scanner(System.in);
        workingWithFile wwf = new workingWithFile();
        String word = StringUtils.upperCase(wwf.readFile("viznerCypher.txt"));
        System.out.println("Enter key: "); String key = in.next();

        boolean Encryption = false;
        int modInd = word.length() % key.length();
        int fullCon = word.length() / key.length();
        String newKey = "";
        String cypherText = "";
        for (int i = 0; i < fullCon; i++) newKey+=key;
        for (int i = 0; i < modInd; i++) newKey+=key.charAt(i);
        for(int i = 0; i<word.length() ;i++){
            int indexWord = russianAlphabet.indexOf(word.charAt(i));
            int indexKey = russianAlphabet.indexOf(newKey.charAt(i));
            int cypherViznerIndex;
            if(Encryption) {
                 cypherViznerIndex = (indexWord + indexKey <= russianAlphabet.length() - 1) ? indexWord + indexKey : indexWord + indexKey - russianAlphabet.length() - 1;
            }
            else {
                cypherViznerIndex = (indexWord - indexKey >= 0) ? indexWord - indexKey : indexWord - indexKey + russianAlphabet.length() - 1;
            }
            cypherText += russianAlphabet.charAt(cypherViznerIndex);
        }
        System.out.println(cypherText);
        wwf.writeToFile("viznerCypher.txt", cypherText);
    }
}
