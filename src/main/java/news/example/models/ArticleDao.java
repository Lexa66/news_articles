package news.example.models;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArticleDao extends CrudRepository<Article, Long> {

}
