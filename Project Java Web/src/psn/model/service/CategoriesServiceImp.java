package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.CategoriesDAO;
import psn.model.entity.Categories;

@Service
public class CategoriesServiceImp implements CategoriesService{
	
	@Autowired
	private CategoriesDAO categoriesDao;
	
	@Override
	public List<Categories> getAll() {
		
		return categoriesDao.getAll();
	}

	@Override
	public boolean save(Categories cat) {
		// TODO Auto-generated method stub
		return categoriesDao.save(cat);
	}

	@Override
	public boolean merge(Categories cat) {
		// TODO Auto-generated method stub
		return categoriesDao.merge(cat);
	}

	@Override
	public boolean remove(int catalogId) {
		// TODO Auto-generated method stub
		return categoriesDao.remove(catalogId);
	}

	@Override
	public Categories findById(int catalogId) {
		// TODO Auto-generated method stub
		return categoriesDao.findById(catalogId);
	}

	@Override
	public List<Categories> listUpdateParent(List<Categories> listCategories, int catalogId) {
		// TODO Auto-generated method stub
		return categoriesDao.listUpdateParent(listCategories, catalogId);
	}

}
