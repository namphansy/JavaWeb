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
@Table(name = "Products_Details")
public class ProductsDetails {
	@Id
	@Column(name = "Products_Details_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productsDetailsId;
	@Column(name = "Products_Details_Status")
	private boolean productsDetailsStatus;
	// Product
	@ManyToOne
	@JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
	private Products products;
	//Color
	@ManyToOne
	@JoinColumn(name = "Color_Id", referencedColumnName = "Color_Id")
	private Color colorProduct;
	//Size
	@ManyToOne
	@JoinColumn(name = "Size_Id", referencedColumnName = "Size_Id")
	private Size sizeProduct;
//	// OrderDetails
//	@OneToMany(mappedBy = "ProductDetailsOrderDetail")
//	private List<OrderDetail> listOrderDetail;
	
	public ProductsDetails() {
		// TODO Auto-generated constructor stub
	}
	public ProductsDetails(int productsDetailsId,  boolean productsDetailsStatus, Products products,
			Color colorProduct, Size sizeProduct) {
		super();
		this.productsDetailsId = productsDetailsId;
		this.productsDetailsStatus = productsDetailsStatus;
		this.products = products;
		this.colorProduct = colorProduct;
		this.sizeProduct = sizeProduct;
	}
	public int getProductsDetailsId() {
		return productsDetailsId;
	}
	public void setProductsDetailsId(int productsDetailsId) {
		this.productsDetailsId = productsDetailsId;
	}
	
	public boolean isProductsDetailsStatus() {
		return productsDetailsStatus;
	}
	public void setProductsDetailsStatus(boolean productsDetailsStatus) {
		this.productsDetailsStatus = productsDetailsStatus;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public Color getColorProduct() {
		return colorProduct;
	}
	public void setColorProduct(Color colorProduct) {
		this.colorProduct = colorProduct;
	}
	public Size getSizeProduct() {
		return sizeProduct;
	}
	public void setSizeProduct(Size sizeProduct) {
		this.sizeProduct = sizeProduct;
	}
	
	
}
