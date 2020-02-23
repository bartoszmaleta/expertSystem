package model;

import java.util.HashMap;
import java.util.Map;

public class Fact {
    private String id;
    private String description;
    private Map<String, Boolean> fields;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.fields = new HashMap<>();
    }

    public Map<String, Boolean> getFields() {
        return this.fields;
    }

    public void setFactValueById(String id, boolean value) {
        this.fields.put(id, value);
    }

    public String getDescription() {
        return this.description;
    }
}
