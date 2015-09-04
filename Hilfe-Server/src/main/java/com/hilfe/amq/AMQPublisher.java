/**
 * 
 */
package com.hilfe.amq;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.hilfe.util.HilfeConstants;


/**
 * @author rohit
 *
 */
public class AMQPublisher {

	private ActiveMQConnectionFactory connectionFactory = null;
	private MessageProducer producer = null;
	
	private static AMQPublisher amqPublisher = new AMQPublisher();
	
	private AMQPublisher() {
		this.connectionFactory = new ActiveMQConnectionFactory(HilfeConstants.Q_ENDPOINT);
	}
	
	public static AMQPublisher getInstance(){
		return amqPublisher;
	}

	public void start(){

		try {
			Connection connection = connectionFactory.createConnection();
			connection.setClientID(UUID.randomUUID().toString());
			connection.start();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//TODO: rwali get ack based delivery on subcriber side
			//TODO: rwali do i need to create topic every  time 
			Destination destination = session.createTopic(HilfeConstants.TOPIC);


			//TODO: rwali add timeout on messages
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		}

	}
	
	public void publish(Message notif) throws JMSException{
		producer.send(notif);;
	}
	

	
}
