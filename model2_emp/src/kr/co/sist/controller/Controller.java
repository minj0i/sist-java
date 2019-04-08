package kr.co.sist.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//�������� ��û�� �Ϲ�Ŭ�������� Parameter�� ó���� �� ����, ����������ü�� �Ϲ� Ŭ�������� ����� �� ����, ���� �ٿ�ε嵵 ����
	/**
	 * ��û, ����, ó��, ��������(Session, Cookie)��ü�� ��� ���� execute method������ ó�� �� �� �ְ� ��
	 * Session - �������� ������ ������ �޸𸮿� ���� : �����ڰ� � �������� ���� ���� ������ ����
	 * Cookie - �������� ������ �������� �ϵ� ��ũ�� ����
	 * @param request �� �Ķ���� ��ûó��
	 * @param response ����ó��
	 * @throws ServletException 
	 * @throws IOException
	 */
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	/**
	 * ó���� ����� ������ JSP���� ��ȯ
	 * @return
	 */
	public String moveURL();
	/**
	 * ó���� ����� ������ JSP �Ǵ� HTML�� �̵��ϴ� �̵���� ����
	 * @return
	 */
	public boolean isForward();
}//interface
