/**
 * 
 */
package com.hilfe.amq;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;

/**
 * @author rohit
 *
 */
public class AMQListener implements MessageListener {


	private MessageConsumer consumer;
	public AMQListener(MessageConsumer consumer) {
		this.consumer = consumer;
	}

	
	public void onMessage(Message arg0) {
			try{
				
				System.out.println("got message");
//	TODO: rwali		push2Clients(arg0);
			} catch (Exception e){
				e.printStackTrace();
			}
			
	}



}
