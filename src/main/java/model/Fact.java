package model;

import java.util.Set;

public class Fact {
    private String id;
    private Set<String> evals;
    private String description;

    public Fact(String id, Set<String> evals, String description) {
        this.id = id;
        this.evals = evals;
        this.description = description;
    }

    public void addEval(String eval) {
        this.evals.add(eval);
    }

    public Set<String> getEvals() {
        return evals;
    }

    public void setFactValueById(String id, boolean value) {
//        TODO
    }

    public boolean getValueById(String id) {
//        int idInt = Integer.parseInt(id);
        for (String eval : evals) {
            if (eval.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return description;
    }
}
