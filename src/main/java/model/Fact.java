package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    private String id;
    private Set<String> evals;
    private String description;
    private Map<String, Boolean> properties;

    public Fact(String id,  String description) {
        this.id = id;
        this.description = description;
        this.properties = new HashMap<>();
    }

    public Map<String, Boolean> getProperties() {
        return properties;
    }

    public void setFactValueById(String id, boolean value) {
        this.properties.put(id, value);
    }

    public Set<String> getEvals() {
        return evals;
    }

    public boolean getValueById(String id) {
        boolean value = properties.get(id);
        return  value;
    }

    // TODO
//    public boolean getValueById(String id) {
////        int idInt = Integer.parseInt(id);
//        for (String eval : evals) {
//            if (eval.equals(id)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public String getDescription() {
        return description;
    }
}
