package netz;


public class User {

	String username;
	int passwort;
	String ip;
	String rechte;
	int port;
	boolean loggedIn;
	
	
	public User(String username, int passwort) {
		super();
		this.username = username;
		this.passwort = passwort;
		this.ip = null;
		this.rechte = null;
		this.port = -1;
		this.loggedIn = false;
	}

	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", passwort=" + passwort + ", ip=" + ip + ", rechte=" + rechte + ", port="
				+ port + ", loggedIn=" + loggedIn + "]";
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPasswort() {
		return passwort;
	}

	public void setPasswort(int passwort) {
		this.passwort = passwort;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRechte() {
		return rechte;
	}

	public void setRechte(String rechte) {
		this.rechte = rechte;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	
}
