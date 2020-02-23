package parser;

import model.Answer;
import model.Question;
import model.SingleValue;
import model.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import repository.RuleRepository;

import java.util.List;

public class RuleParser extends XMLParser {
    private RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        loadXmlDocument("src/main/resources/Rules");
        parseRules(doc);
    }

    private void parseRules(Document document) {
        NodeList nodes = document.getElementsByTagName("Rule");

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeName().equals("Rule")) {
                ruleRepository.addQuestion(parseOneRule((Element) nodes.item((i))));
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
        return  new Question(id, questionDesc, answer);
    }

    private Value parseOneSelection(Element selection) {
        Boolean booleanValue = Boolean.valueOf(selection.getAttribute("value"));

        NodeList nodes = selection.getChildNodes();
        Node valueNode;
        String valueString;
        List<String> values;
        Value value = null;

        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeName().equals("SingleValue")) {
                valueNode = nodes.item(i).getAttributes().getNamedItem("value");
                valueString = valueNode.getNodeValue();
                value = new SingleValue(valueString, booleanValue);
            }
        }
        return  value;
    }


    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }
}
