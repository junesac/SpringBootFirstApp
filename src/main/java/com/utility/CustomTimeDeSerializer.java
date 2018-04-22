package com.utility;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomTimeDeSerializer extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser jsonparser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return StringUtils.replace(jsonparser.getText(), ":", "");
	}

}
