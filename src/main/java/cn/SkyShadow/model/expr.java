package cn.SkyShadow.model;

public class expr {
	private Long exprId;

	private imagine imgId;

	private String ispublic;

	public Long getExprId() {
		return exprId;
	}

	public void setExprId(Long exprId) {
		this.exprId = exprId;
	}

	public imagine getImgId() {
		return imgId;
	}

	public void setImgId(imagine imgId) {
		this.imgId = imgId;
	}

	public String getIspublic() {
		return ispublic;
	}

	public void setIspublic(String ispublic) {
		this.ispublic = ispublic == null ? null : ispublic.trim();
	}

	public expr(imagine imgId, String ispublic) {
		super();
		this.imgId = imgId;
		this.ispublic = ispublic;
	}

	public expr() {
		super();
	}

	@Override
	public String toString() {
		return "expr [exprId=" + exprId + ", imgId=" + imgId + ", ispublic="
				+ ispublic + "]";
	}

}