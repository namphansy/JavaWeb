package psn.model.dao;

import java.util.List;

import psn.model.entity.Comment;

public interface CommentDAO {
	public List<Comment> listComment();
	public boolean remove(int commentId);
	public boolean updateStatus(Comment comment);
	public Comment findById(int commentId);
}
