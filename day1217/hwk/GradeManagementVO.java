package day1217;

/**
 * ���� ���� �ý��� DVO<br>
 * @author owner
 */
public class GradeManagementVO {
	private String name; // �̸�
	private int javaScore; // �ڹ� ����
	private int oracleScore; // ����Ŭ ����
	private int sumScore; // ���κ� ����
	private double avgScore; // ���κ� ���
	
	public GradeManagementVO() {
		name = "";
		javaScore = 0;
		oracleScore = 0;
		sumScore = 0;
		avgScore = 0;
	} // GradeManagementVO
	
	public GradeManagementVO(String name, int javaScore, int oracleScore) {
		this.name = name;
		this.javaScore = javaScore;
		this.oracleScore = oracleScore;
		sumScore = 0;
		avgScore = 0;
	} // GradeManagementVO

	public String getName() {
		return name;
	} // getName

	public void setName(String name) {
		this.name = name;
	} // setName

	public int getJavaScore() {
		return javaScore;
	} // getJavaScore

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	} // setJavaScore

	public int getOracleScore() {
		return oracleScore;
	} // getOracleScore

	public void setOracleScore(int oracleScore) {
		this.oracleScore = oracleScore;
	} // setOracleScore

	public int getSumScore() {
		return sumScore;
	} // getSumScore

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	} // setSumScore

	public double getAvgScore() {
		return avgScore;
	} // getAvgScore

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	} // setAvgScore
	
} // class
