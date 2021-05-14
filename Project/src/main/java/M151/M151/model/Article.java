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
}
