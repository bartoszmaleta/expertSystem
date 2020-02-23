import model.Fact;
import model.Question;
import repository.FactRepository;
import parser.FactParser;
import parser.RuleParser;
import repository.RuleRepository;

import java.util.*;

public class ESPProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    private Map<String, Boolean> userAnswears;

    public ESPProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
        this.userAnswears = new TreeMap<>();
    }


    public void collectAnswers() {
        while (ruleRepository.getIterator().hasNext()) {
            Question question = ruleRepository.getIterator().next();
            userAnswears.put(question.getId(), validateUserInput(question));
            System.out.println(userAnswears); // TODO: delete later
        }
    }

    private Boolean validateUserInput(Question question) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        Boolean validatedAnswer = null;

        while (!valid) {
            try {
                System.out.println(question.getQuestion());
                String answer = scanner.nextLine();
                validatedAnswer = question.getEvaluatedAnswer(answer);

                valid = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return validatedAnswer;

    }


    public String evaluate() {
        String match = null;
        Iterator<Fact> factIterator = factRepository.getIterator();

        while (factIterator.hasNext()) {
            Fact fact = factIterator.next();
            if (fact.getProperties().equals(this.userAnswears)) {
                match = fact.getDescription();
            }
        }
        return match;
    }

}
