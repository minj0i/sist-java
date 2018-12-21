package day1221;

import java.io.Serializable;

/**
 * 데이터를 가지고 있는 클래스로(VO를 담고 있음)
 * @author owner
 */
public class UserData implements Serializable{
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1433112021624942957L;//UserData에 warning뜸
	private int age;
	private /*transient*/ double weight;
	private /*transient*/ String name;
	
	//transient: 직렬화를 막는 키워드(값이 JVM 외부로 전달이 되지 않는다)
	public UserData() {
	}//UserData

	public UserData(int age, double weight, String name) {
		this.age = age;
		this.weight = weight;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	//주소가 아니라 값이 나갈 수 있도록
	public String toString() {
		return "UserData [age=" + age + ", weight=" + weight + ", name=" + name + "]";
	}
	
	
	
}
