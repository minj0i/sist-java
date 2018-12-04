package day1130;

public class RunConstr {

	public static void main(String[] args) {
//		SubConstr sc = new SubConstr();
//		SubConstr sc1 = new SubConstr(200);
		 //부모 기본, 부모인자 300, 자식인자 200, 자식기본
//		SubConstr sc3 = new SubConstr();
//1번 방법
//		public SuperConstr() {
//			System.out.println("부모의 기본생성자");
//		}//SuperConstr
//		
//		public SuperConstr(int i) {
//			this.i=i;
//			System.out.println("부모의 인자생성자"+i);
//		}//SuperConstr
		
//		public SubConstr() {
//			super();
//			SubConstr sc = new SubConstr(300);
//			System.out.println("자식의 기본생성자");
//		}// SubConstr
//		
//		public SubConstr(int i) {
//			super(200);
//			System.out.println("자식의 인자생성자"+i);
//		}
//2번 방법
//		public SuperConstr() {
//			System.out.println("부모의 기본생성자");
//		}//SuperConstr
//		
//		public SuperConstr(int i) {
////			this.i=i;
//			this();
//			System.out.println("부모의 인자생성자"+i);
//
//		}//SuperConstr
//		public SubConstr() {
////			super();
//			this(200);
//			System.out.println("자식의 기본생성자");
//		}// SubConstr
//		
//		public SubConstr(int i) {
//			super(300);
//			System.out.println("자식의 인자생성자"+i);
//		}	
		
		
		
		
		//부모인자 100, 부모기본, 자식기본, 자식인자 100
//		SubConstr sc2 = new SubConstr(100);
//		public SuperConstr() {
//			System.out.println("부모의 기본생성자");
//		}//SuperConstr
//		
//		public SuperConstr(int i) {
////			this.i=i;
//			System.out.println("부모의 인자생성자"+i);
//		}//SuperConstr
		
//		public SubConstr() {
//			super();
//			System.out.println("자식의 기본생성자");
//		}// SubConstr
//		
//		public SubConstr(int i) {
//			super(200);
//			SubConstr sc = new SubConstr();
//			System.out.println("자식의 인자생성자"+i);
//		}
//2번 방법
		SubConstr sc2 = new SubConstr(100);
//		public SuperConstr() {
//			this(100);
//			System.out.println("부모의 기본생성자");
//		}//SuperConstr
//		
//		public SuperConstr(int i) {
//			System.out.println("부모의 인자생성자"+i);
//		}//SuperConstr
//		public SubConstr() {
//			super();
//			System.out.println("자식의 기본생성자");
//		}// SubConstr
//		
//		public SubConstr(int i) {
//			this();
//			System.out.println("자식의 인자생성자"+i);
//		}
	}

}
