package psn.model.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
public class Products {
	@Id
	@Column(name = "Product_Id")
	private String productId;
	@Column(name = "Product_name")
	private String productName;
	@Column(name = "Price")
	private float price;
	@Column(name = "Title")
	private String title;
	@Column(name = "Descriptions")
	private String descriptions;
	@Column(name = "Created")
	private Date created;
	@Column(name = "Discount")
	private int discount;
	@Column(name = "Click_View")
	private int clickView;
	@Column(name = "Image_Link")
	private String imageLink;
	@Column(name = "Product_Status")
	private boolean productStatus;
	//Catalog
	@ManyToOne
	@JoinColumn(name = "Catalog_Id", referencedColumnName = "Catalog_Id")
	private Categories catalog;
	// Brand
	@ManyToOne
	@JoinColumn(name = "Brand_Id", referencedColumnName = "Brand_Id")
	private Brand brandProduct;
	//Material
	@ManyToOne
	@JoinColumn(name = "Material_Id", referencedColumnName = "Material_Id")
	private Material materialProduct;
	// Product_Details
	@OneToMany(mappedBy = "products")
	private List<ProductsDetails> listProductsDetails;
	// Comment
	@OneToMany(mappedBy = "productsComment")
	private List<Comment> listComment;
	// Evaluate
	@OneToMany(mappedBy = "productsEvaluate")
	private List<Evaluate> listEvaluate;
	// Favourite
	@OneToMany(mappedBy = "productsFavourite")
	private List<Favourite> listFavourite;
	// Orders
	@OneToMany(mappedBy = "webUserOrders")
	private List<Orders> listOrders;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public Products(String productId, String productName, float price, String title, String descriptions, Date created, int discount,
			int clickView, String imageLink, boolean productStatus, Categories catalog, Brand brandProduct,
			Material materialProduct, List<ProductsDetails> listProductsDetails, List<Comment> listComment,
			List<Evaluate> listEvaluate, List<Favourite> listFavourite, List<Orders> listOrders) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.title = title;
		this.descriptions = descriptions;
		this.created = created;
		this.discount = discount;
		this.clickView = clickView;
		this.imageLink = imageLink;
		this.productStatus = productStatus;
		this.catalog = catalog;
		this.brandProduct = brandProduct;
		this.materialProduct = materialProduct;
		this.listProductsDetails = listProductsDetails;
		this.listComment = listComment;
		this.listEvaluate = listEvaluate;
		this.listFavourite = listFavourite;
		this.listOrders = listOrders;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getClickView() {
		return clickView;
	}

	public void setClickView(int clickView) {
		this.clickView = clickView;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public boolean isProductStatus() {
		return productStatus;
	}

	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}

	public Categories getCatalog() {
		return catalog;
	}

	public void setCatalog(Categories catalog) {
		this.catalog = catalog;
	}

	public Brand getBrandProduct() {
		return brandProduct;
	}

	public void setBrandProduct(Brand brandProduct) {
		this.brandProduct = brandProduct;
	}

	public Material getMaterialProduct() {
		return materialProduct;
	}

	public void setMaterialProduct(Material materialProduct) {
		this.materialProduct = materialProduct;
	}

	public List<ProductsDetails> getListProductsDetails() {
		return listProductsDetails;
	}

	public void setListProductsDetails(List<ProductsDetails> listProductsDetails) {
		this.listProductsDetails = listProductsDetails;
	}

	public List<Comment> getListComment() {
		return listComment;
	}

	public void setListComment(List<Comment> listComment) {
		this.listComment = listComment;
	}

	public List<Evaluate> getListEvaluate() {
		return listEvaluate;
	}

	public void setListEvaluate(List<Evaluate> listEvaluate) {
		this.listEvaluate = listEvaluate;
	}

	public List<Favourite> getListFavourite() {
		return listFavourite;
	}

	public void setListFavourite(List<Favourite> listFavourite) {
		this.listFavourite = listFavourite;
	}

	public List<Orders> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Orders> listOrders) {
		this.listOrders = listOrders;
	}
	
	
}
