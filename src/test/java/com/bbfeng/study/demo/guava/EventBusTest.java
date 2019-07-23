package com.bbfeng.study.demo.guava;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class EventBusTest {

	public class TestEvent {
	    private final int message;
	    public TestEvent(int message) {        
	        this.message = message;
	        System.out.println("event message:"+message);
	    }
	    public int getMessage() {
	        return message;
	    }
	}
	
	public class TestEvent2 {
	    private final int message;
	    public TestEvent2(int message) {        
	        this.message = message;
	        System.out.println("event message:"+message);
	    }
	    public int getMessage() {
	        return message;
	    }
	}
	
	public class EventListener {
	    public int lastMessage = 0;

	    @Subscribe
	    public void sayHello(TestEvent event) {
	        lastMessage = event.getMessage();
	        System.out.println("Message:"+lastMessage);
	    }

	    @Subscribe
	    public void sayHello(TestEvent2 event) {
	        lastMessage = event.getMessage();
	        System.out.println("Message-2:"+lastMessage);
	    }
	    
	    public int getLastMessage() {      
	        return lastMessage;
	    }
	}
	
	public class DeadEventListener {
	    boolean notDelivered = false;  
	       
	    @Subscribe  
	    public void listen(DeadEvent event) {  
	    	System.out.println("Dead event is called");
	        notDelivered = true;  
	    }  
	   
	    public boolean isNotDelivered() {  
	        return notDelivered;  
	    }  
	}
	
	@Test
	public void testEventBus() {
		EventBus eventBus = new EventBus("test");
        eventBus.register(new EventListener());

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent2(300));
        eventBus.post(new TestEvent(400));
	}

	@Test
	public void testDeadEvent() {
		EventBus eventBus = new EventBus("test");
        eventBus.register(new DeadEventListener());

        eventBus.post(new TestEvent(200));
        eventBus.post(new TestEvent2(300));
        eventBus.post(new TestEvent(400));
        
	}
}
