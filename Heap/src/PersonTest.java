import java.util.Comparator;
import java.util.PriorityQueue;

public class PersonTest {
	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>(new NameComparator());
		
		//익명클래스 : 객체를 한번만 생성해서 사용할 때 주로 사용
		//클래스 안만들고 Comparator 사용하고 싶을 경우
		PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age == o2.age)
					return o1.name.compareTo(o2.name);
				return o1.age - o2.age;
			}
		});
		
		//람다표현식도 있음 -> 나중에
		
		pq.offer(new Person("이예원", 20));
		pq.offer(new Person("전지현", 10));
		pq.offer(new Person("허윤진", 25));
		pq.offer(new Person("박영규", 25));
		pq.offer(new Person("전성재", 29));
		pq.offer(new Person("박광진", 56));
		pq.offer(new Person("차다운", 24));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
}
