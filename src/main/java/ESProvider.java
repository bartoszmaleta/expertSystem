import model.Fact;
import model.MultipleValue;
import model.Question;
import model.Value;
import repository.FactRepository;
import parser.FactParser;
import parser.RuleParser;
import repository.RuleRepository;

import javax.swing.plaf.multi.MultiInternalFrameUI;
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

    private Boolean validateUserInput(Question question) {
        Scanner in = new Scanner(System.in);
        boolean success = false;
        Boolean validatedAnswer = null;
        while (!success) {
            try {
                System.out.println("\n" + question.getQuestion());

                question.displayPossibleAnswers();

                String answer = in.nextLine();
                validatedAnswer = question.getEvaluatedAnswer(answer);
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
