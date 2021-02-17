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
@Table(name = "Color")
public class Color {
	@Id
	@Column(name = "Color_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int colorId;
	@Column(name = "Color_Name")
	private String colorName;
	@Column(name = "Descriptions")
	private String descriptions;
	@OneToMany(mappedBy = "colorProduct")
	private List<ProductsDetails> listProductDetails;

	public Color() {
		// TODO Auto-generated constructor stub
	}

	public Color(int colorId, String colorName, String descriptions, List<ProductsDetails> listProductDetails) {
		super();
		this.colorId = colorId;
		this.colorName = colorName;
		this.descriptions = descriptions;
		this.listProductDetails = listProductDetails;
	}

	public int getColorId() {
		return colorId;
	}

	public void setColorId(int colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public List<ProductsDetails> getListProductDetails() {
		return listProductDetails;
	}

	public void setListProductDetails(List<ProductsDetails> listProductDetails) {
		this.listProductDetails = listProductDetails;
	}
	
	
}
