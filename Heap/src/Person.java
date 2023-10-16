

//직접 비교기준을 작성을 해보자.
public class Person implements Comparable<Person>  {
	public String name;
	public int age;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person o) {
//		return Integer.compare(this.age, o.age); //나이순 정렬
		return this.name.compareTo(o.name); //이름순 정렬
	}
	
}
