package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psn.model.dao.BrandDAO;
import psn.model.entity.Brand;
@EnableWebSecurity
@RestController
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandDAO brandService;
	
	@GetMapping("/findAll")
	private List<Brand> listBrand(){
		return brandService.findAll();
	}
}
