import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("plik.txt");
            int bajt =fileInputStream.read();
            while ( bajt != -1) {
                System.out.print((char) bajt);
                bajt=fileInputStream.read();
            }
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
