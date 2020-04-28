package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class Task7 {
    public String cypher (String text, String alphabet, String cypherAlphaber, boolean method){
        String output = ""; int index;
        if (method) for (char symbolRU : text.toCharArray()) output += cypherAlphaber.charAt(alphabet.indexOf(symbolRU));
        else for (char symbolRU : text.toCharArray()) output += alphabet.charAt(cypherAlphaber.indexOf(symbolRU));
        return output;
    }
    public void go(){
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        Scanner in = new Scanner(System.in);
        workingWithFile wwf = new workingWithFile();
        String text = StringUtils.upperCase(wwf.readFile("cezarWithKey.txt"));
        System.out.println("Enter key: "); String key = in.next().toUpperCase();
        System.out.println("Enter k: "); int k = in.nextInt();
        boolean Encryption = false;
        System.out.println("Do you want to Encrypt(1) or Decrypt(0)? : ");
        if(in.nextInt()==1) Encryption = true;

        String cypherAlphabet = key; int index = k - 1 ;
        for(char symbolRU : russianAlphabet.toCharArray()){
            if (!cypherAlphabet.contains(symbolRU+"")) cypherAlphabet += symbolRU;
            if (index++ >= russianAlphabet.length()-1) break;
        }
        String newCypherAlphabet = "";
        for(int i = k-1; i > 0; i--) newCypherAlphabet += russianAlphabet.charAt(russianAlphabet.length()-i);
        newCypherAlphabet+=cypherAlphabet;
        System.out.println(russianAlphabet + "\n" + newCypherAlphabet + "\n" + text);

        System.out.println(cypher(text, russianAlphabet, newCypherAlphabet, Encryption));
        wwf.writeToFile("cezarWithKey.txt", cypher(text, russianAlphabet, newCypherAlphabet, Encryption));
    }
}
