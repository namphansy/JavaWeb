package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psn.model.dao.CategoriesDAO;
import psn.model.entity.Categories;
@EnableWebSecurity
@RestController
@RequestMapping("/categories")
public class CategoriesController {
	
	@Autowired
	private CategoriesDAO categorieService;
	
	@RequestMapping("/findAll")
	private List<Categories> getAllCategories(){
		return categorieService.findAll();
	}
}
