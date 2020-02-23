package model;

import java.util.List;

public abstract class Value {
    boolean selectionType;

    public abstract List<String> getInputPattern();

    boolean getSelectionType() {
        return this.selectionType;
    }
}
