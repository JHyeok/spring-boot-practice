package com.jhyeok.practiceservice.web.repository.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
