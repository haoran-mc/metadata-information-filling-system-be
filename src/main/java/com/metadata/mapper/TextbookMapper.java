package com.metadata.mapper;

import com.metadata.entity.Textbook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TextbookMapper {
    /**
     * 获取指定名称书籍mapper
     * @param year 年份
     * @param batch 批次
     * @param name 名称
     * @return textbook对象集
     */
    List<Textbook> selectTextbook(@Param("year") int year, @Param("batch") int batch, @Param("name") String name);

    /**
     * 删除指定id书籍mapper
     * @param textbook textbook对象
     * @return null
     */
    void deleteTextbook(@Param("textbook") Textbook textbook);

    /**
     * 更新指定id书籍mapper
     * @param textbook textbook对象
     * @return null
     */
    void updateTextbook(@Param("textbook") Textbook textbook);
}
