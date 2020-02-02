package com.jhyeok.practiceservice.web.domain.article;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    ArticleRepository articleRepository;

    @AfterEach
    public void cleanup() {
        // 이후 테스트에 영향을 끼치지 않기 위해 테스트 메서드가 끝날 때마다 articleRepository를 비우는 코드
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given (테스트 기반 환경을 구축하는 단계)
        articleRepository.save(Article.builder()
                .title("테스트 제목")
                .content("본문 내용 테스트 입니다.")
                .author("dev.jhyeok@gmail.com")
                .build());

        // when (테스트 하고자 하는 행위)
        List<Article> articleList = articleRepository.findAll();

        // then (테스트 결과 검증)
        Article article = articleList.get(0);
        assertThat(article.getTitle(), is("테스트 제목"));
        assertThat(article.getContent(), is("본문 내용 테스트 입니다."));
    }
}