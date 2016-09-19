package cn.SkyShadow.dto.execution;

/**
 * 执行结果
 */
public class Execution {
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
	public int getResultNum() {
		return resultNum;
	}

	public String getResultInfo() {
		return resultInfo;
	}

	public Execution(int resultNum, String resultInfo, Object obj) {
		super();
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
		this.obj = obj;
	}

	public Execution(int resultNum, String resultInfo) {
		super();
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
	}

	public Execution(int resultNum) {
		this.resultNum = resultNum;
		this.resultInfo = "执行已经完成";
	}
}
