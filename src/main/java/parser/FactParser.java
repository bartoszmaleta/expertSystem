package parser;

import model.Fact;
import model.FactRepository;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FactParser extends XMLParser {
    private FactRepository factRepository;

    public FactParser() {
        this.factRepository = new FactRepository();
        loadXmlDocument("src/main/resources/Facts.xml");
        parse();
    }


    private void parse() {
        NodeList factList = doc.getElementsByTagName("Fact");
        for (int i = 0; i < factList.getLength(); i++) {
            Node node = factList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                String factID = element.getAttribute("id");
                String factDescription = element.getChildNodes()
                        .item(1)
                        .getAttributes()
                        .item(0)
                        .getTextContent();

                Fact newFact = new Fact(factID, factDescription);

            }
        }
        // TODO
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }
}
