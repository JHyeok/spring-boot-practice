package com.jhyeok.practiceservice.web.controller;

import com.jhyeok.practiceservice.web.dto.article.ArticleDto;
import com.jhyeok.practiceservice.web.service.article.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/article")
    public Long createArticle(@RequestBody ArticleDto articleDto) {
        return articleService.save(articleDto);
    }
}
