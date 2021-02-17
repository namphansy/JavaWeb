package psn.model.dao;

import java.util.List;

import psn.model.entity.Brand;

public interface BrandDAO {
	public List<Brand> getAll();
	public boolean save(Brand brand);
	public boolean marge(Brand brand);
	public boolean remove(int brandId);
	public Brand findById(int brandId);
}
