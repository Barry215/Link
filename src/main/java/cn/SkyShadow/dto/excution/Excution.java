package cn.SkyShadow.dto.excution;

public class Excution {
	private int resultNum;
	private String resultInfo;
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public int getResultNum() {
		return resultNum;
	}

	public void setResultNum(int resultNum) {
		this.resultNum = resultNum;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public void setResultInfo(String resultInfo) {
		this.resultInfo = resultInfo;
	}

	public Excution(int resultNum, String resultInfo, Object obj) {
		super();
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
		this.obj = obj;
	}

	public Excution(int resultNum, String resultInfo) {
		super();
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
	}

}
