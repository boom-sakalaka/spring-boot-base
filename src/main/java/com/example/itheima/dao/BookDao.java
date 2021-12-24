package com.example.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
