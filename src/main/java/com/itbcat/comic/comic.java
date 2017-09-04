package com.itbcat.comic;

import jetbrick.template.JetGlobalContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Roo
 *
 * @author biezhi
 * @date 2017/8/5
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class comic {

    private JetGlobalContext    context  = null;
    private Map<String, String> settings = new HashMap<>();

    public boolean existSetting(String key) {
        return settings.containsKey(key);
    }

    /**
     * 设置模板引擎上下文
     *
     * @param type
     * @param key
     * @param value
     * @return
     */
    public comic context(Class<?> type, String key, Object value) {
        context.set(type, key, value);
        return this;
    }

    public comic globalContext(JetGlobalContext context) {
        this.context = context;
        return this;
    }

    public String getSetting(String key) {
        return settings.get(key);
    }

    public String getOrDefault(String key, String defaultValue) {
        return settings.getOrDefault(key, defaultValue);
    }



    public static comic me() {
        return RooCacheEnum.SINGLE.instance;
    }

    public enum RooCacheEnum {
        SINGLE;
        comic instance;

        RooCacheEnum() {
            instance = new comic();
        }
    }

}