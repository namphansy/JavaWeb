package psn.model.dao;

import java.util.List;

import psn.model.entity.Blog;

public interface BlogDAO {
	public List<Blog> listBlog();
	public boolean save(Blog blog);
	public boolean merge(Blog blog);
	public boolean remove(int blogId);
	public Blog findById(int blogId);
}
