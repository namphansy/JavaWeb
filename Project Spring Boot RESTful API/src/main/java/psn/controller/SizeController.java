package psn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psn.exception.ResourceNotFoundException;
import psn.model.dao.SizeDAO;
import psn.model.entity.Size;

@RestController
@RequestMapping("/size")
public class SizeController {
	
	@Autowired
	private SizeDAO sizeDAO;
	
	@RequestMapping("/findAll")
	private List<Size> getAll() {
		return sizeDAO.findAll();
	}
	
	@RequestMapping("/findById/{id}")
	private ResponseEntity<Optional<Size>> findById(@PathVariable(value = "id") int sizeId) throws ResourceNotFoundException {
		Optional<Size> size = sizeDAO.findById(sizeId);
		return ResponseEntity.ok().body(size);
	}
}
