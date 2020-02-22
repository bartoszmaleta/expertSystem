package parser;

import model.FactRepository;

public class FactParser extends XMLParser {
    private FactRepository factRepository;

    public FactParser() {
        this.factRepository = new FactRepository();
        loadXmlDocument("src/main/resources/Facts.xml");
        parse();
    }


    private void parse() {
        // TODO
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }
}
