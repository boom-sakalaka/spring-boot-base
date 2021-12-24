package com.example.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试类型11");
        book.setName("测试名字11");
        book.setDescription("测试描述11");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId("13");
        book.setType("测试类型1");
        book.setName("测试名字2");
        book.setDescription("测试描述3");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){

        bookDao.deleteById(13);
    }

    @Test
    void getAll() {
        System.out.println(bookDao.selectList(null));
    }

    @Test
    void getPages() {
        IPage page = new Page(2, 5);
        IPage iPage = bookDao.selectPage(page, null);

        System.out.println(iPage.getTotal());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2 () {
        String name = "1";
        LambdaQueryWrapper<Book> qw = new LambdaQueryWrapper<Book>();
        qw.like(name != null,Book::getName,name);
        bookDao.selectList(qw);
    }
}
