package PartIII;

import java.util.*;

import PartI.Packet;

public class SortFrequency {
	//implements Comparable<Map.Entry<Integer,Integer>>
//	public int compareTo(Map.Entry<Integer,Integer> p) {
//		return Double.compare(this.getValue(),p.getVAlue());
//	}

    public static void sortByFrequency(ArrayList<Integer> ar) {
    	Map<Integer,Integer> map=new HashMap<>();
    	//put all elements in hash map
    	for(Integer i:ar) {
    		if(!map.containsKey(i)) {
    			map.put(i,1);
    		}else {
    			int curval=map.get(i);
    			curval++;
    			map.put(i,curval);
    		}
    	}
    	//put key:value pair into arraylist
    	ArrayList<Map.Entry<Integer,Integer>> fre=new ArrayList<>(map.entrySet());
    	for(int h=0;h<fre.size();h++) {
    		System.out.print(" ("+fre.get(h).getKey()+","+fre.get(h).getValue()+")");
    	}
    	//sort arraylist by value
    	for(int i=fre.size()-1;i>0;i--) {
    		for(int j=0;j<i;j++) {
    			if(fre.get(j).getValue()>fre.get(j+1).getValue()) {
    				Map.Entry<Integer,Integer> temp=fre.get(j);
    				fre.set(j,fre.get(j+1));
    				fre.set(j+1,temp);
    			}
    		}
    	}
    	System.out.println("");
    	System.out.println("after sorting"); 
    	for(int h=0;h<fre.size();h++) {
    		
    		System.out.print(" ("+fre.get(h).getKey()+","+fre.get(h).getValue()+")");
    	}
    	//clear original arraylist and put back into original arraylist
    	ar.clear();
    	ArrayList<Integer> keys=new ArrayList<>();
    	int count=0;
    	for(Map.Entry<Integer,Integer> pair:fre) {
    		count=pair.getValue();
			for (int i=0;i<count;i++) {
				ar.add(pair.getKey());
			}
    	}
    	System.out.println("the keys "+keys.toString());
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<Integer>();
//        ar.add(1);
//        ar.add(2);
//        ar.add(2);
//        ar.add(1);
//        ar.add(1);
//        ar.add(1);
//        ar.add(5);
        for (int i=0;i<10;i++) {
                ar.add((int)(Math.random()*10));                        
        }
        System.out.println(ar.toString());
        sortByFrequency(ar);
        System.out.println(ar.toString());
    }
}
