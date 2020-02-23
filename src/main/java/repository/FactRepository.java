package repository;

import model.Fact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {

    private Iterator<Fact> factIterator;
    private List<Fact> facts;

    public FactRepository() {
        factIterator = new FactIterator();
        facts = new ArrayList<>();
    }

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public Iterator<Fact> getIterator() {
        return factIterator;
    }

    private class FactIterator implements Iterator<Fact> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index < facts.size();
        }

        @Override
        public Fact next() {
            return hasNext() ? facts.get(index++) : null;
        }
    }
}
