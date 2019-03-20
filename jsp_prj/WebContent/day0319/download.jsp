<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1.응답 방식 설정
	response.setContentType("application/octet-stream");
	//2.응답 헤더 설정
	String data=request.getParameter("file_name");
	if(data==null||"".equals(data)){
		response.sendRedirect("file_list.jsp");		
		return;
	}//end if
	response.setHeader("Content-Disposition", "attachment;fileName="+URLEncoder.encode(data,"UTF-8"));
	
	//3.파일스트림 연결
	File file = new File("C:/dev/workspace/jsp_prj/WebContent/upload/"+data);
	FileInputStream fis = null;
	OutputStream os = null;
	
	if(file.exists()){//파일이 존재하는지
		try{
	fis = new FileInputStream(file);
	byte[] readFileArr = new byte[(int)file.length()]; //파일의 내용을 저장하기 위하나 배열
	
	int idx=0;
	int read=0;
	
	while((read=fis.read())!=-1){//읽어들인 내용이 있을 때 까지
		readFileArr[idx]=(byte)read;
		idx++;
	}//end while
	
		//출력 스트림을 초기화
		out.clear();
		out=pageContext.pushBody();
		
		os=response.getOutputStream();
		os.write(readFileArr);
		os.flush();
		}finally{
			if(fis!=null){fis.close();}//end if
			if(os!=null){os.close();}//end if
		}//end finally
	}//end if
%>