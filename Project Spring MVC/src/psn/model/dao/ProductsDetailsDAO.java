package psn.model.dao;

import java.util.List;

import psn.model.entity.ProductsDetails;

public interface ProductsDetailsDAO {
	public List<ProductsDetails> getAllProductDetails();
	public ProductsDetails findById(int productDetailsId);
	public boolean save(ProductsDetails productsDetails);
	public boolean merge(ProductsDetails productsDetails);
}
