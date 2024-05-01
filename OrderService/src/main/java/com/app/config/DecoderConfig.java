package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.exception.decoder.CustomDecoder;

import feign.codec.ErrorDecoder;

@Configuration
public class DecoderConfig {
	@Bean
	public ErrorDecoder createConfig() {
		return new CustomDecoder();
	}
}
