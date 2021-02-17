package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.Brand;
import psn.model.service.BrandService;

@Controller
//@RequestMapping(value = "/brandController")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	/*------- Lấy toàn bộ thương hiệu -------*/
	@RequestMapping(value = "/adminGetAllBrand.htm")
	private ModelAndView getAllBrand() {
		ModelAndView mav = new ModelAndView("listAllBrand");
		List<Brand> listBrand = brandService.getAll();
		mav.addObject("listBrand", listBrand);
		return mav;
	}
	
	/*-------- Thêm thương hiệu ------------*/
	@RequestMapping(value = "/adminInitInsertBrand.htm")
	private ModelAndView initInsertBrand() {
		ModelAndView mav = new ModelAndView("saveNewBrand");
		Brand newBrand = new Brand();
		mav.addObject("newBrand", newBrand);
		return mav;
	}
	@RequestMapping(value = "/InsertBrand.htm", method = RequestMethod.POST)
	private String InsertBrand(Brand brand) {
		boolean check = brandService.save(brand);
		if(check == true) {
			return "redirect:adminGetAllBrand.htm";
		} else return "error";
	}
	
	/*-------- Cập nhật thương hiệu -----------*/
	@RequestMapping(value = "/adminInitUpdateBrand.htm")
	private ModelAndView initUpdateBrand(int brandId) {
		ModelAndView mav = new ModelAndView("updateBrand");
		Brand updateBrand = new Brand();
		updateBrand = brandService.findById(brandId);
		mav.addObject("updateBrand", updateBrand);
		return mav;
	}
	
	@RequestMapping(value = "/updateBrand.htm", method = RequestMethod.POST)
	private String updateBrand(Brand brand) {
		boolean check = brandService.marge(brand);
		if(check) {
			return "redirect:adminGetAllBrand.htm";
		}
		return "error";
	}
	
	/*------- Xóa thương hiệu -----------------*/
	@RequestMapping(value = "/removeBrand.htm", method = RequestMethod.POST)
	private String removeBrand(int brandId) {
		boolean check = brandService.remove(brandId);
		if(check) {
			return "redirect:adminGetAllBrand.htm";
		}
		return "error";
	}
}
