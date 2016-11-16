package news.example.controllers;
import news.example.models.Article;
import news.example.models.ArticleDao;
import news.example.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ArticleController {
    @Autowired
    private ArticleDao articleDao;

    @RequestMapping("/")
    String home(){
        return "home";
    }

    @RequestMapping("/get")
    @ResponseBody
    public Object get(long id) {

        Article article = articleDao.findOne(id);
        return new Response( article != null ?  "Article successfully received" : "Article not found", article);
    }

    @RequestMapping("/get-all")
    @ResponseBody
    public Object getAll() {

        return articleDao.findAll();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object updateArticle(long id, String body, String name) {

        Article article = articleDao.findOne(id);

        if(article != null) {

            article.setBody(body);
            article.setName(name);
            articleDao.save(article);
            return  article;
        }
        else {
            return ("Article not found");
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(long id) {

        Article article = articleDao.findOne(id);

        if(article != null) {

            articleDao.delete(article);
            return new Response("User successfully deleted", article);
        }
        else {
            return new Response("User not found", null);
        }
    }
}
