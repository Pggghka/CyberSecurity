package com.vartanian.ssu;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class workingWithFile {
    public String readFile(String path){
        BufferedReader reader;
        String text = "";
        try {
            reader = new BufferedReader(new FileReader(
                    "src/main/resources/"+path));
            String line =  reader.readLine();
            while (line != null) {
                text+=line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public void writeToFile(String path, String text){
        try(FileWriter writer = new FileWriter("src/main/resources/"+path, false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
