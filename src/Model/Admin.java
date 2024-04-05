package Model;

import java.util.Map;

public abstract class Admin {
	private String adminId;
    private String name;
    private String username;
    private String password;
    
    public Admin() {
    }
    public Admin(String adminId, String name, String username, String password) {
        this.adminId = adminId;
        this.name = name;
        this.username = username;
        this.setPassword(password);
    }
    public String getAdminId() {
        return adminId;
    }
    

    public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setusername(String username) {
		this.username = username;
	}

	public abstract Map<String, String> key();


}
