package day1128;

/**
 * �л��� Oracle,Java,JDBC ���������� ó���ϴ� ���α׷�
 * @author owner
 */
public class ScoreProcess2 {
	
	private int total;
	private double average;
	private int o_total;
	private int j_total;
	private int jdbc_total;
	private int o_maxScore;
	private int j_maxScore;
	private int jdbc_maxScore;
	private int maxScore;
	private int topstunum;
	private String topstuname;
	private int temp;// ���İ��� �ӽ÷� ������ ����
	
	
	public ScoreProcess2() {
		total=0;
	}//ScoreProcess2
	
	/**
	 * ������ ���� �� ��Ų��.
	 * @param score
	 */
	public void addTotal(int score) {
		total+=score;
	}//addTotal
	
	/**
	 * ������ ��� ���� ��.
	 * @return
	 */
	public int getTotal() {
		return total;
	}//getTotal
	
	/**
	 * ���� ������ �ʱ�ȭ. 
	 */
	public void resetTotal() {
		total=0;
	}//resetTotal
	
	/**
	 * 1-1)))) �� �л����� ������ ��� ���ϱ�
	 * (�Ҽ����� ���ü��� �־� ����� �Ҽ����� ���ڸ� ������ ���
	 * @param total
	 */
	public void average(int total, int[][] score) {
//		average=(total/3);
		average=(total/score[1].length);
		
	}//average
	/**
	 * 1-1)))) ����� ��� ��
	 * @return
	 */
	public double getAverage() {
		return average;
	}//getAverage
	
//	1-1) �غ�..
//	public int average2(int total) {
//		average=(total/3);
//		return average;
//	}// ����Ҷ����� �Ű������� �־��־�� �ϹǷ� �����ϴ°� �� ���ϰڴ�.
	
//	public void subjecttotal(int[][] score) {
//		o_total=o_total+score[i][0];
//		j_total=j_total+score[i][1];
//		jdbc_total=jdbc_total+score[i][2];
//	}//subjecttotal
	
	
	
	////1-5.�ϵ� �л��� �̸��� ����, ��ȣ  (������ �ְ���)
	public void topstu(String[] name, int[][] score) {
//		getTotal();
		//�л������� ��Ż�� ������ ������ ���Ͽ� �ְ������� �л��� �̸��� ���������� ������ ��ȯ.
//		if(o_maxScore<score[i][0]) {
//			//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
//			o_maxScore=score[i][0];
//		}//�ڹ��� �ְ� ����
		
		//���� ���� [6][] ���� ������ ������ �ְ���÷�̶� ������ ���� i�� name�� i�� ���� name�� ���ϰ�
		//i�� ��ȣ.
		for(int i=0; i<score.length; i++) {//��
			
			for(int j=0; j<score[i].length ;j++) {//��	
				addTotal(score[i][j]);
			}
			if(maxScore<getTotal()) {
				//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
				maxScore=getTotal();
				topstunum=i+1;
				topstuname=name[i];
//				System.out.println(maxScore+" "+topstunum+" "+topstuname);
			}//�ְ����ϰ� �� ����.
//			if (getTotal()==maxScore) {
//				System.out.printf("%d\t%s\n",i+1,name[i]);	
//			}//�̸��� ��ȣ ���
			resetTotal();
		}
//		System.out.println(maxScore+" "+topstunum+" "+topstuname);
	}//topstu
	
