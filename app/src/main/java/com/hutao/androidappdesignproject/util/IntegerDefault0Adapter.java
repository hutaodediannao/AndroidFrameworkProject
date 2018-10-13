package com.hutao.androidappdesignproject.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * 描述: gson数据返回为空的解析缺省对象
 * 作者: 胡涛
 * 时间: 2018/7/24 8:49
 */
public class IntegerDefault0Adapter implements JsonSerializer<Integer>, JsonDeserializer<Integer> {


    @Override
    public Integer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        if (
                StringUtil.isEquals(jsonElement.getAsString(), "0") ||
                StringUtil.isEmpty(jsonElement.getAsString()) ||
                StringUtil.isEquals(jsonElement.getAsString(), "null")) {
            return 0;
        }

        return jsonElement.getAsInt();
    }

    @Override
    public JsonElement serialize(Integer integer, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(integer);
    }
}
