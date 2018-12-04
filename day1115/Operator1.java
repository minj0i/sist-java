package day1115;
/*
	단항연산자(Unary)
	~, !, +, -, ++, --
*/

class Operator1 {
	public static void main(String[] args) {
		int i=11;
		int j=-11;
		//~(tilde): 1의 보수연산
		//~양수: 부호변경 1증가
		System.out.println("~"+i+"="+~i);//-12
		//~음수: 부호변경 1감소
		System.out.println("~"+j+"="+~j);//10	
		
		//!(NOT): true-> false, false -> true
		boolean b = true;
		boolean c = false;
		System.out.println("!"+b+"="+!b);//false
		System.out.println("!"+c+"="+!c);//true
		System.out.println(!(11>15));//!은 boolean에만 사용가능

		//+: 형식적제공
		System.out.println("+"+i+"="+ +i);//11
		System.out.println("+"+j+"="+ +j);//-11

		//-: 2의보수연산, 부호바꿈연산
		System.out.println("-"+i+"="+ -i);//-11		
		System.out.println("-"+j+"="+ -j);//11

		//++:증가연산 (대상체의 값을 1씩 증가)
		i=0;
		j=10;

		//전위연산: 연산자 대상체;
		++i;
		--j;
		System.out.println("전위연산 후 i="+i);//1		
		System.out.println("전위연산 후 j="+j);//9
		
		//후위연산: 대상체 연산자;
		i++;
		j--;
		System.out.println("후위연산 후 i="+i);//2		
		System.out.println("후위연산 후 j="+j);//8

		//증가연산자와 감소연산자는 대입연산자와 함께 사용되면
		//전위와 후위가 다른 값을 대입한다.
		j=0;
		j=++i;
		System.out.println("전위연산후 i: "+i+", 대입j: "+j);
		//후위: 남의 것 먼저
		j=0;
		j=i++;
		System.out.println("후위연산후 i: "+i+", 대입j: "+j);
	}
}
