package torres.benjamin.demo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import torres.benjamin.demo.domain.exception.QuestionCreationException;
import torres.benjamin.demo.domain.exception.QuestionNotFoundException;
import torres.benjamin.demo.domain.model.Question;
import torres.benjamin.demo.domain.repo.QuestionRepo;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepo questionRepo;
    @Autowired
    public QuestionServiceImpl(QuestionRepo questionRepo){
        this.questionRepo= questionRepo;
    }
    @Override
    public Question createQuestion(Question question) throws QuestionCreationException {
        return questionRepo.save(question);
    }

    @Override
    public Question findById(Long id) throws QuestionNotFoundException {
        return findQuestionById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return (List) questionRepo.findAll();
    }

    @Override
    public void deleteQuestion(Long id) throws QuestionNotFoundException {
        Question questionToRemove = findQuestionById(id);
        questionRepo.delete(questionToRemove);

    }

    @Override
    public Question updateQuestion(Question question) throws QuestionNotFoundException {
        findQuestionById(question.getId());
        return questionRepo.save(question);

    }

    private Question findQuestionById(Long id) throws QuestionNotFoundException{
        Optional<Question> questionOptional = questionRepo.findById(id);
        if (questionOptional.isEmpty())
            throw new QuestionNotFoundException("Question not found");
        return questionOptional.get();
    }
}
