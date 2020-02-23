import parser.FactParser;
import parser.RuleParser;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello World");
        System.out.println("hello World");
        System.out.println("hello World");


        FactParser factParser = new FactParser();
        RuleParser ruleParser = new RuleParser();

        ESProvider esProvider = new ESProvider(factParser, ruleParser);
        esProvider.collectAnswers();
        System.out.println(esProvider.evaluate());
    }


}
