package com.jhyeok.practiceservice.web.dto.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ArticleDto {
    private String title;
    private String content;
    private String author;

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
