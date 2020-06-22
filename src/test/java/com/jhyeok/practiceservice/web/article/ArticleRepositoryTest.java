package com.jhyeok.practiceservice.web.article;

import com.jhyeok.practiceservice.web.domain.article.Article;
import com.jhyeok.practiceservice.web.repository.article.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

// JUnit ExtendWith 어노테이션
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    private final String TITLE = "테스트 제목";
    private final String CONTENT = "본문 내용 테스트 입니다.";
    private final String AUTHOR = "김재혁";

    @AfterEach
    public void cleanup() {
        // 이후 테스트에 영향을 끼치지 않기 위해 테스트 메서드가 끝날 때마다 articleRepository를 비우는 코드
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given (테스트 기반 환경을 구축하는 단계)
        LocalDateTime nowDate = LocalDateTime.now();
        articleRepository.save(Article.builder()
                .title(TITLE)
                .content(CONTENT)
                .author(AUTHOR)
                .build());

        // when (테스트 하고자 하는 행위)
        List<Article> articleList = articleRepository.findAll();

        // then (테스트 결과 검증)
        Article article = articleList.get(0);
        assertThat(article.getTitle(), is(TITLE));
        assertThat(article.getContent(), is(CONTENT));
        assertTrue(article.getCreatedDate().isAfter(nowDate));
        assertTrue(article.getUpdatedDate().isAfter(nowDate));
    }
}