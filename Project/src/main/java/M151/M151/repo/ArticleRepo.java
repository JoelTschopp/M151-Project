package M151.M151.repo;

import M151.M151.model.Article;
import M151.M151.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Long> {
    Article findById(long id);
}
