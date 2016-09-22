package cn.SkyShadow.model;

public class Expr {
	private Long exprId;

	private Imagine imgId;

	private String isPublic;

	public Long getExprId() {
		return exprId;
	}

	public void setExprId(Long exprId) {
		this.exprId = exprId;
	}

	public Imagine getImgId() {
		return imgId;
	}

	public void setImgId(Imagine imgId) {
		this.imgId = imgId;
	}

	public String getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic == null ? null : isPublic.trim();
	}

	public Expr(Imagine imgId, String isPublic) {
		super();
		this.imgId = imgId;
		this.isPublic = isPublic;
	}

	public Expr() {
		super();
	}

	@Override
	public String toString() {
		return "Expr [exprId=" + exprId + ", imgId=" + imgId + ", isPublic="
				+ isPublic + "]";
	}

}