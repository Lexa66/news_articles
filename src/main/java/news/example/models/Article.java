package news.example.models;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "articles")

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String body;

    @NotNull
    private String name;

    public Article() { }

    public Article(long id) {
        this.id = id;
    }

    public Article(long id, String name, String body) {
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String value) {
        this.body = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
