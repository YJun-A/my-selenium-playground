import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;


public class JavaStreamsLambdaExpression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//To count the number of names with the alphabet A in the list
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arthur");
		names.add("Timothy");
		names.add("Arnold");
		names.add("Emily");
		names.add("Benjamin");
		names.add("Adam");
		
		int count = 0;
		
		for(int i = 0 ; i < names.size() ; i++) {
			
			String actual = names.get(i);
			if(actual.startsWith("A"))
				count++;
			
		}//for
		

	}//main
	
	
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arthur");
		names.add("Tim");
		names.add("Arnold");
		names.add("Emily");
		names.add("Ben");
		names.add("Adam");
		
		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);
		
		
		Long d = Stream.of("Arthur" , "Timothy" , "Arnold" , "Emily" , "Benjamin" , "Adam").filter(s ->
		{
			
			s.startsWith("A");
			return true;

		}).count();
		
		System.out.println(d);
		
		//To print names of ArrayList
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println());
		
	}
	
	public void streamMap() {
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Arthur");
		names.add("Tim");
		names.add("Arnold");
		
		//To print names of length > 4 with Uppercase
		Stream.of("Arthur" , "Tim" , "Arnold" , "Emma" , "Ben" , "Adam").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.forEach(s -> System.out.println(s));
		
		
		//To print names with first letter as A with uppercase and sorted
		List<String> names1 = Arrays.asList("Arthur" , "Tim" , "Arnold" , "Emma" , "Ben" , "Adam");
		names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		newStream.sorted().forEach(s -> System.out.println(s));
		
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
		Assert.assertTrue(flag);
	}
	
	public void streamCollect() {
		
		//To modify list content and create a new list
		List<String> newlist = Stream.of("Arthur" , "Tim" , "Arnold" , "Emma" , "Ben" , "Adam").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
		.collect(Collectors.toList());
		
		//To print unique, distinct values
		List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
		numbers.stream().distinct().forEach(s -> System.out.println(s));
		List<Integer> sortedNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(sortedNumbers.get(2));
		 
	}

}//class
