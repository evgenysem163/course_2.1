package sky.pro.course221.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.course221.model.Question;
import sky.pro.course221.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaController {
    private final QuestionService questionService;


    public JavaController(QuestionService questionService) {
        this.questionService = questionService;

    }
    @GetMapping(path = "/add")
    public Question javaQuestionAdd(@RequestParam(required = false,
            value = "question")String question, @RequestParam(required = false,
            value = "answer")String answer){
        return questionService.add(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question javaQuestionRemove(@RequestParam( required = false,
    value = "question") String question, @RequestParam (required = false,
    value = "answer")String answer){
        return questionService.remove(new Question(question,answer));

    }
    @GetMapping(path="/getAll")
    public Collection<Question> javaQuestionPrint(){
        return questionService.getAll();
    }



}
