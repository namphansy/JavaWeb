package psn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import psn.model.entity.Brand;
import psn.model.entity.Categories;
import psn.model.entity.Color;
import psn.model.entity.Material;
import psn.model.entity.Products;
import psn.model.entity.Size;
import psn.model.service.BrandService;
import psn.model.service.CategoriesService;
import psn.model.service.ColorService;
import psn.model.service.MaterialService;
import psn.model.service.ProductService;
import psn.model.service.SizeService;

@Controller
//@RequestMapping(value = "/adminProductController")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private SizeService sizeService;

	/*------- Lấy toàn bộ sản phẩm -----------*/
	@RequestMapping("/adminGetAllProduct.htm")
	private ModelAndView getAllProduct() {

		// Danh sách sản phẩm
		ModelAndView mav = new ModelAndView("listAllProduct");
		List<Products> listAllProduct = productService.getAll();
		mav.addObject("listProduct", listAllProduct);
		return mav;
	}

	@RequestMapping("/adminGetProductByStatus.htm")
	private ModelAndView getListProductByStatus(Boolean status) {
		ModelAndView mav = new ModelAndView("listAllProduct");
		List<Products> listProductByStatus = productService.getListProductByStatus(status);
		mav.addObject("listProduct", listProductByStatus);
		return mav;
	}


	@RequestMapping("/adminInitInsertProduct.htm")
	private ModelAndView initInsertProduct() {
		ModelAndView mav = new ModelAndView("saveNewProduct");

		Products newProducts = new Products();
		mav.addObject("newProduct", newProducts);

		List<Categories> listCat = categoriesService.getAll();
		mav.addObject("listCat", listCat);

		List<Brand> listBrand = brandService.getAll();
		mav.addObject("listBrand", listBrand);

		List<Material> listMaterials = materialService.listMaterial();
		mav.addObject("listMaterials", listMaterials);

		List<Size> listSizes = sizeService.listSizes();
		mav.addObject("listSizes", listSizes);

		List<Color> lisColors = colorService.listColor();
		mav.addObject("lisColors", lisColors);

		return mav;
	}

	@RequestMapping(value = "/insertProduct.htm", method = RequestMethod.POST)
	public String insertProduct(Products newProducts) {

		boolean check = productService.save(newProducts);
		if (check) {

			return "redirect:adminGetAllProduct.htm";
		} else {
			return "error";
		}
	}

	@RequestMapping("/adminInitUpdateProduct.htm")
	public ModelAndView initUpdateProduct(String productId) {
		ModelAndView mav = new ModelAndView("updateProduct");

		Products updateProduct = productService.findById(productId);
		mav.addObject("updateProduct", updateProduct);

		List<Categories> listCat = categoriesService.getAll();
		mav.addObject("listCat", listCat);

		List<Brand> listBrand = brandService.getAll();
		mav.addObject("listBrand", listBrand);

		List<Material> listMaterials = materialService.listMaterial();
		mav.addObject("listMaterials", listMaterials);

		return mav;
	}

	@RequestMapping(value = "/updateProduct.htm", method = RequestMethod.POST)
	public String updateProduct(Products updateProduct) {
		boolean check = productService.merge(updateProduct);
		if (check) {
			return "redirect:adminGetAllProduct.htm";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/updateStatusProduct.htm", method = RequestMethod.GET)
	private String updateStatusProduct(String productId) {
		Products updateProduct = productService.findById(productId);
		boolean check = productService.updateStatus(updateProduct);
		if (check == true) {
			return "redirect:adminGetAllProduct.htm";
		}
		return "error";
	}
	
	// Kiểm tra mã sản phẩm nhập vào
	@RequestMapping(value = "/checkProductId", method = RequestMethod.GET)
	private @ResponseBody String checkProductId(String productId) {
		boolean check = false;
		String result="";
		
		check = productService.checkProductId(productId);
		if(check == true) result = "true";
		else result = "false";
		
		return result;
	}
}
