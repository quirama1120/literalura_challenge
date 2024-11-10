//package com.alura.literatura_challenge.service;
//
//import com.fasterxml.jackson.core.JacksonException;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonDeserializer;
//
//import java.io.IOException;
//import java.util.Collections;
//
//public class LanguagesDeserializer extends JsonDeserializer {
//    @Override
//    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
//        JsonNode node = p.getCodec().readTree(p);
//
//        // Handle case where "languages" is an array
//        if (node.isArray()) {
//            return Arrays.asList(new ObjectMapper().treeToValue(node, String[].class));
//        }
//        // Handle case where "languages" is a single string
//        else {
//            return Collections.singletonList(node.asText());
//        }
//    }
//}
