package com.donkeycar.HZServer;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HzServerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(HzServerApplication.class, args);
		/*
		Config cfg = new Config();
		cfg.setClassLoader(Thread.currentThread().getContextClassLoader());
		HazelcastInstance hazel = Hazelcast.newHazelcastInstance(cfg);

		ITopic<String> testCase = hazel.getReliableTopic("Test Case");

		// testCase.publish((new TestCase("testing testing", "one", "two, three")).toString());
		*/
		

		
	}

}
