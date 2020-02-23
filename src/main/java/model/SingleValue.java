package model;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends  Value {

    private String param;

    public SingleValue(String param, boolean selectionType) {
        this.param = param;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        List<String> paramList = new ArrayList<>();
        paramList.add(param);
        return paramList;
    }

    public String getParam() {
        return this.param;
    }
}
