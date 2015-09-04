/**
 * 
 */
package com.hilfe.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * @author rohit
 *
 */
public class StartUpServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
//		//TODO: rwali start queue producer and comsumer
//		AMQPublisher.getInstance().start();;
//		
//		//TODO: rwali make the conusmer pool later
//		Thread amqConsumer = new Thread();
//		amqConsumer.start();
	}
}
