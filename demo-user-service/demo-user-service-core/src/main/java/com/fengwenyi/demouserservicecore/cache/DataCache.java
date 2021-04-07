package com.fengwenyi.demouserservicecore.cache;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
public class DataCache {

    private static final ConcurrentMap<String, Object> map = new ConcurrentHashMap<>();

    public static Object get(String key) {
        if (StringUtils.hasText(key)) {
            return map.get(key);
        }
        return null;
    }

    public static List<Object> get() {
        List<Object> list = new ArrayList<>();
        map.forEach((k, v) -> list.add(v));
        return list;
    }

    public static void set(String key, Object value) {
        if (StringUtils.hasText(key)) {
            map.put(key, value);
        }
    }
}
