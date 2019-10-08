package com.vartanian.ssu;

import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public void Encryption(Character[][] matrix){
        workingWithFile wwf1 = new workingWithFile();
        String encryptedMessage = "";
        String message = wwf1.readFile("polibia.txt");
        System.out.print("\n" + message);
        char[] messageSymbols =  message.toCharArray();
        for(char messageSymbol : messageSymbols) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][j]!=null && messageSymbol == matrix[i][j]) {
                        encryptedMessage += Integer.toString(i) + Integer.toString(j);
                    }
                }
            }
        }
        System.out.println("\nEncrypted message:" + encryptedMessage);
        wwf1.writeToFile("polibia.txt", encryptedMessage);
    }

    public void Decryption (Character[][] matrix){
        workingWithFile wwf1 = new workingWithFile();
        String decryptedMessage = "";
        String symbol;
        String message = wwf1.readFile("polibia.txt");
        System.out.println();
        System.out.print("\n" + message);
        for(int i = 0; i<message.length();i+=2) {
            decryptedMessage += matrix[Character.getNumericValue(message.charAt(i))][Character.getNumericValue(message.charAt(i + 1))];
        }
        System.out.println("\nDecrypted message:" + decryptedMessage);
        wwf1.writeToFile("polibia.txt", decryptedMessage);
    }

    public void polibiaQadr (){
        String alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ0123456789!,.?";
        double a = Math.sqrt(alphabet.length());
        int n = (int)a;
        int index = 0;
        if (a-n!=0.0)n+=1;
        System.out.println(alphabet.length());

        Character[][] matrix = new Character[n][n];
        //Filling the array with chars
        for (int i = 0; i < n; i++){
            for (int j = 0; j<n; j++){
                if(index != alphabet.length()) matrix[i][j] = (alphabet.charAt(index++));
            }
        }

        System.out.println("\t\t0\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6");
        System.out.println("\t------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + i +"|");
            for (int j = 0; j < n; j++) {
                System.out.print("\t"+matrix[i][j]+"\t");
            }
            System.out.println();

        }
        //Encryption(matrix);
        Decryption(matrix);
    }
}
