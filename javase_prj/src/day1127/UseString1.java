package day1127;

public class UseString1 {
	// �̸����� �Է¹޾� �̸����� ��ȿ���� �����Ͽ� boolean������ (5���̻��̸鼭 @, . ����)
	// ����� ����� ��ȯ�ϴ� ���� �ϴ� method�� ����� ȣ���Ͽ�
	// ����غ�����
	private boolean validEmail(String email) {
		boolean flag = false;
//		if(email.length()>=6 && email.indexOf("@")!=-1 && email.indexOf(".")!=-1) {
//			flag=true;
//		}//end else
		flag = email.length() >= 6 && email.contains("@") && email.contains(".");
//		flag =email.length()>=6 && email.indexOf("@")!=-1 && email.indexOf(".")!=-1;
		
		//�޼ҵ�� �ϸ� �ϰ� ����ϴ� ���� ����
//		if (flag == true) {
//			System.out.println("�̸��� ����");
//		} else {
//			System.out.println("�̸��� ������");
//		}
		return flag;
//		return email.length()>=6 && email.contains("@") && email.contains(".");

	}
	
	//'�ñ����� ������ '�ּҸ� n�� �Է¹޾� ��������� �ƴ��� ���� �Ǵ��Ͽ�
	//����ϴ� method
	

	public static void main(String[] args) {
		UseString1 us1 = new UseString1();
//		us1.validEmail("abc@de.kr");
//		us1.validEmail("abc@dekr");
//		us1.validEmail("abcde.kr");
		String email = "dd@dd.net";
		 if(us1.validEmail(email)){
		System.out.println("��ȿ");
	}else {
		System.out.println("��ȿ");
	}

	}

}
