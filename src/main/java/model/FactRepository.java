package model;

import java.util.Iterator;
import java.util.List;

public class FactRepository {
    private List<Fact> facts;
    private int size;

    public FactRepository(List<Fact> facts) {
        this.facts = facts;
    }

    public List<Fact> getFacts() {
        return facts;
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    private class FactIterator implements Iterator {
        int index;


        @Override
        public boolean hasNext() {
            if (index < facts.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Fact next() {
            if (this.hasNext()) {
                return facts.get(index++);
            }
            return null;
        }

        // TODO: remove?
    }

    public Iterator getIterator() {
        return new FactIterator();
    }
}
