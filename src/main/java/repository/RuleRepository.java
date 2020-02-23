package repository;

import model.Question;

import java.util.*;

public class RuleRepository {
    //        TODO
    private Iterator<Question> questionIterator;
    private Map<String, Question> questions;

    public RuleRepository() {
        questionIterator = new QuestionIterator();
        questions = new HashMap<>();
    }

    public void addQuestion(Question question) {
        questions.put(question.getId(), question);
    }

    public Iterator<Question> getIterator() {
        return questionIterator;
    }

    private class QuestionIterator implements Iterator<Question> {
        int index = 0;
        List<String> keyList;


        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Question next() {
            if (keyList == null) {
                keyList = new ArrayList<>(questions.keySet());
            }

            String key = keyList.get(index++);
            return questions.get(key);
        }
    }
}
