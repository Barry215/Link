package cn.SkyShadow.dto.excution;

/**
 * 执行结果
 */
public class Excution {
	private int resultNum;
	private String resultInfo;
	private Object obj;

    /**
     * 获取执行结果递交过来的实体类
     * @return 执行结果递交过来的实体类
     */
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	/**
	 * 获取返回值，低于等于0代表用户的输入有错误，高于零代表正常
	 * @return
	 */
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
