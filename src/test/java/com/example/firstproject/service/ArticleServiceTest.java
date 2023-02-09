package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest //해당 클래스는 스프링부트와 연동되어 테스트된다.
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index(){

        //예상
        Article a = new Article(1L,"가가가가가가","1111");
        Article b = new Article(2L,"나나나","22222");
        Article c = new Article(3L,"다다다다가","33333");

        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c));
        //실제
        List<Article> articles = articleService.index();

        //비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void show_성공_존재하는_id_입력() {
        //예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가가가","1111");

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패_존재하지_않는_id_입력() {
        //예상
        Long id = -1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);

        //비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_dto_입력() {
        //예상
        String title = "라라라라";
        String content = "44444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expected = new Article(4L, title, content);

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected.toString(), article.toString());
    }


    @Test
    @Transactional
    void create_실패_id가_포함된_dto() {
        //예상
        String title = "라라라라";
        String content = "44444";
        ArticleForm dto = new ArticleForm(4L,title,content);
        Article expected = null;

        //실제
        Article article = articleService.create(dto);

        //비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void updated_성공____존재하는_id와_title_content가_있는_dto_입력() {
        //예상
        Long id = 3L;
        String title = "rrrr";
        String content = "ssss";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        //실제
        Article article = articleService.update(id, dto);
        //검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void updated_실패____존재하는_id와_title_content가_있는_dto_입력() {
        //예상
        // 예상
        Long id = -3L;
        ArticleForm dto = new ArticleForm(id,null,null);
        Article expected = null;
        //실제
        Article article = articleService.update(id, dto);
        //검증
        assertEquals(expected, article);
    }
}