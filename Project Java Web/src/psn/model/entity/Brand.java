package psn.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")
public class Brand {
	@Id
	@Column(name = "Brand_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int brandId;
	@Column(name = "Brand_Name")
	private String brandName;
	@Column(name = "Brand_Status")
	private boolean brandStatus;
	
	@OneToMany(mappedBy = "brandProduct")
	private List<Products> lisProducts;
	
	public Brand() {
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String brandName, boolean brandStatus, List<Products> lisProducts) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.brandStatus = brandStatus;
		this.lisProducts = lisProducts;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public boolean isBrandStatus() {
		return brandStatus;
	}

	public void setBrandStatus(boolean brandStatus) {
		this.brandStatus = brandStatus;
	}

	public List<Products> getLisProducts() {
		return lisProducts;
	}

	public void setLisProducts(List<Products> lisProducts) {
		this.lisProducts = lisProducts;
	}
	
}
