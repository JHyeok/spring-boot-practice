package com.jhyeok.practiceservice.web.dto.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ArticleDto {
    private String title;
    private String content;
    private String author;

    @Builder
    private ArticleDto(final String title, final String content, final String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Article toEntity() {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
