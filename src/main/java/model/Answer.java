package model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> values;
//    private List<Value> values = new ArrayList<>();

    public Answer() {
        this.values = new ArrayList<>();
    }

    boolean evaluateAnswerByInput(String input) throws InputMismatchException {
        for (Value value : values) {
            for (String pattern : value.getInputPattern()) {
                if (pattern.equals(input)) {
                    return value.getSelectionType();
                }
            }
        }
        throw new InputMismatchException("This answer is not in database. Please try different answer.");
    }

    public void addValue(Value value) {
        values.add(value);
    }

    public List<Value> getValues() {
        return this.values;
    }
}
