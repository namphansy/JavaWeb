package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.ProductsDetailsDAO;
import psn.model.entity.ProductsDetails;

@Service
public class ProductDetailsServiceImp implements ProductDetailsService {
	
	@Autowired
	private ProductsDetailsDAO productDetailsDao;
	
	@Override
	public boolean save(ProductsDetails productsDetails) {
		// TODO Auto-generated method stub
		return productDetailsDao.save(productsDetails);
	}

	@Override
	public boolean merge(ProductsDetails productsDetails) {
		// TODO Auto-generated method stub
		return productDetailsDao.merge(productsDetails);
	}

	@Override
	public List<ProductsDetails> getAllProductDetails() {
		// TODO Auto-generated method stub
		return productDetailsDao.getAllProductDetails();
	}

	@Override
	public ProductsDetails findById(int productDetailsId) {
		// TODO Auto-generated method stub
		return productDetailsDao.findById(productDetailsId);
	}

}
