package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> values = new ArrayList<>();

    boolean evaluateAnswerByInput(String input) throws InputMismatchException {

        for (Value value : values) {
            for (String pattern : value.getInputPattern()) {
                if (pattern.equals(input)) {
                    return value.getSelectionType();
                }
            }
        }
        throw new InputMismatchException("We don't have this answer in our database.\nPlease try another one.");
    }

    public void addValue(Value value) {
        values.add(value);
    }
}
