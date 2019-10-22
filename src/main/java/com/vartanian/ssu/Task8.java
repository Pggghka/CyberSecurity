package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Task8 {
    public void go(){
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ.?0123456789!,";
        Scanner in = new Scanner(System.in);
        workingWithFile wwf = new workingWithFile();
        String text = StringUtils.upperCase(wwf.readFile("pairedCypher.txt"));

        System.out.println("Enter key which must be >= 21: "); String key = in.next().toUpperCase();

        //symbols that are not in key
        String pairedAlphabet = "";
        for (char symbol : russianAlphabet.toCharArray()) if (!key.contains(symbol+"")) pairedAlphabet +=symbol;
        System.out.println(key + "\n" + pairedAlphabet);

        //encrypting or decrypting message (the same algorithm)
        String cyphMessage = "";
        for (char symbol : text.toCharArray())
            cyphMessage += key.contains(symbol+"") ? pairedAlphabet.charAt(key.indexOf(symbol)) : key.charAt(pairedAlphabet.indexOf(symbol));

        // ЖЕЛЕЗНЫЙШПИЦЪДОМА03478?!
        System.out.println(cyphMessage);
        wwf.writeToFile("pairedCypher.txt", cyphMessage);

    }
}
