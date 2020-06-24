package com.jhyeok.practiceservice.web.service.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import com.jhyeok.practiceservice.web.dto.article.ArticleRequestDto;
import com.jhyeok.practiceservice.web.dto.article.ArticleResponseDto;
import com.jhyeok.practiceservice.web.repository.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    /**
     * Article 생성하기
     *
     * @param articleRequestDto 생성할 Article Dto
     * @return 생성한 Article id
     */
    @Transactional
    public Long save(ArticleRequestDto articleRequestDto) {
        Article savedArticle = articleRepository.save(articleRequestDto.toEntity());
        return savedArticle.getId();
    }

    /**
     * Article 조회하기
     *
     * @param id Article id
     * @return Article id에 해당하는 ArticleResponseDto
     */
    @Transactional(readOnly = true)
    public ArticleResponseDto findById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Not Found Article"));

        return new ArticleResponseDto(article);
    }
}
