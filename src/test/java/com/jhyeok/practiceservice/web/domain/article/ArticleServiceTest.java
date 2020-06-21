package com.jhyeok.practiceservice.web.domain.article;

import com.jhyeok.practiceservice.web.dto.article.ArticleDto;
import com.jhyeok.practiceservice.web.repository.article.ArticleRepository;
import com.jhyeok.practiceservice.web.service.article.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.BDDMockito.given;

/*
* 단위 테스트에서 Mockito 사용
* 목 객체는 테스트를 할 때 해당 코드 외의 의존하는 객체를 가짜로 만든 것을 지칭한다.
* SpringBootTest 어노테이션을 제거해서 서버를 실행하지 않으므로 더 빠르다.
* Mocking 처리해서 외부 의존성을 줄이고 Service 영역의 코드를 독립적으로 테스트한다.
**/
@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {
    @InjectMocks
    private ArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;

    private ArticleDto articleDto;
    private Article savedArticle;

    private final String TITLE = "테스트 제목";
    private final String CONTENT = "본문 내용 테스트 입니다.";
    private final String AUTHOR = "김재혁";

    @BeforeEach
    void setUp() {
        articleDto = ArticleDto.builder()
                .title(TITLE)
                .content(CONTENT)
                .author(AUTHOR)
                .build();

        savedArticle = Article.builder()
                .title(TITLE)
                .content(CONTENT)
                .author(AUTHOR)
                .build();
    }

    @Test
    void 게시글_저장하기() {
        // given (테스트 기반 환경을 구축하는 단계)
        given(articleRepository.save(any())).willReturn(savedArticle);

        // when (테스트 하고자 하는 행위)
        Long id = articleService.save(articleDto);

        // then (테스트 결과 검증)
        assertThat(id).isEqualTo(savedArticle.getId());
    }
}
