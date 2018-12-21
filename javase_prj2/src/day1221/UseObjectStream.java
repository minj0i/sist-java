package day1221;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * UserData�� ��ü�� �����Ͽ� ��½�Ʈ���� ���� ���Ϸ� ��������
 * �о���̴� ��.
 * @author owner
 */
public class UseObjectStream {

	public void UseObjectOutputStream() throws IOException{
		
		ObjectOutputStream oos = null;
		try {
			File file = new File("c:/dev/temp/obj_data.");
			//��ü(JVM)�� ����ȭ�Ͽ� ������(HDD File)�� �������� ��Ʈ��
			oos = new ObjectOutputStream(new FileOutputStream(file));
			UserData ud = new UserData(26,70.1,"������");
			//��ü�� ����ȭ�� ���� ������ ��Ʈ������ ������ �� ����.
			oos.writeObject(ud);//��ü�� ����ȭ�Ͽ� ��Ʈ���� ����.
			oos.flush();//��Ʈ���� ��ϵ� ������ �������� �����Ѵ�.
			System.out.println("��ü�� ���Ϸ� ���!");
			
		}finally {
			if(oos!=null) {oos.close();}//end if
		}//end finally
	}//UseObjectOutputStream
	
	public void useObjectInputStream() throws IOException, ClassNotFoundException{
		//��ü�� �б����� ��Ʈ�� ����
		ObjectInputStream ois = null;
		try {
			File file = new File("c:/dev/temp/obj_data.");
			
			//File�� ����� ��ü�� �б����� ��Ʈ�� ����
			ois = new ObjectInputStream(new FileInputStream(file));
			//��Ʈ���� ���ؼ� ����ȭ�� ��ü�� ��� ������(�𸶼���)
			UserData ud =(UserData)ois.readObject();
			System.out.println("�о���� ��ü�� �� �̸�:" +ud.getName()
			+"/����:"+ud.getAge()+"/������:"+ud.getWeight());
			
			
		}finally {
			if(ois!=null) {ois.close();}//end if
		}//end finally
	}//useObjectInputStream
	
	public static void main(String[] args) {
		UseObjectStream uos = new UseObjectStream();
//		try {
//			uos.UseObjectOutputStream();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		System.out.println("================================");
		try {
			uos.useObjectInputStream();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
	}//main
}//UseObjectStream
