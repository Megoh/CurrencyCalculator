package pl.dominikwolowicz;

import it.svario.xpathapi.jaxp.XPathAPI;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import pl.dominikwolowicz.utils.FileResourcesUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathException;

import java.io.*;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class FileCurrencyParser implements CurrencyParser {
    public BigDecimal getCurrencyRate(String currency) {
        Logger logger = Logger.getLogger(FileCurrencyParser.class.getName());

        try (BufferedInputStream fileResourcesUtils =
                     FileResourcesUtils.getFileFromResourceAsStream(Paths.FILENAME.getValue())) {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(fileResourcesUtils);

            String xpath = Paths.XPATH.getValue();
            NodeList testConfig = XPathAPI.selectNodeList(document, xpath);

            for (int i = 0; i < testConfig.getLength(); i++) {
                NamedNodeMap attributes = testConfig.item(i).getAttributes();
                if (attributes.getNamedItem("currency").getTextContent().equals(currency)) {
                    return new BigDecimal(attributes.getNamedItem("rate").getTextContent());
                }
            }
        } catch (FileNotFoundException e) {
            logger.warning("Cannot find file.");
        } catch (IOException e) {
            logger.warning("Failed to open file.");
        } catch (XPathException | SAXException | ParserConfigurationException e) {
            logger.warning("Failed to parse document.");
        }

        throw new NullPointerException();
    }
}
