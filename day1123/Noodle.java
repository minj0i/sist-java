package day1123;

/**
 * 라면을 추상화하여 만든 클래스 <br>
 * 명사적특징: 회사명, 동그란/넙적한형태, 수프갯수, 가격 <br>
 * 동사적특징: 팔린다.
 * 
 * @author owner
 */
public class Noodle {
	private String name, company, shape;
	private int drysoup, price;

	
	/**
	 * 11-26-2018 코드 추가
	 */
	public Noodle() {
		this("비빔면","팔도","원형",2,700);
	}
	
	/**
	 * 11-26-2018 인자있는 생성자 코드 추가
	 * @param name
	 * @param company
	 * @param shape
	 * @param drysoup
	 * @param price
	 */
	public Noodle(String name, String company, String shape, int drysoup, int price) {
	this.name=name;
	this.company=company;
	this.shape=shape;
	this.drysoup=drysoup;
	this.price=price;
	}

	
	/**
	 * 라면 이름을 설정하는일
	 * @param name 라면이름
	 */
	public void setName(String name){
		this.name = name;
	}//company
	
	/**
	 * 라면 제조사를 설정하는일
	 * @param company 제조사명
	 */
	public void setCompany(String company){
		this.company = company;
	}//company
	
	/**
	 * 면발 형태를 설정하는 일<br>
	 * 원형이나 사각형의 형태
	 * @param shape 면발형태
	 */
	public void setShape(String shape) {
		if (shape.equals("원형") || shape.equals("사각형")) {
			this.shape=shape;
		}else {
			this.shape="원형";
		}
	}//shape
	
	/**
	 * 건더기수프 갯수를 세는 일
	 * @param drysoup 건더기수프의 갯수
	 */
	public void setDrysoup(int drysoup) {
		this.drysoup=drysoup;
	}//drysoup
	
	/**
	 * 라면 가격을 설정하는 일
	 * @param price 라면의 가격
	 */
	public void setPrice(int price) {
		this.price=price;
	}//price
	
	/**
	 * 라면 명을 반환하는 일
	 * @return name
	 */
	public String getName() {
		return name;
	}//getName
	
	/**
	 * 라면 제조사를 반환하는 일
	 * @return company
	 */
	public String getCompany() {
		return company;
	}//getName
	
	/**
	 * 라면 형태를 반환하는 일
	 * @return shape
	 */
	public String getShape() {
		return shape;
	}//getName
	
	/**
	 * 건조수프 갯수를 반환하는 일
	 * @return drysoup
	 */
	public int getDrysoup() {
		return drysoup;
	}//getName
	
	/**
	 * 라면 가격을 반환하는 일
	 * @return price
	 */
	public int getPrice() {
		return price;
	}//getName
	
	/**
	 * 동사적 특징
	 * 판매된다고 표현
	 * @return 결과
	 */
	public String sale() {
		return "라면 "+name+"은(는) "+company+"에서 판매된다.";
	}//sale
	
	public String output(String shape, int drysoup) {
		return name+"은(는) 꺼내면 "+shape+"이며 "+drysoup+"개의 건조수프를 넣으세요.";
	}//eat
	
	public void print() {
		System.out.format("생성된 라면 정보 이름[%S],제조사명[%S],면발모양[%S],건더기수프갯수[%d],가격[%d]\n",
		name, company, shape,drysoup,price);
	}
	
}