	//1-6.�ڹ������� �������� �����Ͽ� ���.
	public void sort(int[][] score) {
		//������ �����ϰ� �ʹ�...��������/��������   =>���� ����
//		:ó�� ���ǰ��� ������ ���� ���Ͽ� ������ ���� �޹��� ������ �۴ٸ� ������ ���� �޹��� ���� 
//		�ٲ۴�. �� �۾��� ������� ���� �ι�° ����� �Ǵٽ� �ݺ�
		
		for(int i=0;i<score.length-1;i++) {
			for(int j=i+1; j <score.length; j++) {
				if(score[i][1] > score[j][1]) {  
				//�չ��� ���� �޹溸�� �۴ٸ� ��������, ũ�Ժ��ϸ� �������� ����
					temp=score[i][1];
					score[i][1]=score[j][1];
					score[j][1]=temp;
				}//end if
			}//end for
		}//end for
		for (int i=0;i<score.length; i++) {
			System.out.printf("%-4d",score[i][1]);
		}//end for
		System.out.println();
	}
	
	
//	2.������ �迭�� ����� (��������������) �Ʒ��� ���� ���� �־� ����ϴ� method �ۼ�.
//	1 1 1 1 1 1 1 1 1 1
//	1 0 0 0 0 0 0 0 0 1
//	1 0 0 0 0 0 0 0 0 1
//	1 0 0 0 0 0 0 0 0 1
//	1 0 0 0 0 0 0 0 0 1
//	1 1 1 1 1 1 1 1 1 1
	public void arrayTest() {
		System.out.println("---------------------------------------------");
//		for(int i=0; i<6; i++) {
//			for(int j=0; j<11; j++) {
//				if((i>0&&i<5) && (j>0&&j<10)) {
//					System.out.print(0);
//				}else {
//					System.out.print(1);
//				}
//			}
//			System.out.println();
//		}
		int[][] arr= new int[6][10];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if((i>0&&i<arr.length-1) && (j>0&&j<arr[0].length-1)) {
					arr[i][j]=0;
				}else {
					arr[i][j]=1;
				}
				System.out.print(arr[i][j] +" ");
			}
			System.out.println();
		}
	}
	

	
	public String[] nameData() {
		String[] name = {"������","������","���ü�","������","������","�����"};
		return name;
	}//nameData
	
	
	public int[][] scoreData(){
		int[][] score = {{85,86,81},{95,91,100},{89,71,59},
						{97,96,91},{78,74,77},{100,95,68}};
		return score;
	}//scoreData
	
	
	public void printScore(String[] name, int[][] score) {
//		int total=0;
		//1-1.�� �л��� ����� ���Ͽ� ���. (�Ҽ����� ���ü��� �־� ����� �Ҽ����� ���ڸ� ������ ���
		
		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����\t���");
		
//		System.out.println("��ȣ\t�̸�\tOracle\tJava\tJDBC\t����");
		System.out.println("----------------------------------------------------");
		
		for(int i=0; i<score.length; i++) {//��
			System.out.printf("%d\t%s\t",i+1,name[i]);
			for(int j=0; j<score[i].length ;j++) {//��
				System.out.printf("%d\t",score[i][j]);
//				total+=score[i][j];//������ ����Ʈ��� ������ ��������.
				addTotal(score[i][j]);
				
//				average=(total/3);	
//				average(total);
				average(total,score);
//				average2(total);
				
				//����Ŭ�� �ְ�����
				if(o_maxScore<score[i][0]) {
					//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
					o_maxScore=score[i][0];
				}//�ڹ��� �ְ� ����
				//�ְ������� ���� ��ȯ���� ���� ������ �۴ٸ� 
				if(j_maxScore<score[i][1]) {
					//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
					j_maxScore=score[i][1];
				}//end if
				//JDBC�� �ְ�����
				if(jdbc_maxScore<score[i][2]) {
					//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
					jdbc_maxScore=score[i][2];
				}//end if
								
			}//end for
			
//			System.out.println(total);
//			System.out.println(getTotal());
			System.out.print(getTotal()+"\t");
			
//			System.out.println(average);
			System.out.println(getAverage());
//			System.out.printf("%.1d",getAverage());
//			System.out.println(average2(total));

			o_total=o_total+score[i][0];
			j_total=j_total+score[i][1];
			jdbc_total=jdbc_total+score[i][2];
			
//			total=0;//�ʱ�ȭ�� �����ʾ� ����.
			resetTotal();

		}//end for
		System.out.println("----------------------------------------------------");
		
		//2.�� ����� ������ ������ ����
		System.out.printf("�������� :\t %d\t%d\t%d\t ������ ���� :%d\t \n",o_total,j_total,
							jdbc_total,o_total+j_total+jdbc_total);
		
		//3.�� ����� ��հ� ��ü ���(��ü ����� �Ҽ����� ���ڸ� �������)
		System.out.printf("���� ���:\t %d\t%d\t%d\t��ü ���:\t%.2f\t \n",
							o_total/name.length,j_total/name.length,jdbc_total/name.length,
							(double)(o_total/name.length+j_total/name.length+jdbc_total/name.length)/score[1].length);
		//4.�� ����� �ְ� ������ ���
		System.out.printf("�ְ� ����\t java[%d] Oracle[%d] JDBC[%d]\n",o_maxScore,j_maxScore,jdbc_maxScore);
		
		//5.�ϵ� �л��� �̸��� ����, ��ȣ
		topstu(name, score);
		System.out.println("Top ��ȣ�� ["+topstunum+"] �̸� ["+ topstuname+"] ���� ["+ maxScore+"]");
//		System.out.printf("Top ��ȣ[%d] �̸�[%s] ����[%d]",topstu(name, score).topstunum,topstu(name, score).topstuname,topstu(name, score).maxScore);
		//6.�ڹ������� �������� �����Ͽ� ���.
		sort(score);
		
	
		
		
		
	}//printScore
	
	public static void main(String[] args) {
		ScoreProcess2 sp2 = new ScoreProcess2();
		//ó���� ������ �ޱ�
		String[] name = sp2.nameData();
		int[][] score =sp2.scoreData();
		//ó��
		sp2.printScore(name,score);
		
		
		sp2.arrayTest();
		
	}//main
}//class
