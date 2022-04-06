package com.donkeycar.HZServer;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;

@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
public class HzServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(HzServerApplication.class, args);
		Config config = new Config();
		//config.setClusterName("Message Board");
        config.setClassLoader(Thread.currentThread().getContextClassLoader());
        Hazelcast.newHazelcastInstance(config);
		//Hazelcast.newHazelcastInstance(config);
	}

}
