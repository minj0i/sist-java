package evt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainControlVO {
	private Set<String> codeSet, urlSet, browserSet, timeSet;
	private List<String> codeList, urlList, browserList, timeList;
	private Map<String, Integer> codeMap, urlMap, browserMap, timeMap;
	
	public MainControlVO() {
		
		codeSet = new HashSet<String>();
		urlSet = new HashSet<String>();
		browserSet = new HashSet<String>();
		timeSet = new HashSet<String>();
		
		codeList = new ArrayList<String>();
		urlList = new ArrayList<String>();
		browserList = new ArrayList<String>();
		timeList = new ArrayList<String>();
		
		codeMap = new HashMap<String, Integer>();
		urlMap = new HashMap<String, Integer>();
		browserMap = new HashMap<String, Integer>();
		timeMap = new HashMap<String, Integer>();
		
	}

	public Set<String> getCodeSet() {
		return codeSet;
	}

	public Set<String> getUrlSet() {
		return urlSet;
	}

	public Set<String> getBrowserSet() {
		return browserSet;
	}

	public Set<String> getTimeSet() {
		return timeSet;
	}

	public List<String> getCodeList() {
		return codeList;
	}

	public List<String> getUrlList() {
		return urlList;
	}

	public List<String> getBrowserList() {
		return browserList;
	}

	public List<String> getTimeList() {
		return timeList;
	}

	public Map<String, Integer> getCodeMap() {
		return codeMap;
	}

	public Map<String, Integer> getUrlMap() {
		return urlMap;
	}

	public Map<String, Integer> getBrowserMap() {
		return browserMap;
	}

	public Map<String, Integer> getTimeMap() {
		return timeMap;
	}
	
	
}
