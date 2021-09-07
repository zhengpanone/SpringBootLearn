package com.zp.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.zp.annotation.Sensitive;
import com.zp.enums.SensitiveStrategy;

import java.io.IOException;
import java.util.Objects;

/**
 * 序列化注解自定义实现
 *
 * @author zhengpanone
 * @since 2021-09-03
 */
public class  SensitiveJsonSerializer extends JsonSerializer<String> implements ContextualSerializer {
    private SensitiveStrategy strategy;
    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(strategy.desensitizer().apply(value));

    }

    /**
     * 获取属性上的注解属性
     * @param prov
     * @param property
     * @return
     * @throws JsonMappingException
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        Sensitive annotation = property.getAnnotation(Sensitive.class);
        if(Objects.nonNull(annotation) && Objects.equals(String.class,property.getType().getRawClass())){
            this.strategy = annotation.strategy();
            return this;
        }
        return prov.findValueSerializer(property.getType(),property);
    }
}
