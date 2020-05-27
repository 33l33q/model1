package bitcamp.java142.board.vo;

public class LdbHelloBoardVO {
	
	
	String lno;		
	String lsubject;
	String lname;
	String lpw;
	String lmemo;
	String ldeleteyn;
	String linsertdate;
	String lupdatedate;
	
	public LdbHelloBoardVO(){
		
	}
	
	
	public LdbHelloBoardVO( String lno, 
							String lsubject, 
							String lname, 
							String lpw, 
							String lmemo, 
							String ldeleteyn,
							String linsertdate, 
							String lupdatedate) {

		this.lno = lno;
		this.lsubject = lsubject;
		this.lname = lname;
		this.lpw = lpw;
		this.lmemo = lmemo;
		this.ldeleteyn = ldeleteyn;
		this.linsertdate = linsertdate;
		this.lupdatedate = lupdatedate;
	}//constructor Filed

	
	
	public String getLno() {
		return lno;
	}
	public void setLno(String lno) {
		this.lno = lno;
	}
	public String getLsubject() {
		return lsubject;
	}
	public void setLsubject(String lsubject) {
		this.lsubject = lsubject;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpw() {
		return lpw;
	}
	public void setLpw(String lpw) {
		this.lpw = lpw;
	}
	public String getLmemo() {
		return lmemo;
	}
	public void setLmemo(String lmemo) {
		this.lmemo = lmemo;
	}
	public String getLdeleteyn() {
		return ldeleteyn;
	}
	public void setLdeleteyn(String ldeleteyn) {
		this.ldeleteyn = ldeleteyn;
	}
	public String getLinsertdate() {
		return linsertdate;
	}
	public void setLinsertdate(String linsertdate) {
		this.linsertdate = linsertdate;
	}
	public String getLupdatedate() {
		return lupdatedate;
	}
	public void setLupdatedate(String lupdatedate) {
		this.lupdatedate = lupdatedate;
	}

	
	
}//end of class
