import java.io.*;
import java.lang.String;
import java.math.*;
import java.io.PrintWriter;

public class Cezar {

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

    public static void Cypher(int n, int m, int k, String alphabet,boolean Encryption){
        String text="";

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
                int cypher = Encryption ? (n * index +k) % m : (int) (16 * (index + m - k)  % m);
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

    public static void main(String[] args) {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789!,.?";
        //String alphabet ="abcdefghijklmnopqrstuvwxyz";
        int n = 3, k = 4;
        int m = alphabet.length();
        System.out.println("Total symbols in the alphabet:" + m);
        System.out.println("GCD is - " + gcd(n,m));
        Cypher(n,m,k,alphabet,false);
    }
}