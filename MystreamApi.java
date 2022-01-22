package java_practice;

import java.util.*;
import java.util.stream.Collectors;

class book
{
	private int no;
	private String name;
	private int prices;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public book(int no, String name, int prices) {
		this.no = no;
		this.name = name;
		this.prices = prices;
	}
	@Override
	public String toString() {
		return "book [no=" + no + ", name=" + name + ", prices=" + prices + "]";
	}
	public int compareTo(book val2) {
		
		return Integer.compare(this.prices, val2.prices);
	}
	@Override
    public int hashCode() {
        return Objects.hash(no);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        book other = (book) obj;
        return Objects.equals(no, other.no);
    }
	
	
}
public class MystreamApi {

	public static void main(String args[])
	{
		
		List<book> ls = new ArrayList<book>();
		
		
		ls.add(new book(3,"eat the frog",146));
		ls.add(new book(3,"eat the frog",146));
		ls.add(new book(4,"helloworld",100));
		ls.add(new book(1,"alchemist",210));
		ls.add(new book(2,"sapiens",336));
		
		/*ls.stream()
		.filter(student->student.getFees()>500)
		.forEach(s->System.out.println(s));
		
		System.out.println();
		Stream<String> stream = Stream.empty();
		
		List<Student1> ls1=ls.stream()
				.filter(student1->student1.getName().startsWith("g"))
				.collect(Collectors.toList());
		ls1.forEach(s->System.out.println(s));
		System.out.println();
		
		ls.stream()
		.filter(student1->student1.getFees()>1000)
		.forEach(s->System.out.println(s));
		
		System.out.println();
		Collection<Integer> collection= Arrays.asList(1000,200,5000,200);
		
		Stream<Integer> streamofcollection=collection.stream();
		
		Collection<Integer> collections = streamofcollection
				.filter(value->value==200)
				.collect(Collectors.toList());
		System.out.println(collections);
		
		*/
		
		//1.count
		
		long count=ls.stream()
		.filter(book->book.getPrices()>150)
		.count();
		System.out.println("no.of books which cost more than 150rs: "+count);
		
		System.out.println();
		//2.min
		Optional<book> min = ls.stream()
				.min((val1,val2)->val1.compareTo(val2));
		
		System.out.println("the book which cost the least is: "+min.get());
		System.out.println();
		
		//3.max
		Optional<book> max = ls.stream()
				.min((val1,val2)->val2.compareTo(val1));
		
		System.out.println("the book which cost the highest is: "+max.get());
		System.out.println();
		
		//4.filter
		ls.stream()
		.filter(book->((book.getName().equals("sapiens"))))
		.forEach(s->System.out.println(s));
		System.out.println();
		
		//5.map
		
		ls.stream()
		.map(book->book.getName().toUpperCase())
		.forEach(s->System.out.println(s));
		System.out.println();
		
		//6.collectors
		
		List<book> ls2=ls.stream()
		.filter(book->book.getName().startsWith("a"))
		.collect(Collectors.toList());
		ls2.forEach(s->System.out.println(s));
		System.out.println();
		
		//7.distinct
		
		ls.stream()
		.distinct()
		.forEach(s->System.out.println(s));
		
		System.out.println();
		
		//8.sort
		
		System.out.println("ascending order which are distinct");
		ls.stream()
		.sorted(Comparator.comparingInt(book::getNo))
		.distinct()
		.forEach(s->System.out.println(s));
		System.out.println();
		System.out.println("decending order which are not distinct");
		ls.stream()
		.sorted(Comparator.comparingInt(book::getNo).reversed())
		.forEach(s->System.out.println(s));
		
	}
}
