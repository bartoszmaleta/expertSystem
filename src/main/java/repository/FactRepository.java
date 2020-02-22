package repository;

import model.Fact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {
    private List<Fact> facts;
    private Iterator<Fact> factIterator;

    public FactRepository() {
        this.facts = new ArrayList<>();
        this.factIterator = new FactIterator();
    }

    public List<Fact> getFacts() {
        return facts;
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return factIterator;
    }

    private class FactIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            if (index < facts.size()) {
                return true;
            }
            return false;

            //            One line solution!!!!
//            return index < facts.size();
        }

        @Override
        public Fact next() {
            if (this.hasNext()) {
                return facts.get(index++);
            }
            return null;

//            One line solution!!!!
//            return hasNext() ? facts.get(index++) : null;
        }
    }
}
