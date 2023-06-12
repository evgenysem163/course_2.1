package sky.pro.course221.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sky.pro.course221.exception.QuestionLimitException;
import sky.pro.course221.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
@Component
public class ExaminerServiceImpl implements ExaminerService{
private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = questionService.getAll().size();
        if(amount > size|| amount<=0) {
            throw new QuestionLimitException("превышет лимит");
        }
        Set<Question> questions= new HashSet<>();
        while (questions.size()<amount){
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }


}
