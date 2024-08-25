package com.feiniaojin.gracefuresponse.example.config;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.media.*;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Configuration
public class ApiDocsOperationCustomizer implements OperationCustomizer {

    @Override
    public Operation customize(Operation operation,
                               HandlerMethod handlerMethod) {

        ApiResponses responses = operation.getResponses();
        Set<Map.Entry<String, ApiResponse>> entrySet = responses.entrySet();
        for (Map.Entry<String, ApiResponse> entry : entrySet) {
            if ("200".equals(entry.getKey())) {
                wrapSuccess(entry.getValue());
                continue;
            }
            wrapError(entry.getValue());
        }
        return operation;
    }

    private void wrapError(ApiResponse value) {
        final Content content = value.getContent();
        if (Objects.isNull(content)) {
            return;
        }
        content.keySet().forEach(mediaTypeKey -> {
            final MediaType mediaType = content.get(mediaTypeKey);
            mediaType.schema(this.customizeSchemaError(mediaType.getSchema()));
        });
    }

    private void wrapSuccess(ApiResponse value) {
        final Content content = value.getContent();
        if (Objects.isNull(content)) {
            final Schema<?> wrapperSchema = new Schema<>();
            wrapperSchema.addProperty("code", new StringSchema()._default("200"));
            wrapperSchema.addProperty("msg", new StringSchema()._default("ok"));
            wrapperSchema.addProperty("data", new MapSchema()._default(Collections.emptyMap()));
            Content newContent = new Content();
            MediaType mediaType = new MediaType();
            mediaType.setSchema(wrapperSchema);
            newContent.put("*/*",mediaType);
            value.setContent(newContent);
            return;
        }
        content.keySet().forEach(mediaTypeKey -> {
            final MediaType mediaType = content.get(mediaTypeKey);
            mediaType.schema(this.customizeSchema(mediaType.getSchema()));
        });
    }

    private Schema<?> customizeSchema(final Schema<?> objSchema) {
        final Schema<?> wrapperSchema = new Schema<>();
        wrapperSchema.addProperty("code", new StringSchema()._default("200"));
        wrapperSchema.addProperty("msg", new StringSchema()._default("ok"));
        wrapperSchema.addProperty("data", objSchema);
        return wrapperSchema;
    }

    private Schema<?> customizeSchemaError(final Schema<?> objSchema) {
        final Schema<?> wrapperSchema = new Schema<>();
        wrapperSchema.addProperty("code", new StringSchema()._default("500"));
        wrapperSchema.addProperty("msg", new StringSchema()._default("error"));
        return wrapperSchema;
    }
}
