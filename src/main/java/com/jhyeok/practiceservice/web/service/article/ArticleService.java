package com.jhyeok.practiceservice.web.service.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import com.jhyeok.practiceservice.web.dto.article.ArticleDto;
import com.jhyeok.practiceservice.web.repository.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public Long save(ArticleDto articleDto) {
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        return savedArticle.getId();
    }
}
