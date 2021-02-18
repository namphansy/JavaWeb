
package bkap.entity;

import java.io.Serializable;
import java.util.Scanner;
import bkap.itf.ICategories;

public class Categories implements ICategories, Serializable {
	
	private static final long serialVersionUID = 1L;
	private int catalogId;
	private String catalogName;
	private String descriptions;
	private boolean catalogStatus;
	private int parentId;
	
	public Categories() {
		// TODO Auto-generated constructor stub
	}

	public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus, int parentId) {
		super();
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.catalogStatus = catalogStatus;
		this.parentId = parentId;
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

	public boolean isCatalogStatus() {
		return catalogStatus;
	}

	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public void inputData(Scanner sc) {
		System.out.print("Nhập tên danh mục: "); this.catalogName = inputCatalogName(sc);
		System.out.print("Nhập mô tả danh mục: "); this.descriptions = inputdescription(sc);
		System.out.print("Nhập trạng thái danh mục: "); this.catalogStatus = inputStatus(sc);
	}

	@Override
	public void displayData() {
		System.out.printf("Mã danh mục: %d - Tên danh mục: %s", this.catalogId, this.catalogName);
		System.out.printf("\nMô tả danh mục: %s - Trạng thái danh mục: %s", this.descriptions, displayStatus());
		System.out.println("\nDanh mục cha: " + this.parentId);
	}
	
	/*------------------------ KIỂM TRA DỮ LIỆU NHẬP VÀO -------------------------------*/
		/*------- Kiểm tra tên danh mục nhập vào ------------------------*/
	public String inputCatalogName(Scanner sc) {
		while(true) {
			boolean check = true;
			String inputcataName = sc.nextLine();
			if(inputcataName.length() >= 6 && inputcataName.length() <= 60) {
				for(int i = 0; i < inputcataName.length(); i++) {
					if(inputcataName.charAt(i) == ' ' && inputcataName.charAt(i) == inputcataName.charAt(i+1)) {
						check = false;
						break;
					}
				}
				if(check == true) return inputcataName;
				else {
					System.err.println("Không được nhập liền 2 dấu cách !!!");
					System.out.print("Nhập lại: ");
				}
			}else {
				System.err.println("Tên danh mục phải có từ 6 đến 60 ký tự !!!");
				System.out.print("Nhập lại: ");
			}
		}
	}
	
		/*------------- Kiểm tra mô tả danh mục nhập vào -----------------*/
	public String inputdescription(Scanner sc) {
		while(true) {
			String inputdcs = sc.nextLine();
			if(inputdcs.length() > 0) return inputdcs;
			else {
				System.err.println("Không được để trống phần mô tả !!!");
				System.out.print("Nhập lại: ");
			}
		}
	}
	
		/*------------ Kiểm tra trạng thái danh mục nhập vào ------------------*/
	public Boolean inputStatus(Scanner sc) {
		while(true) {
			String inputStatus = sc.nextLine();
			if(inputStatus.equals("true") || inputStatus.equals("false")) {
				return Boolean.parseBoolean(inputStatus);
			}else {
				System.err.println("Trạng thái chỉ nhận giá trị true hoặc false !!!");
				System.out.print("Nhập lại: ");
			}
		}
	}
	
	/*---------- HIỂN THỊ TRẠNG THÁI CỦA DANH MỤC -------------*/
	public String displayStatus() {
		if(this.catalogStatus == true) {
			return "HOAT DONG";
		}else return "KHONG HOAT DONG";
	}
		/***/
}
