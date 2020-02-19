package com.anyapp.engine;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.anyapp.engine.model.Order;
import com.anyapp.engine.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EngineApplication implements CommandLineRunner {

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private OrderRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        DynamoDBMapper dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
//
//        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Order.class);
//
//        tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
//
//        amazonDynamoDB.createTable(tableRequest);
//
        Order order = new Order();
        order.setName("order-2");

        repository.save(order);

        repository.findAll().forEach(item -> log.info(item.getName()));
    }
}
