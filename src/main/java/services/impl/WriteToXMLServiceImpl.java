package services.impl;

import models.Athlete;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;
import services.WriteDataService;
import utils.ParseUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * Created by Aurimas on 24/09/15.
 * Implementation of WriteDataService interface for writing results to xml file.
 */
public class WriteToXMLServiceImpl implements WriteDataService {

    public static final String STYLE_FILE = "tableStyle.xsl";

    @Override
    public void write(String filePath, List<Athlete> athletes) {
        System.out.println("Start write results");
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();


            Document doc = docBuilder.newDocument();
            doc.setXmlStandalone(true);
            String stylePath = this.getClass().getClassLoader().getResource(STYLE_FILE).getPath();
            // Attaching style
            ProcessingInstruction pi = doc.createProcessingInstruction("xml-stylesheet", "type=\"text/xsl\" href=\""+ stylePath + "\"");

            // Root elements
            Element rootElement = doc.createElement("table");
            doc.appendChild(rootElement);
            doc.insertBefore(pi, rootElement);

            for (Athlete athlete : athletes) {
                Element row = doc.createElement("row");
                rootElement.appendChild(row);
                appendRow("name", athlete.getName(), doc, row);
                appendRow("totalScore", "" + athlete.getTotalScore(), doc, row);
                appendRow("place", athlete.getPlace(), doc, row);
                appendRow("meter100", "" + athlete.getMeter100(), doc, row);
                appendRow("longJump", "" + athlete.getLongJump(), doc, row);
                appendRow("shotPut", "" + athlete.getShotPut(), doc, row);
                appendRow("highJump", "" + athlete.getHighJump(), doc, row);
                appendRow("meter400", "" + athlete.getMeter400(), doc, row);
                appendRow("hurdles", "" + athlete.getHurdles(), doc, row);
                appendRow("discusThrow", "" + athlete.getDiscusThrow(), doc, row);
                appendRow("poleVault", "" + athlete.getPoleVault(), doc, row);
                appendRow("javelinThrow", "" + athlete.getJavelinThrow(), doc, row);
                appendRow("meter1500", ParseUtils.getMin(athlete.getMeter1500()), doc, row);
            }

            // Writing the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

             //Output to console for testing
             //StreamResult result = new StreamResult(System.out);

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        System.out.println("Finish write results to file path: " + filePath);
    }

    /**
     * Appending row element (adding cell)
     * @param head
     * @param value
     * @param doc
     * @param row
     */
    private void appendRow(String head, String value, Document doc, Element row){
        Element name = doc.createElement(head);
        name.appendChild(doc.createTextNode(value));
        row.appendChild(name);
    }

}
