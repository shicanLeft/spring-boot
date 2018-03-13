package com.example.springbootkafka.deserializer;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

/**
 * Object 对象的反序列化
 * @author shican
 *
 */
public class ObjectDeserializer implements Deserializer<Object>{

	@Override
	public void configure(Map<String, ?> paramMap, boolean paramBoolean) {
		
	}

	/**
	 * override kafka 反序列化 method
	 */
	@Override
	public Object deserialize(String topic, byte[] data) {
		Object object = null ;
		
		try {
			
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
			
			ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
			
			object = inputStream.readObject();
			
		} catch (Exception e) {
			e.getMessage();
		}
		   System.out.println(" topic : " + topic + " , deserialized object :" + object);
		   System.out.println("对象数据反序列化end");
		return object;
	}

	@Override
	public void close() {
	}

}
