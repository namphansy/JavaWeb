package psn.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Size")
public class Size {
	@Id
	@Column(name = "Size_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sizeId;
	@Column(name = "Size_Name")
	private String sizeName;
	@Column(name = "Descriptions")
	private String descriptions;
	@Column(name = "Size_Status")
	private boolean sizeStatus;
	@JsonIgnore
	@OneToMany(mappedBy = "sizeProduct")
	private List<ProductsDetails> listProductDetails;
	
	public Size() {
		// TODO Auto-generated constructor stub
	}

	public Size(int sizeId, String sizeName, String descriptions, boolean sizeStatus,
			List<ProductsDetails> listProductDetails) {
		super();
		this.sizeId = sizeId;
		this.sizeName = sizeName;
		this.descriptions = descriptions;
		this.sizeStatus = sizeStatus;
		this.listProductDetails = listProductDetails;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public boolean isSizeStatus() {
		return sizeStatus;
	}

	public void setSizeStatus(boolean sizeStatus) {
		this.sizeStatus = sizeStatus;
	}

	public List<ProductsDetails> getListProductDetails() {
		return listProductDetails;
	}

	public void setListProductDetails(List<ProductsDetails> listProductDetails) {
		this.listProductDetails = listProductDetails;
	}
	
	
}
