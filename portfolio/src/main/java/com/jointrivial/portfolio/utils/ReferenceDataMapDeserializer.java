package com.jointrivial.portfolio.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ReferenceDataMapDeserializer implements JsonDeserializer<Map<String, BigDecimal>> {
    @Override
    public Map<String, BigDecimal> deserialize(JsonElement elem, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Map<String, BigDecimal> result = new HashMap<>();
        elem.getAsJsonObject().entrySet().stream().map(e -> e.getValue().getAsJsonArray())
                .forEach(e -> e.forEach(a -> {
                    JsonObject jsonElement = a.getAsJsonObject();
                    result.put(jsonElement.get("symbol").getAsString(), jsonElement.get("price").getAsBigDecimal());
                }));
        return result;
    }
}
