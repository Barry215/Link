package cn.SkyShadow.dto.execution;

/**
 * 执行结果
 */
public class BaseExecution {
	private boolean isSuccess;
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

	public BaseExecution(int resultNum, String resultInfo, Object obj) {
		super();
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
		this.obj = obj;
		// TODO: 9/19/2016 请撤销此方法 
	}

	public BaseExecution(int resultNum, String resultInfo) {
		super();
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
		// TODO: 9/19/2016 请撤销此方法
	}

	public BaseExecution(int resultNum) {
		this.resultNum = resultNum;
		this.resultInfo = "执行已经完成";
	}

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setResultNum(int resultNum) {
        this.resultNum = resultNum;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public BaseExecution(boolean isSuccess, int resultNum, String resultInfo, Object obj) {
        this.isSuccess = isSuccess;
        this.resultNum = resultNum;
        this.resultInfo = resultInfo;
        this.obj = obj;
    }
	public BaseExecution(boolean isSuccess, int resultNum, String resultInfo) {
		this.isSuccess = isSuccess;
		this.resultNum = resultNum;
		this.resultInfo = resultInfo;
	}
}
