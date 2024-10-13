package com.learningwithak.kafka.procuder.config;

import com.fasterxml.jackson.databind.ser.std.JsonValueSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ProducerConfiguration {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrap_server_config;
    @Value("${spring.kafka.topic.name}")
    private String kafka_topic;
    /*@Value("spring.kafka.producer.key-serializer")
    private String kafka_key_serializer;
    @Value("spring.kafka.producer.value-serializer")
    private String kafka_value_serializer;*/

    @Bean
    public ProducerFactory<String, Object> producerFactory(){
        Map<String, Object> configMap = new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_server_config);
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return  new DefaultKafkaProducerFactory<>(configMap);
    }

    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public NewTopic kafkaTopic(){

        return TopicBuilder.name(kafka_topic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
