package com.ydles.search.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Project Name: ydles_parent
 * File Name: RabbitMQConfig
 *
 * @version 1.0
 * @author:wenerduo
 * @Date: 2022/01/29/上午 10:03
 * Copyright (c) 2022,
 */
@Configuration
public class RabbitMQConfig {
    //上架交换机名称
    public static final String GOODS_UP_EXCHANGE = "goods_up_exchange";
    //定义队列名称
    public static final String AD_UPDATE_QUEQU = "ad_update_quequ";
    //定义上架队列名称
    public static final String SEARCH_ADD_QUEUE = "search_add_queue";
    //声明队列
    @Bean(AD_UPDATE_QUEQU)
    public Queue queue() {
        return new Queue(AD_UPDATE_QUEQU);
    }

    //声明上架队列
    @Bean(SEARCH_ADD_QUEUE)
    public Queue SEARCH_ADD_QUEUE() {
        return new Queue(SEARCH_ADD_QUEUE);
    }

    //声明上架交换机
    @Bean(GOODS_UP_EXCHANGE)
    public Exchange GOODS_UP_EXCHANGE() {
        return ExchangeBuilder.fanoutExchange(GOODS_UP_EXCHANGE).durable(true).build();
    }

    // 队列和交换机绑定
    @Bean
    public Binding GOODS_UP_EXCHANGE_BINDING(
            @Qualifier(SEARCH_ADD_QUEUE) Queue queue,
            @Qualifier(GOODS_UP_EXCHANGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
}