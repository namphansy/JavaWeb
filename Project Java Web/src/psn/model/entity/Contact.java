package psn.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Contact_Id")
	private int contactId;
	@Column(name = "Name_Company")
	private String nameCompany;
	@Column(name = "Phone")
	private int phone;
	@Column(name = "Shop_Address")
	private String shopAddress;
	@Column(name = "Mail")
	private String mail;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String nameCompany, int phone, String shopAddress, String mail) {
		super();
		this.nameCompany = nameCompany;
		this.phone = phone;
		this.shopAddress = shopAddress;
		this.mail = mail;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
