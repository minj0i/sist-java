package day0107;

import java.sql.Date; /*util로 받으면 안됨!!*/

public class CpEmp2OneVO {
 private int sal;
 private String ename;
 private Date hiredate;
 
 public CpEmp2OneVO() {
 }

public CpEmp2OneVO(int sal, String ename, Date hiredate) {
	this.sal = sal;
	this.ename = ename;
	this.hiredate = hiredate;
}

public int getSal() {
	return sal;
}

public String getEname() {
	return ename;
}

public Date getHiredate() {
	return hiredate;
}
 

 
}//class
