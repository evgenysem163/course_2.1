package sky.pro.course221.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.course221.model.Question;
import sky.pro.course221.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping(path = "/{amount}")
    public Collection<Question> examinerRandomQuestion(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }



}
