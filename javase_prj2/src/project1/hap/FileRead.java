package project1.hap;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileRead {

	private String tempLog;
	private MainControlVO mcvo;
	private String[] tempArr;

	/**
	 * file�ּҸ� String���� �޾Ƽ� tempArr�� split�Ͽ� ����
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public FileRead(String fileName) throws IOException {
		mcvo = new MainControlVO();
		File file = new File(fileName);
		if (file.exists()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				tempLog = "";
				String temp = "";
				while ((temp = br.readLine()) != null) {// �ٴ���(\n)�� �о �о���� ������ �ִٸ�
					tempLog += temp;
				}
				tempLog = tempLog.replace("[", "");
				tempArr = tempLog.split("]");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					br.close();
				} // �ݵ�� ������ ����
			}
		} else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}
	}// FileRead
	
	public FileRead(String fileName, int[] selectedLine) throws IOException {
		mcvo = new MainControlVO();
		File file = new File(fileName);
		if (file.exists()) {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				tempLog = "";
				String temp = "";
				int count = 0;//�ټ��� ���� ���� ����
				while ((temp = br.readLine()) != null) {// �ٴ���(\n)�� �о �о���� ������ �ִٸ�
					count += 1;
					if (count<selectedLine[0]) {//�ټ��� �Էµ� ���� �ټ����� �۴ٸ�
						//�������� �ʰ� ���� ������.
					}else {//�ټ��� �Էµ� ���� �ټ����� ũ�ٸ�
						tempLog += temp;//�����Ѵ�
					}
					if (count == selectedLine[1]) {//�ټ��� �Էµ� ������ �ټ��� ���ٸ�
						break; //while���� ������.
					}
					
					
				}
				tempLog = tempLog.replace("[", "");
				tempArr = tempLog.split("]");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					br.close();
				} // �ݵ�� ������ ����
			}
		} else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
		}
	}// FileRead

	/**
	 * tempArr�� ����� String�� ���� Code, Url, Brower, Time���� ������ Set�� ����
	 */
	public void logToSet() {
//		System.out.println(tempLog);
		Set<String> tempCodeSet = mcvo.getCodeSet();
		Set<String> tempUrlSet = mcvo.getUrlSet();
		Set<String> tempBrowserSet = mcvo.getBrowserSet();
		Set<String> tempTimeSet = mcvo.getTimeSet();

		for (int i = 0; i < tempArr.length; i++) {

			int flag = i % 4;
			switch (flag) {
			case 0:
				tempCodeSet.add(tempArr[i]);
				break;
			case 1:
				if (tempArr[i].contains("key")) {
					tempUrlSet.add(tempArr[i].substring(tempArr[i].indexOf("key") + 4, tempArr[i].indexOf("&")));
				}
				break;
			case 2:
				tempBrowserSet.add(tempArr[i]);
				break;
			case 3:
				tempTimeSet.add(tempArr[i].substring(11, 13));
				break;
			}

		}

//		for (String string : mcvo.getCodeSet()) {
//			System.out.println(string);
//		}
//		for (String string : mcvo.getUrlSet()) {
//			System.out.println(string);
//		}
//		for (String string : mcvo.getBrowserSet()) {
//			System.out.println(string);
//		}
//		for (String string : mcvo.getTimeSet()) {
//			System.out.println(string);
//		}

	}// logToSet

	/**
	 * tempArr�� ����� String�� ���� Code, Url, Brower, Time���� ������ Set�� ����
	 */
	public void logToList() {
		List<String> tempCodeList = mcvo.getCodeList();
		List<String> tempUrlList = mcvo.getUrlList();
		List<String> tempBrowserList = mcvo.getBrowserList();
		List<String> tempTimeList = mcvo.getTimeList();
		// VO�� �� List�� �ּҸ� ����

		for (int i = 0; i < tempArr.length; i++) {

			int flag = i % 4;
			switch (flag) {
			case 0:
				tempCodeList.add(tempArr[i]);
				break;
			case 1:
				if (tempArr[i].contains("key")) {
					tempUrlList.add(tempArr[i].substring(tempArr[i].indexOf("key") + 4, tempArr[i].indexOf("&")));

				}
				break;
			case 2:
				tempBrowserList.add(tempArr[i]);
				break;
			case 3:
				tempTimeList.add(tempArr[i].substring(11, 13));
				break;
			}

		}

//		for (String string : mcvo.getCodeList()) {
//			System.out.println(string);
//		}
//		for (String string : mcvo.getUrlList()) {
//			System.out.println(string);
//		}
//		for (String string : mcvo.getBrowserList()) {
//			System.out.println(string);
//		}
//		for (String string : mcvo.getTimeList()) {
//			System.out.println(string);
//		}

	}// logToList

	/**
	 * ����� Set�� component�� key��, List���� key component�� ������ ī��Ʈ�ؼ� Map�� �ִ� method
	 */
	public void setMap() {
		Map<String, Integer> tempCodeMap = mcvo.getCodeMap();
		Map<String, Integer> tempUrlMap = mcvo.getUrlMap();
		Map<String, Integer> tempBrowserMap = mcvo.getBrowserMap();
		Map<String, Integer> tempTimeMap = mcvo.getTimeMap();
		// VO�� �� Map�� �ּҸ� ����

		Iterator<String> ita = mcvo.getCodeSet().iterator();
		while (ita.hasNext()) {// Set�� ��� component�� ���ؼ�
			String tempKey = ita.next();// key�� component�� ����
			int tempCount = 0;
			while (mcvo.getCodeList().remove(tempKey)) {// List���� key�� �����ϸ� ����� ī��Ʈ +1
				tempCount += 1;
			}
			tempCodeMap.put(tempKey, tempCount);// Map�� <key,count>�� �Է�
		}
		ita = mcvo.getUrlSet().iterator();
		while (ita.hasNext()) {
			String tempKey = ita.next();
			int tempCount = 0;
			while (mcvo.getUrlList().remove(tempKey)) {
				tempCount += 1;
			}
			tempUrlMap.put(tempKey, tempCount);
		}
		ita = mcvo.getBrowserSet().iterator();
		while (ita.hasNext()) {
			String tempKey = ita.next();
			int tempCount = 0;
			while (mcvo.getBrowserList().remove(tempKey)) {
				tempCount += 1;
			}
			tempBrowserMap.put(tempKey, tempCount);
		}
		ita = mcvo.getTimeSet().iterator();
		while (ita.hasNext()) {
			String tempKey = ita.next();
			int tempCount = 0;
			while (mcvo.getTimeList().remove(tempKey)) {
				tempCount += 1;
			}
			tempTimeMap.put(tempKey, tempCount);
		}
		
		/////////////////////////////////////////
		System.out.println(tempCodeMap);
		System.out.println(tempUrlMap);
		System.out.println(tempBrowserMap);
		System.out.println(tempTimeMap);
		////////////////////////////////////////
	}

	public static void main(String[] args) {
		try {
			String fileName = "C:\\dev\\workspace\\javase_prj2\\src\\group_project1\\sist_input1.txt";
			FileRead fr = new FileRead(fileName);

			fr.logToSet();
			fr.logToList();
			fr.setMap();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ������ �ʿ��� method : ���ϰ�� �޾ƿ��� method

	}

}

