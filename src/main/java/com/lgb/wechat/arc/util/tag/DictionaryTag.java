package com.lgb.wechat.arc.util.tag;


import com.lgb.wechat.function.support.dictionary.Dictionary;
import com.lgb.wechat.function.support.dictionary.IDictionaryManager;

import java.util.List;

public class DictionaryTag {
    private IDictionaryManager manager;
    private static DictionaryTag tag;

    public void setManager(IDictionaryManager manager) {
        this.manager = manager;
    }

    public IDictionaryManager getManager() {
        return manager;
    }

    public void init() {
        tag = this;
        tag.manager = this.manager;
    }

    /**
     * The Taglib function's method must be static
     * @param groupValue the groupValue field at table;
     * @return The List of value in CACHE {@link com.lgb.wechat.function.support.dictionary.impl.DefaultDictionaryManager}
     */
    public static List<Dictionary> list(String groupValue) {
        List<Dictionary> list = tag.manager.dictionaries(groupValue);

        return list;
    }

    public static String show(String groupValue, String itemKey) {
        Dictionary dictionary = tag.manager.dictionary(itemKey, groupValue);

        return dictionary.getItemValue();
    }
}
