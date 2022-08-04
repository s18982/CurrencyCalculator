import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try {
            System.out.println("Instruction:\n\nYou can convert Euros to the other currency from the below list: \n"
                                +calculator.getCurrenciesToString()+"\nExample of correct data format:\n43,20 USD\n\n");

            Scanner scanner = new Scanner(System.in);

            System.out.println("Write amount in EUR and new currency: ");
            while (scanner.hasNext()) {
                double amount = scanner.nextDouble();
                String currency = scanner.next();
                try {
                    System.out.println(calculator.exchangeCurrency(amount, currency)+" "+currency);
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
                System.out.println("If you want to continue calculating, press 'y' \nIf you want to exit, press any key.");
                if(!scanner.next().equals("y"))
                    return;
                else
                    System.out.println("Write amount in EUR and new currency: ");
            }
        }catch (InputMismatchException ex){
            System.err.println("The value is invalid.");
        }

    }
}
