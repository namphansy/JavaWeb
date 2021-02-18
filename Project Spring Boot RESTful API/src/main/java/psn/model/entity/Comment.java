package psn.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Comment")
public class Comment {
	@Id
	@Column(name = "Comment_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;
	@Column(name = "Created")
	private Date created;
	@Column(name = "Parent_Id")
	private int parentId;
	@Column(name = "Content")
	private String content;
	@Column(name = "Comment_Status")
	private boolean commentStatus;
	// Product
	@ManyToOne
	@JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
	private Products productsComment;
	//User
	@ManyToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	private WebUser webUserComment;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, Date created, int parentId, String content, boolean commentStatus,
			Products productsComment, WebUser webUserComment) {
		super();
		this.commentId = commentId;
		this.created = created;
		this.parentId = parentId;
		this.content = content;
		this.commentStatus = commentStatus;
		this.productsComment = productsComment;
		this.webUserComment = webUserComment;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(boolean commentStatus) {
		this.commentStatus = commentStatus;
	}

	public Products getProductsComment() {
		return productsComment;
	}

	public void setProductsComment(Products productsComment) {
		this.productsComment = productsComment;
	}

	public WebUser getWebUserComment() {
		return webUserComment;
	}

	public void setWebUserComment(WebUser webUserComment) {
		this.webUserComment = webUserComment;
	}
	
	
}
