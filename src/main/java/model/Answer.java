package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) {
        for (Value value : values) {
            for (String pattern : value.getInputPattern()) {
                if (pattern.equals(input)) {
                    return  value.getSelectionType();
                }
            }
        }
        throw new InputMismatchException("There is not answer like this in xml.\nEnter different.");
    }

    public void addValue(Value value) {
        values.add(value);
    }
}
