package com.devanshu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devanshu.entity.Address;
import com.devanshu.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@GetMapping
	public List<Address> getAllAddresses() {
		return addressService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable Long id) {
		return addressService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Address createAddress(@RequestBody Address address) {
		return addressService.save(address);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
		addressService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}