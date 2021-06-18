package com.zp.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;

/**
 * model
 *
 * @author zhengpanone
 * @since 2021-09-03
 */
public class  SensitiveJsonSerializer extends JsonSerializer<String> implements ContextualSerializer {
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        return null;
    }
}
