package github.genji9071.sfFoodTruck.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ObjectUtils {
    public static <T> T copyProperties(Object source, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(source), clazz);
    }

    public static JSONObject toJson(Object source) {
        return JSON.parseObject(JSON.toJSONString(source));
    }
}
