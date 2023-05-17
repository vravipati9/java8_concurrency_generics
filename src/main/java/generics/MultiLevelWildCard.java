package generics;

import generics.model.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MultiLevelWildCard {

	public static void main(String[] args) {
		Collection<Pair<String,Long>> c1 = new ArrayList<Pair<String,Long>>();
		Collection<? extends Pair<String, ?>> c2 = new ArrayList<Pair<String, Long>>();
		Collection<? extends Pair<String, ?>> c3 = c1;
		//Collection<Pair<String,?>> c4 = c1;
		
		List<Object> o = new ArrayList<Object>();
		o.add("asdf");
		o.add(2);
		System.out.println(o);
	}
}
