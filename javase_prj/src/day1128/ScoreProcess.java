package day1128;


/**
 * 4������ �л����� ����ó�� ���α׷�<br>
 * @author owner
 */
public class ScoreProcess {
	
//	private String[] nameArr= {"������","���ü�","������","��ǿ�","������"};	//�ȿ����� �ۿ����� ����
//	private int[] scoreArr = {89, 77, 99, 64, 50};
	
	public ScoreProcess() {
		String[] nameArr= {"������","���ü�","������","��ǿ�","������"};//�ȿ����� �ۿ����� ����
		int[] scoreArr =  {89, 76, 99, 64, 50};
		int totalScore=0;// ������ ���� ���ϱ� ���� ����
		int maxScore = 0;// �ְ�����
		int minScore = 101;// ��������
		int temp = 0;// ���İ��� �ӽ÷� ������ ����
		
		
		//��� ���� �� ���
		System.out.println("��ȣ\t�̸�\t����");
		System.out.println("--------------------");
		
		for(int i=0;i<nameArr.length;i++) {
			System.out.printf("%d\t%s\t%d\n", i+1,nameArr[i],scoreArr[i]);
			//��½� 0���� �����ϱ� ������ i+1�� ǥ���� ������ 1���� ��µǰ� ����� �ִ�.
			//��½� ĭ�� �����ʾƵ� �۲ö����� �� ���� ���� ������ �ʴ´�..
			totalScore+=scoreArr[i]; //totalScore=totalScore+scoreArr[i];

			//�ְ������� ���� ��ȯ���� ���� ������ �۴ٸ� 
			if(maxScore<scoreArr[i]) {
				//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
				maxScore=scoreArr[i];
			}//end if
			
			//�ְ������� ���� ��ȯ���� ���� ������ ũ�ٸ�
			if(minScore>scoreArr[i]) {
				//���� ��ȯ����  ���� ������ �ְ������� ������ �ش�.
				minScore=scoreArr[i];
			}//end if
		}//end for
		//�����ο�����ϰ����
		System.out.println("�����ο� : "+nameArr.length+"��");
		//������ ���ϰ����
		System.out.printf("���� [%5d] ��� [%.2f] \n",totalScore,
							(double)totalScore/nameArr.length);
		//totalScore/nameArr.length=�����̹Ƿ� %.2f �Ҽ����ڸ��� ���� ����.
		//���� Casting �Ͽ� �Ҽ����ڸ����� ����Ѵ�.
//		System.out.println(totalScore/nameArr.length);//75.6�̶� �Ҽ����� ������ �ʴ´�.

		//�ְ����� ���ϰ� ����
		//:ó������ ���� ������ �����ϰ� ������ ���� ��(if)�Ͽ� ������ �۴ٸ�(����) ������ ������ ������ ���� �����ϰ�(����)
		//����� ������ ������ �״������� ���� ���Ͽ� �����ϴ� �۾��� ������ ����(�ݺ�)�Ѵ�. 
		//���������� ���̸� switch��õ/ �ȶ������� if
		System.out.printf("�ְ��� :[%3d] ������ :[%d]\n",maxScore,minScore);
		//�������� 101���� ���Ͽ� ���踸 �ݴ�ǰ� �ٲٸ� ���Ҽ� �ִ�.
		
		//������ �����ϰ� �ʹ�...��������/��������   =>���� ����
//		:ó�� ���ǰ��� ������ ���� ���Ͽ� ������ ���� �޹��� ������ �۴ٸ� ������ ���� �޹��� ���� 
//		�ٲ۴�. �� �۾��� ������� ���� �ι�° ����� �Ǵٽ� �ݺ�
		
		for(int i=0;i<scoreArr.length-1;i++) {
			for(int j=i+1; j <scoreArr.length;j++) {
				if(scoreArr[i] < scoreArr[j]) {  //�չ��� ���� �޹溸�� �۴ٸ�
					temp=scoreArr[i];
					scoreArr[i]=scoreArr[j];
					scoreArr[j]=temp;
				}//end if
			}//end for
		}//end for

//		�ҿ��� �ڵ�
//		for(int i = 0; i < scoreArr.length-1; i++) {
//			for(int j = i+1; j < scoreArr.length; j++) {
//				if(scoreArr[i] < scoreArr[j]) { //�չ��� ���� �޹溸�� �۴ٸ� ��������, ũ�ٸ� ��������
//					temp = scoreArr[i];
//					scoreArr[i]=scoreArr[j];
//					scoreArr[j]=temp;
//					
//				}//end if
//			}//end for-j
//		}//end for-i
		
		for (int i=0;i<scoreArr.length; i++) {
			System.out.printf("%-4d",scoreArr[i]);
		}//end for
		
		System.out.println();
	
		
	}//ScoreProcess

	public static void main(String[] args) {
		new ScoreProcess();
		System.out.println("---------------------------------");
		//1-9 �츦 ��ȯ  "���"
		int birth=1999;
		String[] zodiac = {"������","��","��","����","��","��",
								"ȣ����","�䳢","��","��","��","���"};
		System.out.println(zodiac[birth%12]);
		
	}//main
}//class
