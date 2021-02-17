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
@Table(name = "Categories")
public class Categories {
	@Id
	@Column(name = "Catalog_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catalogId;
	@Column(name = "Catalog_Name")
	private String catalogName;
	@Column(name = "Descriptions")
	private String descriptions;
	@Column(name = "Parent_Id")
	private int parentId;
	@Column(name = "Priorities")
	private int priorities;
	@Column(name = "Catalog_Status")
	private boolean catalogStatus;
	
	@OneToMany(mappedBy = "catalog")
	private List<Products> lisProducts;
	
	public Categories() {
		// TODO Auto-generated constructor stub
	}
	
	public Categories(int catalogId, String catalogName) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
	}

	public Categories(int catalogId, String catalogName, String descriptions, int parentId, int priorities,
			boolean catalogStatus, List<Products> lisProducts) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.parentId = parentId;
		this.priorities = priorities;
		this.catalogStatus = catalogStatus;
		this.lisProducts = lisProducts;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getPriorities() {
		return priorities;
	}

	public void setPriorities(int priorities) {
		this.priorities = priorities;
	}

	public boolean isCatalogStatus() {
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	public List<Products> getLisProducts() {
		return lisProducts;
	}

	public void setLisProducts(List<Products> lisProducts) {
		this.lisProducts = lisProducts;
	}
	
	
}
