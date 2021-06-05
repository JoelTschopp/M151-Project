package M151.M151.model;

import javax.persistence.*;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_sequence")
    @SequenceGenerator(allocationSize = 1, name = "article_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(nullable = false)
    private String articleName;

    @Column(nullable = false)
    private String articlePrice;

    protected Article() {
    }

    public Article(String articleName, String articlePrice) {
        this.articleName = articleName;
        this.articlePrice = articlePrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticlePrice() {
        return articlePrice;
    }

    public void setArticlePrice(String articlePrice) {
        this.articlePrice = articlePrice;
    }
}
