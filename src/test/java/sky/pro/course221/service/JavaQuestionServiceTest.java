package sky.pro.course221.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.course221.exception.NotFindException;
import sky.pro.course221.model.Question;

public class JavaQuestionServiceTest {
    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        javaQuestionService.add("g1", "a1");
        javaQuestionService.add("g2", "a2");
        javaQuestionService.add("g3", "a3");
    }

    @AfterEach
    public void afterEach() {
        javaQuestionService.getAll().forEach(question -> javaQuestionService.remove(question));
    }

    @Test
    public void questionAddTest() {
        Question expected = new Question("g4", "a4");
        Assertions.assertThat(javaQuestionService.add("g4", "a4")).isEqualTo(expected).
                isIn(javaQuestionService.getAll());
    }

    @Test
    public void questionRemoveTest() {
        Question expected = new Question("g2", "a2");
        org.junit.jupiter.api.Assertions.assertDoesNotThrow(() -> javaQuestionService.remove(expected));
    }

    @Test
    public void questionNegativeTest() {
        Question expected = new Question("g5", "a5");
        org.junit.jupiter.api.Assertions.assertThrows(NotFindException.class,
                () -> javaQuestionService.remove(expected));
    }

    @Test
    public void questionGetAllTest() {
        Assertions.assertThat(javaQuestionService.getAll()).hasSize(3)
                .containsExactlyInAnyOrder(new Question("g1", "a1"),
                        new Question("g2", "a2"),
                        new Question("g3", "a3")
                );
    }

}
