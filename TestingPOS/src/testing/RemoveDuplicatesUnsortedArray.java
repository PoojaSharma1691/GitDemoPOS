package testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class RemoveDuplicatesUnsortedArray {

	public static void main(String[] args) {
		int arr[]=new int[] {0,4,6,8,3,4,5,4,6,8};
		
		Map<Integer,Integer> hm=new HashMap<Integer, Integer>();
		for(int i:arr)
		{
			if(hm.containsKey(i))
				hm.put(i, hm.get(i)+1);
			else
				hm.put(i, 1);
				
		}
		
System.out.println(hm);

Set<Entry<Integer,Integer>> s=hm.entrySet();
List<Integer> list =new ArrayList<Integer>();
for(Entry<Integer,Integer> e:s)
{
	if(!(e.getValue()>1))
	{
		list.add(e.getKey());
	}
		
		
	
}
System.out.println(list);
}
}
