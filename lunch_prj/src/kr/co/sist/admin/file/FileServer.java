package kr.co.sist.admin.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.run.LunchAdminMain;

public class FileServer extends Thread{
	@Override
	public void run() {
//		System.out.println("돌아갑니다아");
		ServerSocket server = null;
		
		try {
			try {
				server=new ServerSocket(25000);
				Socket client = null;
				DataInputStream dis = null;
				int cnt = 0;
				String[] fileNames = null;
				String[] serverFileNames = null;
				
				List<String> tempFileList=new ArrayList<String>();
				DataOutputStream dos = null;

				while(true) {
					System.out.println("서버가동");
					client=server.accept();
					System.out.println("접속자 있음");
					
					dis = new DataInputStream(client.getInputStream());
					
					cnt = dis.readInt();//클라이언트가 보내오는 파일명의 갯수
					fileNames = new String[cnt];
					
					for(int i=0; i<cnt; i++) {
						fileNames[i]=dis.readUTF();
						System.out.println(i+"번째 파일"+fileNames[i]);
					}//end for
					
					//서버에 존재하는 파일명을 배열로 복사
					serverFileNames = new String[LunchAdminMain.lunchImageList.size()];
					LunchAdminMain.lunchImageList.toArray(serverFileNames);
					
					System.out.println("서버 "+Arrays.toString(serverFileNames));
					System.out.println("클라이언트 "+Arrays.toString(fileNames));
					
					//클라이언트가 보내온 파일명과 서버의 파일명을 비교하여
					//클라이언트가 없는 파일명을 출력
					for(String tName:LunchAdminMain.lunchImageList) {
						tempFileList.add(tName);
						tempFileList.add("s_"+tName);
					}//end for

					System.out.println("temp리스트"+tempFileList);
					
					for(String rmName :fileNames) {
						tempFileList.remove(rmName);
						tempFileList.remove("s_"+rmName);
						
					}//end for
					System.out.println("제거 후 temp리스트"+tempFileList);
					
					dos = new DataOutputStream(client.getOutputStream());
					dos.writeInt(tempFileList.size());//전송할 파일의 갯수를 보낸다.
//					System.out.println("없는 파일 : "+tempFileList);
					
					for(String fName:tempFileList) {
						fileSend(fName, dos);
						try {
							Thread.sleep(1000);
						}catch(InterruptedException ie) {
							ie.printStackTrace();
						}//end catch
						
					}//end for
					
				}//end while

			}finally {
				if(server!=null) {server.close();}//end if
			}//end finally
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(null, "파일 보내기 실패");
			ie.printStackTrace();
		}//end catch
	}//run
	
	private void fileSend(String fname, DataOutputStream dos)throws IOException{
		
		FileInputStream fis = null;

		try {
			int fileData = 0;
			
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fname);
			byte[] readData = new byte[512];
			
			int fileLen = 0;
			while((fileLen=fis.read(readData))!=-1) {
				fileData++;
			}//end while
			
			fis.close();
			dos.writeInt(fileData);
			dos.flush();
			
			dos.writeUTF(fname);//writeUTF
			
			fis=new FileInputStream("C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/"+fname);
			while((fileLen=fis.read(readData))!=-1 ) {//서버에서 전송한 파일조각을 읽어들여
				dos.write(readData,0,fileLen);//생성한 파일로 기록
//				fileData--;
			}//end while
			dos.flush();
			
		}finally {
			if(fis!=null) {fis.close();}//end if
		}//end finally
		
	}//fileSend
	
	/*public static void main(String[] args) {
		new FileServer().start(); //인스턴스 +실행
	}//main
*/
	
}//class
