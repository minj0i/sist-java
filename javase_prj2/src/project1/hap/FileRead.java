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
	 * file주소를 String으로 받아서 tempArr에 split하여 저장
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
				while ((temp = br.readLine()) != null) {// 줄단위(\n)로 읽어서 읽어들인 내용이 있다면
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
				} // 반드시 연결을 종료
			}
		} else {
			System.out.println("경로나 파일명을 확인하세요.");
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
				int count = 0;//줄수를 세기 위한 변수
				while ((temp = br.readLine()) != null) {// 줄단위(\n)로 읽어서 읽어들인 내용이 있다면
					count += 1;
					if (count<selectedLine[0]) {//줄수가 입력된 시작 줄수보다 작다면
						//저장하지 않고 값을 버린다.
					}else {//줄수가 입력된 시작 줄수보다 크다면
						tempLog += temp;//저장한다
					}
					if (count == selectedLine[1]) {//줄수가 입력된 마지막 줄수와 같다면
						break; //while문을 나간다.
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
				} // 반드시 연결을 종료
			}
		} else {
			System.out.println("경로나 파일명을 확인하세요.");
		}
	}// FileRead

	/**
	 * tempArr에 저장된 String을 각각 Code, Url, Brower, Time으로 나누어 Set에 저장
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
	 * tempArr에 저장된 String을 각각 Code, Url, Brower, Time으로 나누어 Set에 저장
	 */
	public void logToList() {
		List<String> tempCodeList = mcvo.getCodeList();
		List<String> tempUrlList = mcvo.getUrlList();
		List<String> tempBrowserList = mcvo.getBrowserList();
		List<String> tempTimeList = mcvo.getTimeList();
		// VO의 각 List의 주소를 저장

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
	 * 저장된 Set의 component를 key로, List에서 key component의 갯수를 카운트해서 Map에 넣는 method
	 */
	public void setMap() {
		Map<String, Integer> tempCodeMap = mcvo.getCodeMap();
		Map<String, Integer> tempUrlMap = mcvo.getUrlMap();
		Map<String, Integer> tempBrowserMap = mcvo.getBrowserMap();
		Map<String, Integer> tempTimeMap = mcvo.getTimeMap();
		// VO의 각 Map의 주소를 저장

		Iterator<String> ita = mcvo.getCodeSet().iterator();
		while (ita.hasNext()) {// Set의 모든 component에 대해서
			String tempKey = ita.next();// key에 component를 지정
			int tempCount = 0;
			while (mcvo.getCodeList().remove(tempKey)) {// List에서 key가 존재하면 지우고 카운트 +1
				tempCount += 1;
			}
			tempCodeMap.put(tempKey, tempCount);// Map에 <key,count>를 입력
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

		// 앞으로 필요한 method : 파일경로 받아오는 method

	}

}

