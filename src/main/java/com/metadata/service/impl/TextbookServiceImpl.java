package com.metadata.service.impl;

import com.metadata.entity.Textbook;
import com.metadata.mapper.TextbookMapper;
import com.metadata.service.TextbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("textbookService")
public class TextbookServiceImpl implements TextbookService {
    @Autowired
    TextbookMapper textbookMapper;

    /**
     * 获取指定名称书籍impl
     * @param year 年份
     * @param batchIdx 批次
     * @param name 名称
     * @return textbook对象集
     */
    @Override
    public List<Textbook> selectTextbookByName(int year, int batchIdx, String name) {
        List<Textbook> textbookList = textbookMapper.selectTextbookByName(year, batchIdx, name);
        return textbookList;
    }

    @Override
    public void addTextbook(Textbook textbook) {
        textbookMapper.addTextbook(textbook);
    }

    /**
     * 删除指定id书籍impl
     * @param id 教材 id
     * @return null
     */
    @Override
    public void deleteTextbook(int id) {
        textbookMapper.deleteTextbook(id);
    }

    /**
     * 通过 sp 表中的 textbook_id 获取 textbook
     * @param id
     * @return
     */
    @Override
    public Textbook getTextbookById(int id) {
        return textbookMapper.getTextbookById(id);
    }

    public List<Textbook> getMyTextbooks(String username) {
        return textbookMapper.getMyTextbooks(username);
    }

    /**
     * 更新指定id书籍impl
     * @param textbook textbook对象
     * @return null
     */
    @Override
    public void updateTextbook(Textbook textbook) {
        textbookMapper.updateTextbook(textbook);
    }
}
