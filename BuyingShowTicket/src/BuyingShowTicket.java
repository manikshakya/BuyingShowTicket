import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*

Alex plans on visiting the museum and is at the counter to purchase tickets to get in. 
Tickets are sold only one at a time. If a visitor needs more than one ticket, 
he/she has to pass through the queue again to buy each one.

 
Given the number of visitors and the number of tickets each visitor needs, 
determine the amount of time Alex requires to buy the number needed. 
Alex's place in the queue will be given. Each transaction takes 1 unit of time. 
And the time taken to go to the back of the line can be ignored.


Given tickets = [2, 6, 3, 4, 5], Alex's position is at index 2 which is 3.

window ← 2 ← 6 ← 3 ← 4 ← 5
window ← 6 ← 3 ← 4 ← 5 ← 1
window ← 3 ← 4 ← 5 ← 1 ← 5
window ← 4 ← 5 ← 1 ← 5 ← 2
window ← 5 ← 1 ← 5 ← 2 ← 3
window ← 1 ← 5 ← 2 ← 3 ← 4
window ← 5 ← 2 ← 3 ← 4 (the person at the head of the line in the previous step purchased their last ticket and does not re-enter the line)
window ← 2 ← 3 ← 4 ← 4
window ← 3 ← 4 ← 4 ← 1
window ← 4 ← 4 ← 1 ← 2
window ← 4 ← 1 ← 2 ← 3
window ← 1 ← 2 ← 3 ← 3
window ← 2 ← 3 ← 3 ( Alex purchased the last ticket needed and does not re-enter the line)
It took a total of 12 units of time (t = 0 through t = 11) to purchase 2 tickets.


*/

class BuyingShowTicket{
	public static void main(String[] args) {
		List<Integer> ticket = new ArrayList<>(Arrays.asList(2,6,3,4,5));
		int pos = 2;
		
		System.out.println(waitingTime(ticket, pos));
	}
	
	public static long waitingTime(List<Integer> ticket, int p) {
		int checkPos = 0;
		
		long t = 0; // Number of transaction
		int pos = p;
		
		int bought = ticket.get(pos);
		boolean valid = true;
		
//		System.out.println(ticket.get(2));
//		System.out.println(ticket);
//		ticket.set(2, ticket.get(2)-1);
//		System.out.println(ticket);
		
//		System.out.println(ticket);
		
		
		
		while(valid) {
			int queue = ticket.get(checkPos);
			if(queue > 0) {
				t++;
				int element = ticket.remove(0);
				ticket.add(ticket.size(), element - 1);
				
				if(pos == 0) {
					bought--;
					pos = ticket.size() - 1;
				}else {
					pos--;
				}
			}
			
			if(ticket.get(ticket.size() - 1) == 0) {
				ticket.remove(ticket.size() - 1);
			}
			
			if(bought == 0) {
				valid = false;
			}
			
//			System.out.println(ticket + ":\t " + t + "\t"+ bought);
			
//			if(queue == 0) {
//				ticket.remove(0);
//				queue = ticket.get(0);
//			}
			
		}
//		System.out.println(ticket);
//		System.out.println(t);
		
		return t;
	}
}