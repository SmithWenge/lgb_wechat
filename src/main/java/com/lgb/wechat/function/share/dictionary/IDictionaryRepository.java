package com.lgb.wechat.function.share.dictionary;

import java.util.List;

public interface IDictionaryRepository {
    Dictionary selectById(String id);
    List<Dictionary> selectAll();
}
