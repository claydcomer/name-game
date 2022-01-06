package com.claydcomer.namegame;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.Collections;

@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class NameGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(NameGameApplication.class, args);

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
						"http://localhost:8000",
						"us-east-1"))
				.build();

		DynamoDB dynamoDB = new DynamoDB(client);

		String tableName = "Name-Game";

		try {
			System.out.println("Attempting to create table; please wait...");
			Table table = dynamoDB.createTable(
					tableName,
					Collections.singletonList(new KeySchemaElement("game_id", KeyType.HASH)), // Partition key
					Collections.singletonList(new AttributeDefinition("game_id", ScalarAttributeType.S)),
					new ProvisionedThroughput(10L, 10L));
			table.waitForActive();
			System.out.println("Success.  Name-Game Table status: " + table.getDescription().getTableStatus());
		} catch (ResourceInUseException e) {
			System.err.println("Name-Game table already exists: ");
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println("Unable to create Name-Game table: ");
			System.err.println(e.getMessage());
		}
	}
}
