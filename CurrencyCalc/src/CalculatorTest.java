import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void exchangeCurrency() {
        Calculator calculator=new Calculator();
        double ratePLN = 4.6910;
        double rateDKK = 7.4427;
        double rateCAD = 1.3085;

        double[] values = {1.67,98.234,0.73,1.00009,2,123345.0934};

        for(int j = 0; j<values.length;j++){
            double resultPLN = ratePLN*values[j];
            BigDecimal decimalPLN = new BigDecimal(resultPLN);
            decimalPLN = decimalPLN.setScale(2, RoundingMode.HALF_UP);

            double resultDKK = rateDKK*values[j];
            BigDecimal decimalDKK = new BigDecimal(resultDKK);
            decimalDKK = decimalDKK.setScale(2, RoundingMode.HALF_UP);

            double resultCAD = rateCAD*values[j];
            BigDecimal decimalCAD = new BigDecimal(resultCAD);
            decimalCAD = decimalCAD.setScale(2, RoundingMode.HALF_UP);
            try {
                assertEquals(decimalPLN.doubleValue(),calculator.exchangeCurrency(values[j],"PLN"));
                assertEquals(decimalDKK.doubleValue(),calculator.exchangeCurrency(values[j],"DKK"));
                assertEquals(decimalCAD.doubleValue(),calculator.exchangeCurrency(values[j],"CAD"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}