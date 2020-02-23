package model;

import java.util.List;

public abstract class Value {
    boolean selectionType;

    public abstract List<String> getInputPattern();

    public boolean getSelectionType() {
        return  this.selectionType;
    }
}
