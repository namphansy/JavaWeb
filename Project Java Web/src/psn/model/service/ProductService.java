package psn.model.service;

import java.util.List;

import psn.model.entity.Products;

public interface ProductService {
	public List<Products> getAll();
	public boolean save(Products pro);
	public boolean merge(Products pro);
	public boolean remove(String productId);
	public Products findById(String productId);
	public boolean updateStatus(Products products);
	public List<Products> getListProductByStatus(Boolean status);
	public Integer totalProdcutActive(Boolean status);
	public boolean checkProductId(String productId);
}
