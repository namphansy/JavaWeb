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
@Table(name = "Evaluate")
public class Evaluate {
	@Id
	@Column(name = "Evaluate_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int evaluteId;
	@Column(name = "Evaluate_Mark")
	private int evaluateMark;
	// Product
	@ManyToOne
	@JoinColumn(name = "Product_Id", referencedColumnName = "Product_Id")
	private Products productsEvaluate;
	//User
	@ManyToOne
	@JoinColumn(name = "User_Id", referencedColumnName = "User_Id")
	private WebUser webUserEvaluate;

	public Evaluate() {
		// TODO Auto-generated constructor stub
	}

	public Evaluate(int evaluteId, int evaluateMark, Products productsEvaluate, WebUser webUserEvaluate) {
		super();
		this.evaluteId = evaluteId;
		this.evaluateMark = evaluateMark;
		this.productsEvaluate = productsEvaluate;
		this.webUserEvaluate = webUserEvaluate;
	}

	public int getEvaluteId() {
		return evaluteId;
	}

	public void setEvaluteId(int evaluteId) {
		this.evaluteId = evaluteId;
	}

	public int getEvaluateMark() {
		return evaluateMark;
	}

	public void setEvaluateMark(int evaluateMark) {
		this.evaluateMark = evaluateMark;
	}

	public Products getProductsEvaluate() {
		return productsEvaluate;
	}

	public void setProductsEvaluate(Products productsEvaluate) {
		this.productsEvaluate = productsEvaluate;
	}

	public WebUser getWebUserEvaluate() {
		return webUserEvaluate;
	}

	public void setWebUserEvaluate(WebUser webUserEvaluate) {
		this.webUserEvaluate = webUserEvaluate;
	}
	
	
}
