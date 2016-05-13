package com.lgb.wechat.function.share.dictionary;

import java.util.List;

public interface IDictionaryService {
    Dictionary getDictionaryById(String id);
    List<Dictionary> getAllDictionaries();
}
