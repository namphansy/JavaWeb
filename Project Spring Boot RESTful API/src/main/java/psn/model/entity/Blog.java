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

@Entity
@Table(name = "Blog")
public class Blog {
	@Id
	@Column(name = "Blog_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogId;
	@Column(name = "Blog_Name")
	private String blogName;
	@Column(name = "Created")
	private Date created; 
	@Column(name = "Content")
	private String content;
	@Column(name = "Title")
	private String title;
	@Column(name = "Blog_Status")
	private boolean blogStatus;
	//User
	@ManyToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	private WebUser webUserBlog;
	
	public Blog() {
		// TODO Auto-generated constructor stub
	}

	public Blog(int blogId, String blogName, Date created, String content, String title, boolean blogStatus,
			WebUser webUserBlog) {
		super();
		this.blogId = blogId;
		this.blogName = blogName;
		this.created = created;
		this.content = content;
		this.title = title;
		this.blogStatus = blogStatus;
		this.webUserBlog = webUserBlog;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogName() {
		return blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isBlogStatus() {
		return blogStatus;
	}

	public void setBlogStatus(boolean blogStatus) {
		this.blogStatus = blogStatus;
	}

	public WebUser getWebUserBlog() {
		return webUserBlog;
	}

	public void setWebUserBlog(WebUser webUserBlog) {
		this.webUserBlog = webUserBlog;
	}
	
	
}
