import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Parser {
    private HashMap<String, Double> currencyRateMap=new HashMap<>();

    public Parser(){}

    public void readXML(String path){
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(path);

            Element element = doc.getDocumentElement();
            NodeList children = element.getElementsByTagName("Cube");

            for(int i=0;i<children.getLength();i++){
                Node child = children.item(i);
                if(child.getNodeType()==Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    if(!childElement.getAttribute("currency").isEmpty() && !childElement.getAttribute("rate").isEmpty()){
                        String currency = childElement.getAttribute("currency");
                        String rate = childElement.getAttribute("rate");

                        currencyRateMap.put(currency,Double.valueOf(rate));
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getCurrencyRate(String currency) throws Exception {
        if(!currencyRateMap.containsKey(currency) || currencyRateMap.isEmpty()){
            throw new Exception("There isn't that currency.");
        }else
            return currencyRateMap.get(currency);
    }
}
