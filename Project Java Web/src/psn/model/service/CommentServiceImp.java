package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.CommentDAO;
import psn.model.entity.Comment;

@Service
public class CommentServiceImp implements CommentService{
	
	@Autowired
	private CommentDAO commentDao;
	
	@Override
	public List<Comment> listComment() {
		// TODO Auto-generated method stub
		return commentDao.listComment();
	}

	@Override
	public boolean remove(int commentId) {
		// TODO Auto-generated method stub
		return commentDao.remove(commentId);
	}

	@Override
	public boolean updateStatus(Comment comment) {
		// TODO Auto-generated method stub
		return commentDao.updateStatus(comment);
	}

	@Override
	public Comment findById(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
