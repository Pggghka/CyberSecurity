package com.vartanian.ssu;

import java.io.*;
import java.math.BigInteger;

public class Task1 {
    public static int gcd(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static triplBig gcdWide(BigInteger a, BigInteger b)
    {
        triplBig temphere = new triplBig(a,BigInteger.ONE,BigInteger.ZERO);
        triplBig temphere2 = new triplBig();
        if(b == BigInteger.ZERO)
        {
            return temphere;
        }
        temphere2 = gcdWide(b, a.mod(b));
        temphere = new triplBig();
        temphere.d=  temphere2.d;
        temphere.x = temphere2.y;
        temphere.y = temphere2.x.subtract(a.divide(b).multiply(temphere2.y));
        return temphere;
    }

    public static void Cypher(int n, int m, int k, String alphabet,boolean Encryption){
        String text="";
        int nmod = gcdWide(BigInteger.valueOf(n), BigInteger.valueOf(m)).x.intValue();
        try(FileReader reader = new FileReader("src/main/resources/cezar.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                boolean isUpp = false;
                if (Character.isUpperCase(c)){
                    isUpp = true;
                    c=Character.toLowerCase(c);
                }
                int index = alphabet.indexOf(c);
                if (index == -1)break;
                int cypher = Encryption ? (n * index +k) % m : (int) (nmod * (index + m - k)  % m);
                char newC = isUpp ? Character.toUpperCase(alphabet.charAt(cypher)) : alphabet.charAt(cypher);
                text+=newC;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        File file = new File("src/main/resources/cezar.txt");
        PrintWriter printWriter = null;

        try
        {
            printWriter = new PrintWriter(file);
            printWriter.println(text);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if ( printWriter != null )
            {
                printWriter.close();
            }
        }
    }
}
