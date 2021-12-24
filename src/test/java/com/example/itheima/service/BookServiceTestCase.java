package com.example.itheima.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private  IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(3).getName());
    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试类型12");
        book.setName("测试名字12");
        book.setDescription("测试描述12");
        bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId("22");
        book.setType("测试类型22222");
        book.setName("测试名字22222");
        book.setDescription("测试描述2222");
        bookService.updateById(book);
    }

    @Test
    void testDelete(){
        bookService.removeById(16);
    }

    @Test
    void getAll() {
        System.out.println(bookService.list());
    }

    @Test
    void testGetPage() {
        IPage<Book> iPage = new Page<>(2,5);
        bookService.page(iPage);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getRecords());
    }
}
