package sky.pro.course221.service;

import sky.pro.course221.model.Question;

import java.util.Collection;
import java.util.Random;

public interface QuestionService {
 Question add (String question, String answer);
 Question add (Question question);
 Question remove(Question question);
 Collection<Question> getAll();
 Question getRandomQuestion();

}
