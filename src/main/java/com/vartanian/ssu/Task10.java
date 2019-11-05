package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;
import java.util.Scanner;

public class Task10 {
    public void go(){
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ0123456789!,.?";
        Scanner in = new Scanner(System.in);
        workingWithFile wwf = new workingWithFile();
        boolean Encryption = false;
        String text = StringUtils.upperCase(wwf.readFile("transposition.txt"));
        System.out.println("Enter your key: "); String key = in.next().toUpperCase();
        System.out.println("Do you want to Encrypt(1) or Decrypt(0)? : ");
        if(in.nextInt()==1) Encryption = true;

        int stroki = (int)Math.ceil(text.length()/(double)key.length());
        int stolbzi = key.length();

        int k =1;
        Integer[] keyPos = new Integer[key.length()];
        for (char symb : russianAlphabet.toCharArray()) {
            for (int i =0; i<key.length(); i++){
                if(key.charAt(i) == symb){
                    keyPos[i]= k;
                    k++;
                }
            }
        }

        String Message = "";
        if(Encryption) {
            text = text.replace(" ", "");
            Character[][] cypherMatrix = new Character[stroki][stolbzi];
            for (int i = 0; i < stroki; i++) {
                for (int j = 0; j < stolbzi; j++) {
                    if (!(i * stolbzi + j >= text.length())) {
                        cypherMatrix[i][j] = text.charAt(i * stolbzi + j);
                    } else cypherMatrix[i][j] = '-';
                }
            }

            for (int i = 0; i < stroki; i++) {
                System.out.println();
                for (int j = 0; j < stolbzi; j++) {
                    System.out.print(cypherMatrix[i][j]);
                }
            }

            for (int i = 1; i <= key.length(); i++) {
                for (int index = 0; index < key.length(); index++) {
                    if (keyPos[index] == i) {
                        for (int stroka = 0; stroka < stroki; stroka++) {
                            Message += cypherMatrix[stroka][index];
                        }
                        Message += " ";
                    }
                }
            }
        }
        else {
            String[] encryptedMessage = text.split(" ");
            for (int str = 0; str < stroki -1; str++) {
                for (int stolbez = 0; stolbez < key.length(); stolbez++) {
                    Message += encryptedMessage[keyPos[stolbez] - 1].charAt(str);
                }
            }
        }

        wwf.writeToFile("transposition.txt", Message);
    }

}
