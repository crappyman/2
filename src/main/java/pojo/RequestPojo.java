package pojo;

public class RequestPojo {

	private int reqId;
	private int ep;
	private String reqType;
	private int reqAmount;
	private String submitDate;
	private String approveDate;
	private int manager;
	private String reqStatus;
	private int intReqtype;
	

	public int getIntReqtype() {
		return intReqtype;
	}

	public void setIntReqtype(int intReqtype) {
		this.intReqtype = intReqtype;
	}

	public RequestPojo(int reqId, int ep, String reqType, int reqAmount, String submitDate, String approveDate,
			String reqStatus) {
		super();
		this.reqId = reqId;
		this.ep = ep;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.submitDate = submitDate;
		this.approveDate = approveDate;
		this.reqStatus = reqStatus;
	}

	public RequestPojo(int reqId, int ep, int intReqtype, int reqAmount, String submitDate, String approveDate,
			int manager, String reqStatus) {
		super();
		this.reqId = reqId;
		this.ep = ep;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.submitDate = submitDate;
		this.approveDate = approveDate;
		this.manager = manager;
		this.reqStatus = reqStatus;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getEp() {
		return ep;
	}

	public void setEp(int ep) {
		this.ep = ep;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public int getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(int reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public String getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}

	@Override
	public String toString() {
		return "RequestPojo [reqId=" + reqId + ", ep=" + ep + ", reqType=" + reqType + ", reqAmount=" + reqAmount
				+ ", submitDate=" + submitDate + ", approveDate=" + approveDate + ", manager=" + manager
				+ ", reqStatus=" + reqStatus + "]";
	}
}
