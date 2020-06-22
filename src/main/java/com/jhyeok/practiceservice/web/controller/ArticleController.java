package com.jhyeok.practiceservice.web.controller;

import com.jhyeok.practiceservice.web.dto.article.ArticleRequestDto;
import com.jhyeok.practiceservice.web.dto.article.ArticleResponseDto;
import com.jhyeok.practiceservice.web.service.article.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/api/article")
    public Long create(@RequestBody ArticleRequestDto articleRequestDto) {
        return articleService.save(articleRequestDto);
    }

    @GetMapping("/api/article/{id}")
    public ArticleResponseDto findById (@PathVariable Long id) {
        return articleService.findById(id);
    }
}
