
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long d=Stream.of("Pooja","Sharma","Tiwari","Hcl").filter(s->s.startsWith("P")).count();
		//System.out.println(d);
		
		ArrayList<String> a=new ArrayList<String>();
		a.add("Pooja");
		a.add("Parachi");
		a.add("Sarvesh");
		a.add("Ron");
		a.add("Apex");
		
		//a.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		//a.stream().filter(s->s.startsWith("P")).forEach(s->System.out.println(s));
		//a.stream().filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//a.stream().filter(s->s.startsWith("P")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
		
		//merging two streams
		
		Stream<String> b=Stream.of("Sharma","Tiwari","Kunte");
		Stream c= Stream.concat(a.stream(),b);
		//c.forEach(s->System.out.println(s));
		
		//finding a name "Ron" in the list
		if(c.anyMatch(s->s.equals("Ron")));
		System.out.println("contains match");
		
		
		List<String> list=Stream.of("Apple","Banana","Carrot","Cucumber","Tomatoa").filter(s->s.endsWith("a")).collect(Collectors.toList());
		System.out.println(list.get(0));
		
		//Array - Print unique number from array and sort the array
		//int[] arr= {21,43,45,45,67,78,89,90,43};
		List<Integer> li=Arrays.asList(21,43,45,45,67,78,89,90,43);
List<Integer> result=li.stream().distinct().sorted().collect(Collectors.toList());
System.out.println(result);
		
	
	}

}
