package psn.model.service;

import java.util.List;

import psn.model.entity.ProductsDetails;

public interface ProductDetailsService {
	public List<ProductsDetails> getAllProductDetails();
	public ProductsDetails findById(int productDetailsId);
	public boolean save(ProductsDetails productsDetails);
	public boolean merge(ProductsDetails productsDetails);
}
