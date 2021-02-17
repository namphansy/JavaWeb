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
@Table(name = "Material")
public class Material {
	@Id
	@Column(name = "Material_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int materialId;
	@Column(name = "Material_Name")
	private String materialName;
	@Column(name = "Descriptions")
	private String descriptions;
	@Column(name = "Material_Status")
	private boolean materialStatus;
	@OneToMany(mappedBy = "materialProduct")
	private List<Products> lisProducts;
	
	public Material() {
		// TODO Auto-generated constructor stub
	}

	public Material(int materialId, String materialName, String descriptions, boolean materialStatus,
			List<Products> lisProducts) {
		super();
		this.materialId = materialId;
		this.materialName = materialName;
		this.descriptions = descriptions;
		this.materialStatus = materialStatus;
		this.lisProducts = lisProducts;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public boolean isMaterialStatus() {
		return materialStatus;
	}

	public void setMaterialStatus(boolean materialStatus) {
		this.materialStatus = materialStatus;
	}

	public List<Products> getLisProducts() {
		return lisProducts;
	}

	public void setLisProducts(List<Products> lisProducts) {
		this.lisProducts = lisProducts;
	}
	
	 
}
