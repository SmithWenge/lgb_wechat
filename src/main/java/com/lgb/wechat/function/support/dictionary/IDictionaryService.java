package com.lgb.wechat.function.support.dictionary;

import java.util.List;

public interface IDictionaryService {
    Dictionary getDictionaryById(String id);
    List<Dictionary> getAllDictionaries();
}
