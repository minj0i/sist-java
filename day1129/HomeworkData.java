package day1129;

public class HomeworkData {
		public String name;
		public String addr;
		public int age;
		public String gender;
		
		public HomeworkData(String name, String addr, int age, String gender) {
			this.name=name;
			this.addr=addr;
			this.age=age;
			this.gender=gender;
		}//HomeworkData
		
		public void setName(String name) {
			this.name=name;
		}//setName
		public void setAddr(String addr) {
			this.addr=addr;
		}//setEmail
		public void setAge(int age) {
			this.age=age;
		}//setAge
		public void setGender(String gender) {
			this.gender=gender;
		}//setGender
		
		public String getName() {
			return name;
		}//getName
		public String getAddr() {
			return addr;
		}//getEmail
		public int getAge() {
			return age;
		}//getAge
		public String getGender() {
			return gender;
		}//getGender
		
//		public String toString() {
//			return "이름: "+name+", 나이: "+age+", 이메일: "+email+", 이니셜: "+initial;
//		}
		
		
		
	}//class

