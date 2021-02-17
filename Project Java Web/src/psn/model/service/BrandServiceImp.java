package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.BrandDAO;
import psn.model.entity.Brand;

@Service
public class BrandServiceImp implements BrandService{
	
	@Autowired
	private BrandDAO brandDao;
	
	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return brandDao.getAll();
	}

	@Override
	public boolean save(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.save(brand);
	}

	@Override
	public boolean marge(Brand brand) {
		// TODO Auto-generated method stub
		return brandDao.marge(brand);
	}

	@Override
	public boolean remove(int brandId) {
		// TODO Auto-generated method stub
		return brandDao.remove(brandId);
	}

	@Override
	public Brand findById(int brandId) {
		// TODO Auto-generated method stub
		return brandDao.findById(brandId);
	}

}
