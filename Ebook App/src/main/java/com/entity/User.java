package com.entity;

public class User {
	
	private int id;
    private String name;
    private String email;
    private String phno;
    private String password;
    private String address;
    private String landmark;
    private String city;
    private String state;
    private String pincode;
    

    // Getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    } 

    public String getPhno() {
        return phno;
    }

    public String getPassword() {
        return password;
    }
    
    public String getAddress() {
    	return address;
    }
    
    public String getLandmark() {
    	return landmark;
    }
    
    public String getCity() {
    	return city;
    }
    
    public String getState() {
    	return state;
    }
    
    public String getPincode() {
    	return pincode;
    }

    // Setters
    public void setId(int int1) {
        this.id = int1;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public void setPassword(String password) {
        this.password = password;
        
    }
    
    public void setAddress(String address) {
    	this.address = address;
    }
	
	public void setLandmark(String string) {
		this.landmark = landmark;
	}

	public void setCity(String string) {
		this.city = city;
	}

	public void setState(String string) {
		this.state = state;
	}

	public void setPincode(String string) {
		this.pincode = pincode;	
	}
	
}
