package M151.M151.service;

import M151.M151.dto.BuyWithArticleAndUser;
import M151.M151.model.Article;
import M151.M151.model.Buys;
import M151.M151.model.User;
import M151.M151.repo.ArticleRepo;
import M151.M151.repo.BuysRepo;
import M151.M151.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BuysService {
    private final BuysRepo buysRepo;
    private final ArticleRepo articleRepo;
    private final UserRepo userRepo;

    @Autowired
    public BuysService(BuysRepo buysRepo, ArticleRepo articleRepo, UserRepo userRepo) {
        this.buysRepo = buysRepo;
        this.articleRepo = articleRepo;
        this.userRepo = userRepo;
    }

    @Transactional(readOnly = true)
    public List<Buys> getAll() {
        final Iterable<Buys> buys = buysRepo.findAll();

        return StreamSupport
                .stream(buys.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Buys add(final BuyWithArticleAndUser buyWithArticleAndUser) {
        final Optional<Article> article = Optional.ofNullable(articleRepo.findById(buyWithArticleAndUser.getArticleId()));
        final Optional<User> user = Optional.ofNullable(userRepo.findById(buyWithArticleAndUser.getUserId()));

        if (article.isPresent() && user.isPresent()) {
            Buys buys = new Buys(article.get(), user.get());
            return buysRepo.save(buys);
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Optional<Buys> get(final long id) {
        return Optional.ofNullable(buysRepo.findById(id));
    }
}

