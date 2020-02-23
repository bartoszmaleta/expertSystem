package parser;

import model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import repository.RuleRepository;

import java.util.Arrays;
import java.util.List;

public class RuleParser extends XMLParser {

    private RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        loadXmlDocument("src/main/resources/Rules.xml");
        parseRules(doc);
    }

    private void parseRules(Document document) {

        NodeList nodes = document.getElementsByTagName("Rule");

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeName().equals("Rule")) {
                ruleRepository.addQuestion(parseOneRule((Element) nodes.item(i)));
            }
        }
    }

    private Question parseOneRule(Element rule) {

        String id = rule.getAttribute("id");

        Element questionElem = (Element) rule.getElementsByTagName("Question").item(0);
        String questionDesc = questionElem.getTextContent();

        Element answerElem = (Element) rule.getElementsByTagName("Answer").item(0);
        NodeList selections = answerElem.getElementsByTagName("Selection");

        Answer answer = new Answer();

        for (int i = 0; i < selections.getLength(); i++) {
            if (selections.item(i).getNodeName().equals("Selection")) {
                answer.addValue(parseOneSelection((Element) selections.item(i)));
            }
        }
        return new Question(id, questionDesc, answer);
    }

    private Value parseOneSelection(Element selection) {

        Boolean booleanValue = Boolean.valueOf(selection.getAttribute("value"));

        NodeList nodesList = selection.getChildNodes();
        Node valueNode;
        String valueStr;
        List<String> values;
        Value value = null;

        for (int i = 0; i < nodesList.getLength(); i++) {
            if (nodesList.item(i).getNodeName().equals("SingleValue")) {
                valueNode = nodesList.item(i).getAttributes().getNamedItem("value");
                valueStr = valueNode.getNodeValue();
                value = new SingleValue(valueStr, booleanValue);

            }
            if (nodesList.item(i).getNodeName().equals("MultipleValue")) {
                valueNode = nodesList.item(i).getAttributes().getNamedItem("value");
                valueStr = valueNode.getNodeValue();
                values = Arrays.asList(valueStr.split(","));
                value = new MultipleValue(values, booleanValue);

//                for (String elem : values) {
//                    System.out.println(elem);
//                }

            }
        }
        return value;
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }
}
