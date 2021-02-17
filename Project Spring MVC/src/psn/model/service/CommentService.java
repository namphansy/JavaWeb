package psn.model.service;

import java.util.List;

import psn.model.entity.Comment;

public interface CommentService {
	public List<Comment> listComment();
	public boolean remove(int commentId);
	public boolean updateStatus(Comment comment);
	public Comment findById(int commentId);
}
