package sky.pro.course221.service;

import sky.pro.course221.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);

}
