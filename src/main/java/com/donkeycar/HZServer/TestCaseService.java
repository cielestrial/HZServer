package com.donkeycar.HZServer;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.topic.ITopic;

import org.springframework.stereotype.Service;

@Service
public class TestCaseService {

    private HazelcastInstance instance;
    private ITopic<String> topic;

    public TestCaseService() {
        Config config = new Config();
		//config.setClusterName("Message Board");
        config.setClassLoader(Thread.currentThread().getContextClassLoader());
        this.instance = Hazelcast.newHazelcastInstance(config);
    }

    public void broadcastTestCase(String message) {
        topic = instance.getReliableTopic("run");
        topic.publish(message);
        System.out.println("\nPublished: " + message + "\n");
        for(int i = 0; i < instance.getCluster().getMembers().size(); i++) {
            System.out.println("\n" +
             instance.getCluster().getMembers().toArray()[i].toString()
             + "\n");
        }
    }

}
