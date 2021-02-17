package psn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Favourite")
public class Favourite {
	@Id
	@Column(name = "Favourite_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favouriteId;
	// Product
	@ManyToOne
	@JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
	private Products productsFavourite;
	//User
	@ManyToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	private WebUser webUserFavourite;
	
	public Favourite() {
		// TODO Auto-generated constructor stub
	}

	public Favourite(int favouriteId, Products productsFavourite, WebUser webUserFavourite) {
		super();
		this.favouriteId = favouriteId;
		this.productsFavourite = productsFavourite;
		this.webUserFavourite = webUserFavourite;
	}

	public int getFavouriteId() {
		return favouriteId;
	}

	public void setFavouriteId(int favouriteId) {
		this.favouriteId = favouriteId;
	}

	public Products getProductsFavourite() {
		return productsFavourite;
	}

	public void setProductsFavourite(Products productsFavourite) {
		this.productsFavourite = productsFavourite;
	}

	public WebUser getWebUserFavourite() {
		return webUserFavourite;
	}

	public void setWebUserFavourite(WebUser webUserFavourite) {
		this.webUserFavourite = webUserFavourite;
	}
	
	
}
