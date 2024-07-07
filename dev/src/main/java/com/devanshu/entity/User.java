package com.devanshu.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private Set<Address> addresses = new HashSet();

	    // Constructors, getters, and setters

	    public User() {
	    }

	    public User(String name) {
	        this.name = name;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Set<Address> getAddresses() {
	        return addresses;
	    }

	    public void setAddresses(Set<Address> addresses) {
	        this.addresses = addresses;
	    }

	    public void addAddress(Address address) {
	        addresses.add(address);
	        address.setUser(this);
	    }

	    public void removeAddress(Address address) {
	        addresses.remove(address);
	        address.setUser(null);
	    }

    
	
}
