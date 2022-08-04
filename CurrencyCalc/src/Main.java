public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            System.out.println(calculator.exchangeCurrency(100,"PLN"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
