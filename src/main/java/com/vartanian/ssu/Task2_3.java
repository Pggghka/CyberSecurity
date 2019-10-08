package com.vartanian.ssu;

import org.apache.commons.lang3.StringUtils;

public class Task2_3 {
    public static void go() {
        String russianAlphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        workingWithFile wwf = new workingWithFile();
        String text = StringUtils.lowerCase(wwf.readFile("russianText.txt"));

        int occurrence;
        String symbText = "";
        for (char symb : russianAlphabet.toCharArray()) {
            occurrence = StringUtils.countMatches(text, String.format("%s", symb));
            symbText += "\n\t|\t" + symb + "\t|\t" + occurrence + "\t|";
        }
        System.out.println("Task2 " + symbText);
        wwf.writeToFile("symbText.txt", symbText);

        String symbPairText = "";
        for (char symb : russianAlphabet.toCharArray()) {
            for (char symbPair : russianAlphabet.toCharArray()) {
                occurrence = StringUtils.countMatches(text, String.format("%s%s", symb, symbPair));
                symbPairText += "\n\t|\t" + symb + symbPair + "\t|\t" + occurrence + "\t|";
            }
        }
        System.out.println("Task3 " + symbPairText);
        wwf.writeToFile("symbPairText.txt", symbPairText);
    }
}
