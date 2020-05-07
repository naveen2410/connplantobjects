package connplantsv2.connplantsv2;

public class Login {

	private String site;
	private String ip;
	private String port;
	private String user;
	private String password;
	private String stringURL;
	
	private String isorder;
	private String issfc;
	private String issite;
	private String isresource;
	private String isoperation;
	private String isrestimelog;
	
	public Login() {}
	
	
	public Login(String ip, String port, String user, String password, String isorder, String issfc, String issite, String isresource, String isoperation, String isrestimelog) {
		super();
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.password = password;
		
		this.isorder = isorder;
		this.issfc = issfc;
		this.issite = issite;
		this.isresource = isresource;
		this.isoperation = isoperation;
		this.isrestimelog = isrestimelog;
	}
	
	
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStringURL() {
		return stringURL;
	}

	public void setStringURL(String stringURL) {
		this.stringURL = stringURL;
	}


	public String getIsorder() {
		return isorder;
	}


	public void setIsorder(String isorder) {
		this.isorder = isorder;
	}


	public String getIssfc() {
		return issfc;
	}


	public void setIssfc(String issfc) {
		this.issfc = issfc;
	}


	public String getIssite() {
		return issite;
	}


	public void setIssite(String issite) {
		this.issite = issite;
	}


	public String getIsresource() {
		return isresource;
	}


	public void setIsresource(String isresource) {
		this.isresource = isresource;
	}


	public String getIsoperation() {
		return isoperation;
	}


	public void setIsoperation(String isoperation) {
		this.isoperation = isoperation;
	}


	public String getIsrestimelog() {
		return isrestimelog;
	}


	public void setIsrestimelog(String isrestimelog) {
		this.isrestimelog = isrestimelog;
	}

}
