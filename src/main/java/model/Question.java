package model;

import java.util.InputMismatchException;
import java.util.List;

public class Question {
    private String id;
    private String question;
    private Answer answer;

    public Question(String id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public String getId() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public boolean getEvaluatedAnswer(String input) throws InputMismatchException {
        return answer.evaluateAnswerByInput(input);
    }

    public Answer getAnswer() {
        return this.answer;
    }

    public void displayPossibleAnswers() {
        List<Value> possibleAnswersList = getAnswer().getValues();
        for (Value possibleAnswer : possibleAnswersList) {
            if (possibleAnswer instanceof MultipleValue) {
                MultipleValue possibleAnswerCast = (MultipleValue) possibleAnswer;
                List<String> possAnswersList = possibleAnswerCast.getParams();
                for (String possAnswer : possAnswersList) {
                    System.out.print(possAnswer + ", ");
                }
            }
        }
        System.out.println();
    }
}
