package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.ProductDAO;
import psn.model.entity.Products;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Products> getAll() {
		// TODO Auto-generated method stub
		return productDAO.getAll();
	}

	@Override
	public boolean save(Products pro) {
		// TODO Auto-generated method stub
		return productDAO.save(pro);
	}

	@Override
	public boolean merge(Products pro) {
		// TODO Auto-generated method stub
		return productDAO.merge(pro);
	}

	@Override
	public boolean remove(String productId) {
		// TODO Auto-generated method stub
		return productDAO.remove(productId);
	}

	@Override
	public Products findById(String productId) {
		// TODO Auto-generated method stub
		return productDAO.findById(productId);
	}

	@Override
	public boolean updateStatus(Products products) {
		// TODO Auto-generated method stub
		return productDAO.updateStatus(products);
	}

	@Override
	public List<Products> getListProductByStatus(Boolean status) {
		// TODO Auto-generated method stub
		return productDAO.getListProductByStatus(status);
	}

	@Override
	public Integer totalProdcutActive(Boolean status) {
		// TODO Auto-generated method stub
		return productDAO.totalProdcutActive(status);
	}

	@Override
	public boolean checkProductId(String productId) {
		// TODO Auto-generated method stub
		return productDAO.checkProductId(productId);
	}

}
