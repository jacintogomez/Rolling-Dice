package PartI;

import java.util.*;

public class Packet implements Comparable<Packet>{
	
	private Byte[] payload;
	private int priority;
	
	public Byte[] getPayload() {
		return payload;
	}

	public void setPayload(Byte[] payload) {
		this.payload = payload;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Packet(Byte[] payload, int priority) {
		this.payload=payload;
		this.priority=priority;
	}
	
	public int compareTo(Packet p) {
		return Double.compare(this.priority,p.priority);
	}
	
	public static void main(String[] args) {
		PriorityQueue<Packet> pq = new PriorityQueue<>(10,Collections.reverseOrder());
				
		for (int i=0;i<10;i++) {
			Byte[] payload = new Byte[256];
			int priority = (int)(Math.random()*5) + 1;
			Packet p = new Packet(payload, priority);
			pq.offer(p);
		}
		
		while (!pq.isEmpty()) {
			Packet p=pq.remove();
			System.out.println("got packet " + p +" of priority "+p.getPriority());
		}
	}

}
