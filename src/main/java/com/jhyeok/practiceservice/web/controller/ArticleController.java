package com.jhyeok.practiceservice.web.controller;

import com.jhyeok.practiceservice.web.repository.article.ArticleRepository;
import com.jhyeok.practiceservice.web.dto.ArticleDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ArticleController {

    private ArticleRepository articleRepository;

    @PostMapping("/article")
    public void createArticle(@RequestBody ArticleDto dto) {
        articleRepository.save(dto.toEntity());
    }
}
