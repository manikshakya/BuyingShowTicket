import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BuyingShowTicketTest {

	@Test
	public void test1() {
		List<Integer> ticket = new ArrayList<>(Arrays.asList(2,6,3,4,5));
		int pos = 2;
		
		assertEquals(BuyingShowTicket.waitingTime(ticket, pos), 12);
	}
	
	@Test
	public void test2() {
		List<Integer> ticket = new ArrayList<>(Arrays.asList(1,2,5));
		int pos = 1;
		
		assertEquals(BuyingShowTicket.waitingTime(ticket, pos), 4);
	}
	
	@Test
	public void test3() {
		List<Integer> ticket = new ArrayList<>(Arrays.asList(1,1,1,1));
		int pos = 0;
		
		assertEquals(BuyingShowTicket.waitingTime(ticket, pos), 1);
	}
	
	@Test
	public void test4() {
		List<Integer> ticket = new ArrayList<>(Arrays.asList(5,5,2,3));
		int pos = 3;
		
		assertEquals(BuyingShowTicket.waitingTime(ticket, pos), 11);
	}

}
