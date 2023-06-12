package sky.pro.course221.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.course221.exception.QuestionLimitException;
import sky.pro.course221.model.Question;

import java.util.Collection;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;
    private final Collection<Question> questions = Set.of(
            new Question("g1", "a1"),
            new Question("g2", "a2"),
            new Question("g3", "a3"),
            new Question("g4", "a4"),
            new Question("g5", "a5")

    );

    @Test
    public void getQuestionNegativeTest() {
        when(questionService.getAll()).thenReturn(questions);
        Assertions.assertThatExceptionOfType(QuestionLimitException.class).isThrownBy(() ->
                examinerService.getQuestions(-1)
        );
        Assertions.assertThatExceptionOfType(QuestionLimitException.class).isThrownBy(() ->
                examinerService.getQuestions(questions.size() + 1));
    }

    @Test
    public void getQuestionTest() {
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("g4", "a4"),
                new Question("g4", "a4"),
                new Question("g5", "a5"),
                new Question("g2", "a2")
        );
        Assertions.assertThat(examinerService.getQuestions(3)).hasSize(3).containsExactlyInAnyOrder(
                new Question("g4", "a4"),
                new Question("g2", "a2"),
                new Question("g5", "a5")
        );


    }

}
