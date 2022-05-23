package torres.benjamin.demo.domain.service;

import torres.benjamin.demo.domain.exception.QuestionCreationException;
import torres.benjamin.demo.domain.exception.QuestionNotFoundException;
import torres.benjamin.demo.domain.model.Question;

import java.util.List;

public interface QuestionService {
    Question createQuestion(Question question) throws QuestionCreationException;
    Question findById(Long id) throws QuestionNotFoundException;
    List<Question> getAllQuestions();
    void deleteQuestion(Long id) throws QuestionNotFoundException;
    Question updateQuestion(Question question) throws QuestionNotFoundException;





}
