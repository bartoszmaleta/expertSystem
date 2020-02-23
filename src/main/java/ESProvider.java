import model.Fact;
import model.Question;
import repository.FactRepository;
import parser.FactParser;
import parser.RuleParser;
import repository.RuleRepository;

import java.util.*;

public class ESProvider {

    private RuleRepository ruleRepository;
    private FactRepository factRepository;

    private Map<String, Boolean> userAnswers;

    ESProvider(FactParser factParser, RuleParser ruleParser) {
        ruleRepository = ruleParser.getRuleRepository();
        factRepository = factParser.getFactRepository();
        userAnswers = new TreeMap<>();
    }

    public void collectAnswers() {
        while (ruleRepository.getIterator().hasNext()) {
            Question question = ruleRepository.getIterator().next();
            userAnswers.put(question.getId(), validateUserInput(question));
            System.out.println(userAnswers); // test use only TODO: delete for production
        }
    }

    private Boolean validateUserInput(Question q) {
        Scanner in = new Scanner(System.in);
        boolean success = false;
        Boolean validatedAnswer = null;
        while (!success) {
            try {
                System.out.printf("%n%s ", q.getQuestion());
                String answer = in.nextLine();
                validatedAnswer = q.getEvaluatedAnswer(answer);
                success = true;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
        return validatedAnswer;
    }

    String evaluate() {
        String match = null;
        Iterator<Fact> factIterator = factRepository.getIterator();

        while(factIterator.hasNext() ) {
            Fact fact = factIterator.next();
            if(fact.getFields().equals(this.userAnswers)) {
                match = fact.getDescription();
            }
        }
        return match;
    }

}
