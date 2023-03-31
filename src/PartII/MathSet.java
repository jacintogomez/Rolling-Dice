package PartII;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {
		
	public MathSet() {
		super();
	}
	
	public Set<E> intersection(Set<E> s2) {
		HashSet<E> intersect=new HashSet<E>();
		for(E s:this) {
			if(s2.contains(s)) {
				intersect.add(s);
			}
		}
		return intersect;
    }
    
    public Set<E> union(Set<E> s2) {
    	HashSet<E> setunion=new HashSet<E>();
    	for(E s:this) {
    		setunion.add(s);
    	}
    	for(E j:s2) {
    		setunion.add(j);
    	}
    	return setunion;
    }
    
    public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
    	HashSet<Pair<E,T>> prod=new HashSet<Pair<E,T>>();
        for(E e:this) {
        	for(T t:s2) {
        		Pair p=new Pair(e,t);
            	prod.add(p);
        	}
        }
        return prod;
    }
    

	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(5);
		s1.add(7);
		s1.add(9);
		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(5);
		s2.add(7);
		s2.add(4);
		s2.add(6);
		s2.add(8);
		System.out.println(s1.intersection(s2));
		System.out.println(s1.union(s2));
		System.out.println(s1.cartesianProduct(s2));
		
	}
}
