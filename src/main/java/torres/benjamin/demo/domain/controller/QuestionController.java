package torres.benjamin.demo.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import torres.benjamin.demo.domain.exception.QuestionCreationException;
import torres.benjamin.demo.domain.exception.QuestionNotFoundException;
import torres.benjamin.demo.domain.model.Question;
import torres.benjamin.demo.domain.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }
    @PostMapping("")
    public ResponseEntity<Question> create(@RequestBody Question question) throws QuestionCreationException {
        question = questionService.createQuestion(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws QuestionNotFoundException {
       questionService.deleteQuestion(id);
       return ResponseEntity.ok().body(null);
    }
    @PutMapping("")
    public ResponseEntity<Question> update(@RequestBody Question question) throws QuestionNotFoundException{
        question = questionService.updateQuestion(question);
        return new ResponseEntity<>(question,HttpStatus.ACCEPTED);
    }
}
