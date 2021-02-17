package psn.model.service;

import java.util.List;

import psn.model.entity.Categories;

public interface CategoriesService {
	public List<Categories> getAll();
	public boolean save(Categories cat);
	public boolean merge(Categories cat);
	public boolean remove(int catalogId);
	public Categories findById(int catalogId);
	public List<Categories> listUpdateParent(List<Categories> listCategories, int catalogId);
}
