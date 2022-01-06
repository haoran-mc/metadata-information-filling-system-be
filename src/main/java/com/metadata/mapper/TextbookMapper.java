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
     * @param batch_idx 批次
     * @param name 名称
     * @return textbook对象集
     */
    List<Textbook> selectTextbookByName(
            @Param("year") int year,
            @Param("batch_idx") int batch_idx,
            @Param("name") String name
    );

    /**
     * 插入新书籍mapper
     * @param textbook textbook对象
     */
    void addTextbook(@Param("textbook") Textbook textbook);

    /**
     * 删除指定id书籍mapper
     * @param id 教材 id
     * @return null
     */
    void deleteTextbook(@Param("id") int id);

    /**
     * 通过 sp 表中的 textbook_id 获取 textbook
     * @param id
     * @return
     */
    Textbook getTextbookById(@Param("id") int id);

    List<Textbook> getMyTextbooks(@Param("username") String username);

    /**
     * 更新指定id书籍mapper
     * @param textbook textbook对象
     * @return null
     */
    void updateTextbook(@Param("textbook") Textbook textbook);

    int getSpTextbookId();
}
