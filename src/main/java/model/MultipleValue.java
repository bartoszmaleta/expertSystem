package model;

import java.util.List;

public class MultipleValue extends Value {

    private List<String> params;

    public MultipleValue(List<String> params, boolean selectionType) {
        this.params = params;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return params;
    }

    public List<String> getParams() {
        return this.params;
    }
}