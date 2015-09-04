/**
 * 
 */
package com.hilfe.amq;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.hilfe.util.HilfeConstants;

/**
 * @author rohit
 *
 */
public class AMQSubscriber  implements Runnable, ExceptionListener {

	private Connection connection = null;
	private Session session = null;
	private MessageConsumer consumer = null;
	
	private ActiveMQConnectionFactory connectionFactory = null;
	
	public AMQSubscriber(ActiveMQConnectionFactory connFactory) {
		this.connectionFactory = connFactory;
	}
	
	public void run() {
		
		try {

			System.out.println("going to connect");
			connection = connectionFactory.createConnection();
			connection.setClientID(UUID.randomUUID().toString());
			connection.start();

			connection.setExceptionListener(this);
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);

			//TODO: rwali do i need to create topic every time?
			
			Topic destination = session.createTopic(HilfeConstants.TOPIC);

			consumer = session.createDurableSubscriber(destination, UUID.randomUUID().toString());
			AMQListener listener = new AMQListener(consumer);
			consumer.setMessageListener(listener);

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		} 
	}

	public synchronized void onException(JMSException ex) {
		System.out.println("JMS Exception occured.  Shutting down client.");
		try {
			consumer.close();
		} catch (Throwable e) {
			System.out.println("JMS Exception occured closing the consumer" + e.getMessage());
		}
		
		try {
			session.close();
		} catch (Throwable e) {
			System.out.println("JMS Exception occured closing the consumer" + e.getMessage());
		}
		
		try {
			connection.close();
		} catch (Throwable e) {
			System.out.println("JMS Exception occured closing the consumer" + e.getMessage());
		}
	}

}
