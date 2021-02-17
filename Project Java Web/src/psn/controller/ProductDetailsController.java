package psn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.Products;
import psn.model.entity.ProductsDetails;
import psn.model.entity.Size;
import psn.model.service.ProductDetailsService;
import psn.model.service.ProductService;
import psn.model.service.SizeService;

@Controller
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SizeService sizeService;
	
	@RequestMapping("/adminGetAllProductDetails")
	private ModelAndView getAll() {
		ModelAndView mav = new ModelAndView("listAllProductDetails");
		List<ProductsDetails> listAllProductDetails = productDetailsService.getAllProductDetails();
		mav.addObject("listProductDetails", listAllProductDetails);
		return mav;
	}
	
	@RequestMapping("/adminInitInsertProductDetails")
	private ModelAndView initInsert() {
		ModelAndView mav = new ModelAndView("saveNewProductDetails");
		
		ProductsDetails productDetails = new ProductsDetails();
		mav.addObject("productDetails", productDetails);
		
		List<Products> listProduct = productService.getListProductByStatus(true);
		mav.addObject("listProduct", listProduct);
		
		List<Size> listSize = sizeService.listSizes();
		mav.addObject("listSize", listSize);
		
		return mav;
	}
	
	@RequestMapping(value = "/insertProductDetails.htm", method = RequestMethod.POST)
	private String insert(ProductsDetails productsDetails) {
		boolean check = productDetailsService.save(productsDetails);
		if(check) {
			return "redirect:adminGetAllProductDetails";
		} else
		return "error";
	}
	
	@RequestMapping(value = "/adminInitUpdateProductDetails")
	private ModelAndView initUpdate(int productDetailsId) {
		ModelAndView mav = new ModelAndView("updateProductDetails");
		
		ProductsDetails productDetailsUpdate = productDetailsService.findById(productDetailsId);
		mav.addObject("productDetails", productDetailsUpdate);
		
		List<Products> listProduct = productService.getListProductByStatus(true);
		mav.addObject("listProduct", listProduct);
		
		List<Size> listSize = sizeService.listSizes();
		mav.addObject("listSize", listSize);
		
		return mav;
	}
	
	@RequestMapping(value = "/updateProductDetails", method = RequestMethod.POST)
	private String update(ProductsDetails productsDetails) {
		
		boolean check = productDetailsService.merge(productsDetails);
		if (check == true) {
			return "redirect:adminGetAllProductDetails";
		}
		return "error";
	}
}
