package connplantsv2.connplantsv2;

public class Login {

	private String site;
	private String ip;
	private String port;
	private String user;
	private String password;
	private String stringURL;
	

	
	public Login() {}
	
	
	public Login(String ip, String port, String user, String password) {
		super();
		this.ip = ip;
		this.port = port;
		this.user = user;
		this.password = password;
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

}
