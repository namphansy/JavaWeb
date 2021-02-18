package psn.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;


@Entity
@Table(name = "Web_User", uniqueConstraints = {@UniqueConstraint(columnNames = "User_Name")})
public class WebUser {
	@Id
	@Column(name = "User_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull
	@Column(name = "User_Name")
	private String userName;
	@Column(name = "Pass")
	private String password;
	@JsonIgnore
	@Column(name = "User_Status")
	private int userStatus;
	@Column(name = "User_Enabled")
	private boolean userEnabled;
	
	/*
	// Evaluate
	@OneToMany(mappedBy = "webUserEvaluate", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Evaluate> listEvaluate;
	// Comment
	@OneToMany( mappedBy = "productsComment", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Comment> listComment;
	// Favourite
	@OneToMany(mappedBy = "webUserFavourite", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Favourite> listFavourite;
	// Orders
	@OneToMany(mappedBy = "webUserOrders", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Orders> listOrders;
	// Blog
	@OneToMany(mappedBy = "webUserBlog", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Blog> listBlog;
	*/
	// Nhóm phân quyền
	@OneToMany(mappedBy = "webUser", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<UserGroup> listUserGroup = new ArrayList<UserGroup>();

	public WebUser() {
		// TODO Auto-generated constructor stub
	}

	public WebUser(int userId, String username, String password, int userStatus, List<Comment> listComment,
			List<Evaluate> listEvaluate, List<Favourite> listFavourite, List<Orders> listOrders, List<Blog> listBlog, 
			List<UserGroup> listUserGroup, boolean userEnabled) {
		super();
		this.userId = userId;
		this.userName = username;
		this.password = password;
		this.userStatus = userStatus;
//		this.listComment = listComment;
//		this.listEvaluate = listEvaluate;
//		this.listFavourite = listFavourite;
//		this.listOrders = listOrders;
//		this.listBlog = listBlog;
		this.listUserGroup = listUserGroup;
		this.userEnabled = userEnabled;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

//	public List<Comment> getListComment() {
//		return listComment;
//	}
//
//	public void setListComment(List<Comment> listComment) {
//		this.listComment = listComment;
//	}
//
//	public List<Evaluate> getListEvaluate() {
//		return listEvaluate;
//	}
//
//	public void setListEvaluate(List<Evaluate> listEvaluate) {
//		this.listEvaluate = listEvaluate;
//	}
//
//	public List<Favourite> getListFavourite() {
//		return listFavourite;
//	}
//
//	public void setListFavourite(List<Favourite> listFavourite) {
//		this.listFavourite = listFavourite;
//	}
//
//	public List<Orders> getListOrders() {
//		return listOrders;
//	}
//
//	public void setListOrders(List<Orders> listOrders) {
//		this.listOrders = listOrders;
//	}
//
//	public List<Blog> getListBlog() {
//		return listBlog;
//	}
//
//	public void setListBlog(List<Blog> listBlog) {
//		this.listBlog = listBlog;
//	}
	public List<UserGroup> getListUserGroup() {
		return listUserGroup;
	}
	public void setListUserGroup(List<UserGroup> listUserGroup) {
		this.listUserGroup = listUserGroup;
	}
	public boolean isUserEnabled() {
		return userEnabled;
	}
	public void setUserEnabled(boolean userEnabled) {
		this.userEnabled = userEnabled;
	}
	
//	@Transient
//	@JsonIgnore
//	public List<GrantedAuthority> getAuthorities(){
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		for (UserGroup userGroup : this.listUserGroup) {
//			authorities.add(new SimpleGrantedAuthority(userGroup.getWebGroup().getGroupName()));
//		}
//		return authorities;
//	}	
	
	
}
