package psn.model.service;

import java.util.List;

import psn.model.entity.Brand;

public interface BrandService {
	public List<Brand> getAll();
	public boolean save(Brand brand);
	public boolean marge(Brand brand);
	public boolean remove(int brandId);
	public Brand findById(int brandId);
}
