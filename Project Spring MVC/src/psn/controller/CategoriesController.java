package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.exception.ResourceNotFoundException;
import psn.model.entity.Categories;
import psn.model.service.CategoriesService;

@Controller
//@RequestMapping(value = "/categoriesController")
public class CategoriesController {
	
	@Autowired
	private CategoriesService categoriesService;
	
	/*------- Lấy toàn bộ danh mục -------------*/
	@RequestMapping(value = "/adminGetAllCategories.htm")
	private ModelAndView getAllCategories() {
		ModelAndView mav = new ModelAndView("listAllCategories");
		List<Categories> listAllCategories = categoriesService.getAll();
		mav.addObject("listCategories", listAllCategories);
		return mav;
	}
	
	/*----------Thêm danh mục mới ----------*/
	@RequestMapping(value = "/adminInitInsertCategories.htm")
	private ModelAndView initInsertCategories() {
		ModelAndView mav = new ModelAndView("saveNewCategories");
		// Tạo đối tượng mới
		Categories saveCategories = new Categories();
		mav.addObject("saveCategories", saveCategories);
		// Thêm danh sách danh mục cha
		List<Categories> listCate = categoriesService.getAll();
		mav.addObject("listCate", listCate);
		// Trả về giao diện
		return mav;
	}
	
	@RequestMapping(value = "/insertCategories.htm", method = RequestMethod.POST)
	private String insertCategories(Categories categories) {
		boolean check = categoriesService.save(categories);
		if(check == true) {
			return "redirect:adminGetAllCategories.htm";
		} else return "error";
	}
	
	/*------- Cập nhật danh mục ---------------*/
	@RequestMapping(value = "/adminInitUpdateCategories.htm")
	private ModelAndView initUpdateCategories(int catalogId) throws ResourceNotFoundException{
		ModelAndView mav = new ModelAndView("updateCategories");
		// Lấy thông tin danh mục cần cập nhật
		Categories updateCategories = categoriesService.findById(catalogId);
		if(updateCategories == null) throw new ResourceNotFoundException("Không nhận diện được mã danh mục");
		mav.addObject("updateCategories", updateCategories);
		// Lấy danh mục cha
		List<Categories> listCategories = categoriesService.getAll();
		List<Categories> listUpdateParent = categoriesService.listUpdateParent(listCategories, catalogId);
		mav.addObject("listUpdateParent", listUpdateParent);
		return mav;
	}
	
	@RequestMapping(value = "/updateCategories.htm", method = RequestMethod.POST)
	private String updateCategories(Categories categories) {
		boolean check = categoriesService.merge(categories);
		if(check) {
			return "redirect:adminGetAllCategories.htm";
		}
		return "error";
	}

}
