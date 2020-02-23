package model;

import java.util.InputMismatchException;

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
}
