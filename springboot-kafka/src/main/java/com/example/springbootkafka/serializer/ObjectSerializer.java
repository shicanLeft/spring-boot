package com.example.springbootkafka.serializer;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

/**
 * object 正序列化
 * @author shican
 *
 */
public class ObjectSerializer implements Serializer<Object>{

	@Override
	public void configure(Map<String, ?> paramMap, boolean paramBoolean) {
		
	}

	@Override
	public byte[] serialize(String topic, Object data) {
		System.out.println("对象数据开始正序列化");
	    System.out.println("topic : " + topic + " , object : " + data);
		
	    byte[] dataArray = null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(data);

            dataArray = outputStream.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return dataArray;
	}

	@Override
	public void close() {
	}

}
