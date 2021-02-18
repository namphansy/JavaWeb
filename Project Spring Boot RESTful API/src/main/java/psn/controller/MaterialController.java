package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psn.model.dao.MaterialDAO;
import psn.model.entity.Material;
@EnableWebSecurity
@RestController
@RequestMapping("/material")
public class MaterialController {
	
	@Autowired
	private MaterialDAO materialService;
	
	@GetMapping("/findAll")
	private List<Material> listMaterial(){
		return materialService.findAll();
	}
}
