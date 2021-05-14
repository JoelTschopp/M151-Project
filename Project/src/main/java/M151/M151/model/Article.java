package M151.M151.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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
