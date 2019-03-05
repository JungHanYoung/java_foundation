package thisisjava.collectionframeworkdemo.treeMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<Integer, String> scores = new TreeMap<>();
		scores.put(87, "???");
		scores.put(98, "?????");
		scores.put(75, "????");
		scores.put(95, "????");
		scores.put(80, "?????");
		
		Map.Entry<Integer, String> entry;
		
		entry = scores.firstEntry();
		System.out.println("???? ???? ????: " + entry.getKey() + "-" + entry.getValue());
		
		entry = scores.lastEntry();
		System.out.println("???? ???? ????: " + entry.getKey() + "-" + entry.getValue());
		
		entry = scores.lowerEntry(95);
		System.out.println("95?? ??? ????: " + entry.getKey() + "-" + entry.getValue());
		
		entry = scores.higherEntry(95);
		System.out.println("95?? ???? ????: " + entry.getKey() + "-" + entry.getValue());
		
		entry = scores.floorEntry(95);
		System.out.println("95?????? ??? ??? ????: " + entry.getKey() + "-" + entry.getValue());
		
		entry = scores.ceilingEntry(85);
		System.out.println("85?????? ??? ???? ????: " + entry.getKey() + "-" + entry.getValue());
		
		while(scores.isEmpty()) {
			entry = scores.pollFirstEntry();
			System.out.println(entry.getKey() + "-" + entry.getValue() + "(???? ??ü ??: " + scores.size() + ")");
		}
	}

}
