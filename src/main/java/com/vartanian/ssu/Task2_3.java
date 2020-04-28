package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;

public class Task2_3 {
    public static void go() {
        String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        workingWithFile wwf = new workingWithFile();
        String text = StringUtils.lowerCase(wwf.readFile("russianText.txt"));
        System.out.println(russianAlphabet);
        double occurrence;
        System.out.println(text.length());
        String symbText = "";
        for (char symb : russianAlphabet.toCharArray()) {
            occurrence = StringUtils.countMatches(text, String.format("%s", symb));
            symbText += "\n\t|\t" + symb + "\t|\t" + String.format("%.3f", occurrence/text.replace(" ", "").length()) + "\t|";

        }
        System.out.println("Task2 " + symbText);
        wwf.writeToFile("symbText.txt", symbText);

        String symbPairText = "";
        double max = 0.000;
        String sy="";
        for (char symb : russianAlphabet.toCharArray()) {
            for (char symbPair : russianAlphabet.toCharArray()) {
                occurrence = StringUtils.countMatches(text, String.format("%s%s", symb, symbPair));
                if(occurrence>max){
                    max =occurrence;
                    sy = " " + symb + ""+ symbPair;
                }
                if(occurrence!=0.000) symbPairText += "\n\t|\t" + symb + symbPair + "\t|\t" + String.format("%.3f", occurrence/text.replace(" ", "").length()) + "\t|";
            }
        }
        System.out.println("Task3 " + symbPairText);
        System.out.println("max pair is" + sy);
        wwf.writeToFile("symbPairText.txt", symbPairText);
    }
}
