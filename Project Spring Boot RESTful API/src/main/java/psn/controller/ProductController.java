package psn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import psn.exception.ResourceNotFoundException;
import psn.model.dao.ProductDAO;
import psn.model.dao.ProductDetailDAO;
import psn.model.dao.UserSpecification;
import psn.model.entity.Products;
import psn.model.entity.ProductsDetails;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO productService;
	@Autowired
	private ProductDetailDAO productDetailService;
	
	/*------- Hiển thị toàn bộ sản phẩm -----------------------------*/
	@GetMapping("/findAll")
	private List<Products> getAllProduct(){
		return productService.findAll();
	}
	
	/*----------- Hiển thị sản phẩm theo danh mục  -------------*/
	@GetMapping("/findByCatalog/{id}")
	private ResponseEntity<Map<String, Object>> findByCatalog(
			@PathVariable(value = "id") Integer catalogId,
			@RequestParam(name = "brand", required = false) String brand,
			@RequestParam(name = "material", required = false) String material,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "3") Integer size,
			@RequestParam(name = "sort", defaultValue = "productName") String sort) {
		
		Sort sortable = null;
		sortable = Sort.by(sort).ascending();
		List<Products> listProduct = new ArrayList<>();
		Pageable pageable = PageRequest.of(page - 1, size, sortable);
		Page<Products> pageProduct;
		
							// ---------- Lọc kết quả ------------//
		Specification<Products> condition = Specification.where(UserSpecification.catlogId(catalogId))
				.and(UserSpecification.brandName(brand))
				.and(UserSpecification.materialName(material));
		
		pageProduct = productService.findAll(condition, pageable);
		listProduct = pageProduct.getContent();
		
		Map<String, Object> response = new HashMap<>();
		 response.put("listProduct", listProduct);
	     response.put("currentPage", pageProduct.getNumber() + 1);
	     response.put("totalItems", pageProduct.getTotalElements());
	     response.put("totalPages", pageProduct.getTotalPages());
	    
	     return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	/*--------------- Tìm kiếm sản phẩm -------------------------*/
	@GetMapping("/search/{keyword}")
	private ResponseEntity<List<Products>> search(
			@PathVariable(value = "keyword") String keyword,
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", required = false, defaultValue = "2") Integer size,
			@RequestParam(name = "sort", defaultValue = "productName") String sort){
		
		Sort sortable = null;
		sortable = Sort.by(sort).ascending();
		
		Pageable pageable = PageRequest.of(page - 1, size, sortable);
		
		List<Products> listProductSearch = productService.search(keyword, pageable);
		
		return ResponseEntity.ok().body(listProductSearch);
	}
	
	/*------------ Xem chi tiết sản phẩm -------------------*/
	@GetMapping("/{id}")
	private ResponseEntity<Products> productDetails(@PathVariable(value = "id") String productId)
		throws ResourceNotFoundException {
		Products products = productService.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Not found Product with Id=" + productId));
		return ResponseEntity.ok().body(products);		
	}
	
	/*----------- Thêm sản phẩm chi tiết -----------------*/
	@PostMapping(value = "/createProductDetail")
	private ProductsDetails createProductDetail(@RequestBody ProductsDetails productsDetails) {
		return productDetailService.save(productsDetails);
	}	
}
