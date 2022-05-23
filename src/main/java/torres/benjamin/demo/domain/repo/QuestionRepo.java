package torres.benjamin.demo.domain.repo;

import org.springframework.data.repository.CrudRepository;
import torres.benjamin.demo.domain.model.Question;

public interface QuestionRepo extends CrudRepository<Question, Long> {

}
