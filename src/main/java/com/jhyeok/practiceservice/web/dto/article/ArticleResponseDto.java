package com.jhyeok.practiceservice.web.dto.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class ArticleResponseDto {
    private String title;
    private String content;
    private String author;

    public ArticleResponseDto(Article entity) {
        this.title = entity.getTitle();
        this.content = entity.getAuthor();
        this.author = entity.getAuthor();
    }
}
