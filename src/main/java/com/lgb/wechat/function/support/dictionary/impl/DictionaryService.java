package com.lgb.wechat.function.support.dictionary.impl;

import com.lgb.wechat.function.support.dictionary.Dictionary;
import com.lgb.wechat.function.support.dictionary.IDictionaryRepository;
import com.lgb.wechat.function.support.dictionary.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository repository;

    @Override
    public Dictionary getDictionaryById(String id) {
        return repository.selectById(id);
    }

    @Override
    public List<Dictionary> getAllDictionaries() {
        return repository.selectAll();
    }
}
