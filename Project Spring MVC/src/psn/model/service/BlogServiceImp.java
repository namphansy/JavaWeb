package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.BlogDAO;
import psn.model.entity.Blog;

@Service
public class BlogServiceImp implements BlogService{
	
	@Autowired
	private BlogDAO blogDao;
	
	@Override
	public List<Blog> listBlog() {
		// TODO Auto-generated method stub
		return blogDao.listBlog();
	}

	@Override
	public boolean save(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.save(blog);
	}

	@Override
	public boolean merge(Blog blog) {
		// TODO Auto-generated method stub
		return blogDao.merge(blog);
	}

	@Override
	public boolean remove(int blogId) {
		// TODO Auto-generated method stub
		return blogDao.remove(blogId);
	}

	@Override
	public Blog findById(int blogId) {
		// TODO Auto-generated method stub
		return blogDao.findById(blogId);
	}
	
}
