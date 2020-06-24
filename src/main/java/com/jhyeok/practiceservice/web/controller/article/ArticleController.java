package com.jhyeok.practiceservice.web.controller.article;

import com.jhyeok.practiceservice.web.dto.article.ArticleRequestDto;
import com.jhyeok.practiceservice.web.dto.article.ArticleResponseDto;
import com.jhyeok.practiceservice.web.service.article.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    /**
     * Article 생성하기
     *
     * @param articleRequestDto 생성할 Article Dto
     * @return 생성한 Article id
     */
    @PostMapping("/api/article")
    public Long save(@RequestBody ArticleRequestDto articleRequestDto) {
        return articleService.save(articleRequestDto);
    }

    /**
     * Article 조회하기
     *
     * @param id Article id
     * @return Article id에 해당하는 ArticleResponseDto
     */
    @GetMapping("/api/article/{id}")
    public ArticleResponseDto findById(@PathVariable Long id) {
        return articleService.findById(id);
    }
}
