package com.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

@EnableKafka
@Configuration
public class KafkaConfiguration {
	
	
	@Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

   @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
       // config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        config.put ("auto.create.topics.enable", true); 
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config);
    }
    
    @Bean("concurrentKafkaListenerContainer")
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

	/*
	 * @Bean public ConsumerFactory<String, BusinessDataDTO> dataConsumerFactory() {
	 * Map<String, Object> config = new HashMap<>();
	 * config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); //
	 * config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
	 * config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	 * StringDeserializer.class);
	 * config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	 * JsonDeserializer.class); return new DefaultKafkaConsumerFactory<>(config,new
	 * StringDeserializer(),new JsonDeserializer<>(BusinessDataDTO.class)); }
	 * 
	 * @Bean("econcurrentKafkaListenerContainer") public
	 * ConcurrentKafkaListenerContainerFactory<String, BusinessDataDTO>
	 * employeekafkaListenerContainerFactory() {
	 * ConcurrentKafkaListenerContainerFactory<String, BusinessDataDTO> factory =
	 * new ConcurrentKafkaListenerContainerFactory();
	 * factory.setConsumerFactory(dataConsumerFactory()); return factory; }
	 */
   
}
