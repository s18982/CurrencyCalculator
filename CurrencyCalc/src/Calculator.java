import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculator {
    private Parser parser =  new Parser();
    public Calculator(){
        this.parser.readXML("eurofxref-daily.xml");
    }
    public double exchangeCurrency(double amountEUR, String currency) throws Exception {
        try {
            double rate = parser.getCurrencyRate(currency);
            double result = rate*amountEUR;
            BigDecimal decimal = new BigDecimal(result);
            decimal = decimal.setScale(2, RoundingMode.HALF_UP);
            return decimal.doubleValue();
        } catch (Exception e) {
            throw e;
        }
    }

    public String getCurrenciesToString(){
        String message = "";
        for (String str: parser.getCurrencies()) {
            message+=str;
            message+=" ";
        }
        return message;
    }
}
