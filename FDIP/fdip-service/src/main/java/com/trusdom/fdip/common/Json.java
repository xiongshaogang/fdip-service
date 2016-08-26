package com.trusdom.fdip.common;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Json {
	private static final ObjectMapper defaultObjectMapper = new ObjectMapper();
	private static volatile ObjectMapper objectMapper = null;

	private static ObjectMapper mapper() {
		if (objectMapper == null) {
			return defaultObjectMapper;
		}
		objectMapper.configure(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN, true);
		return objectMapper;
	}

	public static JsonNode toJson(Object paramObject) {
		try {
			return mapper().valueToTree(paramObject);
		} catch (Exception localException) {
			throw new RuntimeException(localException);
		}
	}
	
	public static <T> T getObject(String params,Class<T> T){
		try {
			return mapper().readValue(params, T);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public static <A> A fromJson(JsonNode paramJsonNode, Class<A> paramClass) {
		try {
			return mapper().treeToValue(paramJsonNode, paramClass);
		} catch (Exception localException) {
			throw new RuntimeException(localException);
		}
	}

	public static ObjectNode newObject() {
		return mapper().createObjectNode();
	}

	public static String stringify(JsonNode paramJsonNode) {
		return paramJsonNode.toString();
	}

	public static JsonNode parse(String paramString) {
		try {
			return ((JsonNode) mapper().readValue(paramString, JsonNode.class));
		} catch (Throwable localThrowable) {
			throw new RuntimeException(localThrowable);
		}
	}

	public static JsonNode parse(InputStream paramInputStream) {
		try {
			return ((JsonNode) mapper().readValue(paramInputStream,
					JsonNode.class));
		} catch (Throwable localThrowable) {
			throw new RuntimeException(localThrowable);
		}
	}

	public static void setObjectMapper(ObjectMapper paramObjectMapper) {
		objectMapper = paramObjectMapper;
	}
}
