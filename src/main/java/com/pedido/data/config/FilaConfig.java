package com.pedido.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.QueueChannel;

@Configuration
public class FilaConfig {

	@Bean
	public QueueChannel filaVirtual() {
		return new QueueChannel();
	}

}