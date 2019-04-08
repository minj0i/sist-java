package kr.co.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//웹에대한 요청과 일반클래스에서 Parameter를 처리할 수 있음, 관계유지객체를 일반 클래스에서 사용할 수 있음, 파일 다운로드도 가능
	/**
	 * 요청, 응답, 처리, 관계유지(Session, Cookie)객체의 사용 등을 execute method내에서 처리 할 수 있게 됨
	 * Session - 접속자의 정보를 서버의 메모리에 저장 : 접속자가 어떤 브라우저를 쓰든 정보 저장이 가능
	 * Cookie - 접속자의 정보를 접속자의 하드 디스크에 저장
	 * @param request 웹 파라메터 요청처리
	 * @param response 응답처리
	 * @throws ServletException 
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * 처리한 결과를 보여줄 JSP명을 반환
	 * @return
	 */
	public String moveURL();
	/**
	 * 처리한 결과를 보여줄 JSP 또는 HTML로 이동하는 이동방식 선정
	 * @return
	 */
	public boolean isForward();
}//interface
