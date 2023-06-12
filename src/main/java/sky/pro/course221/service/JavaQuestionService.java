package sky.pro.course221.service;

import org.springframework.stereotype.Service;
import sky.pro.course221.exception.IsEmptyException;
import sky.pro.course221.exception.NotFindException;
import sky.pro.course221.model.Question;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> javaQuestion = new HashSet<>();
    private final Random random = new Random();
    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestion.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestion.contains(question)) {
            javaQuestion.remove(question);

            return question;
        }
        throw new NotFindException("такого нет");

    }
    @Override
    public Collection<Question> getAll() {
        List<Question> list = new ArrayList<>(javaQuestion);
        return list;
    }

    @Override
    public Question getRandomQuestion() {
        if(javaQuestion.isEmpty()){
            throw new IsEmptyException(" поле не может быть пустым");
        }
        List<Question> list = new ArrayList<>(javaQuestion);
        int number = random.nextInt(getAll().size());
        return list.get(number);
    }
}
