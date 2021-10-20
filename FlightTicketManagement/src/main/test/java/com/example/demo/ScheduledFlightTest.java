package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigInteger;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.example.demo.model.Airline;
import com.example.demo.model.Flight;
import com.example.demo.model.Schedule;
import com.example.demo.model.ScheduleFlight;

import mockit.integration.junit4.JMockit;

/**
 * Test class for ScheduledFlight
 */
@RunWith(JMockit.class)
public class ScheduledFlightTest {
	/**
	   * setup method.
	   */
	  @Before
	  public void initInput() {

	  }
	  
	  /**
	   * Tests the equals/hashcode methods of the ScheduledFlight class.
	   * throws @NullPointerException to check hashcode of null value (line: 50)
	   */
	  @Test()
	  public final void testEquals() throws NullPointerException {
		  Airline airport1= new Airline();
		  Airline airport2= new Airline("A102","India",1," Airport");
		  Flight flight= new Flight(new BigInteger("101"),"C101","M101",200,"jjj","ccc");
		  Schedule schedule= new Schedule(new BigInteger("1"),airport1,"12-06-2020","13-06-2020");
		  ScheduleFlight sFlight1 = new ScheduleFlight();
		  assertNotNull(sFlight1);
		  ScheduleFlight sFlight2 = null;
		  ScheduleFlight sFlight3= new ScheduleFlight(new BigInteger("101"),flight,120,schedule);
		  ScheduleFlight sFlight4= new ScheduleFlight(new BigInteger("101"),flight,120,schedule);
		  assertTrue(sFlight3.equals(sFlight4));
		  assertFalse(sFlight3.equals(sFlight2));
		//  assertEquals(sFlight2.hashCode(), sFlight3.hashCode());
	  }
	  
	  /**
	   * Tests the toString() methods of the ScheduledFlight class.
	   */
	  @Test
	  public final void testToString() {
		  Airline airport1= new Airline("A101","Spain",33,"Spain Airport");
		  Airline airport2= new Airline("A102","India",44,"IGI Airport");
		  Flight flight= new Flight(new BigInteger("101"),"C101","M101",200,"ggg","hhh");
		  Schedule schedule= new Schedule(new BigInteger("1"),airport1,"12-06-2020","13-06-2020");
		  ScheduleFlight sFlight1= new ScheduleFlight(new BigInteger("101"),flight,120,schedule);
		  String result = String.format("ScheduledFlight [scheduleFlightId=%3s, flight=%15s, availableSeats=%3s, schedule=%20s]",
				  sFlight1.getScheduleFlightId(), sFlight1.getFlight(), 
				  sFlight1.getAvailableSeats(), sFlight1.getSchedule());
		  assertEquals(result, sFlight1.toString());
	  }
	  
	  /**
	   * Testing add ScheduledFlight 
	   */
	  @Test
	  public final void testScheduledFlight() {
		  Airline airport1= new Airline("A101","Spain",333,"Spain Airport");
		  Airline airport2= new Airline("A102","India",111,"IGI Airport");
		  BigInteger b1= new BigInteger("101");
		  Flight flight= new Flight(b1,"C101","M101",200,"vvv","sss");
		  Schedule schedule= new Schedule(new BigInteger("1"),airport2,"12-06-2020","13-06-2020");
		  ScheduleFlight sFlight1= new ScheduleFlight(b1,flight,120,schedule);
		  assertEquals(b1, sFlight1.getScheduleFlightId());
		  
		  assertEquals(flight, sFlight1.getFlight());
		  assertEquals(schedule, sFlight1.getSchedule());
	  }
	  
}


