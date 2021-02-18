
package bkap.entity;

import java.io.Serializable;
import java.util.Scanner;
import bkap.itf.IProduct;

public class Product implements IProduct, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private String title;
	private float importPrice;
	private float exportPrice;
	private float profit;
	private String descriptions;
	private boolean productStatus;
	private Categories catalog;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, String title, float importPrice, float exportPrice,
			float profit, String descriptions, boolean productStatus, Categories catalog) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.title = title;
		this.importPrice = importPrice;
		this.exportPrice = exportPrice;
		this.profit = profit;
		this.descriptions = descriptions;
		this.productStatus = productStatus;
		this.catalog = catalog;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}

	public float getExportPrice() {
		return exportPrice;
	}

	public void setExportPrice(float exportPrice) {
		this.exportPrice = exportPrice;
	}

	public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
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

	@Override
	public void inputData(Scanner sc) {
		System.out.print("Nhập tiêu để của sản phẩm: "); this.title = inputTitle(sc);
		System.out.print("Nhập vào giá nhập sản phẩm: "); this.importPrice = inputImportPrice(sc);
		System.out.print("Nhập giá bán của sản phẩm: "); this.exportPrice = inputExportPrice(sc);
		System.out.print("Nhập mô tả về sản phẩm: "); this.descriptions = inputDescription(sc);
		System.out.print("Nhập trạng thái của sản phẩm: "); this.productStatus = inputStatus(sc);
	}

	@Override
	public void displayData() {
		System.out.printf("Mã sản phẩm là: %s - Tên sản phẩm là: %s", this.productId, this.productName);
		System.out.printf("\nTiêu đề sản phẩm là: %s - Giá nhập sản phẩm là: %.1f", this.title, this.importPrice);
		System.out.printf("\nGiá bán sản phẩm là: %.1f - Lợi nhuận của sản phẩm là: %.1f", this.exportPrice, this.profit);
		System.out.printf("\nMô tả về sản phẩm: %s - Trạng thái của sản phẩm là: %b", this.descriptions, this.productStatus );
		System.out.println("\nDanh mục sản phẩm của sản phầm là: " + this.catalog.getCatalogName());
	}

	@Override
	public void calProfit() {
		this.profit = this.exportPrice - this.importPrice;
		
	}
	
	/*----------------- KIỂM TRA DỮ LIỆU NHẬP VÀO -------------------*/
		/*-------- Kiểm tra tiêu đề sản phẩm ----------*/
	public String inputTitle(Scanner sc) {
		while(true) {
			boolean check = true;
			String inputTit = sc.nextLine();
			if(inputTit.length() >= 6 && inputTit.length() <= 30) {
				for(int i = 0; i < inputTit.length(); i++) {
					if(inputTit.charAt(i) == ' ' && inputTit.charAt(i) == inputTit.charAt(i+1)) {
						check = false;
						break;
					}
				}
				if(check == true) {
					return inputTit;
				}
				else {
					System.err.println("Không được nhập 2 khoảng trắng liên tiếp !!!");
					System.out.print("Nhập lại: ");
				}
			}else {
				System.err.println("Tiêu đề phải có độ dài từ 6 đến 30 ký tự !!!");
				System.out.print("Nhập lại: ");
			}
		}
	}
	
		/*--------- Kiểm tra giá nhập vào của sản phẩm ------------------*/
	public Float inputImportPrice(Scanner sc) {
		while(true) {
			try {
				float inputIP = Float.parseFloat(sc.nextLine());
				if(inputIP > 0) return inputIP;
				else {
					System.err.println("Giá nhập vào của sản phẩm phải lớn hơn 0 !!!");
					System.out.print("Nhập lại: ");
				}
			} catch (Exception e) {
				System.err.println("Bạn phải nhập số thực !!!");
				System.out.print("Nhập lại: ");
			}
			
		}
	}
	
		/*-------- Kiểm tra giá bán sản phẩm --------------------------*/
	public Float inputExportPrice(Scanner sc) {
		while(true) {
			try {
				float inputEP = Float.parseFloat(sc.nextLine());
				float profitMIN = inputEP*MIN_INTEREST_RATE;
				if(inputEP >= this.importPrice + profitMIN) {
					return inputEP;
				}else {
					System.err.println("Giá bán phải lớn hơn ít nhất 20% so với giá nhập !!!");
					System.out.print("Nhập lại: ");
				}
			} catch (Exception e) {
				System.err.println("Phải nhập số thực !!!");
				System.out.print("Nhập lại: ");
			}
		}
	}
	
		/*---------- Kiểm tra mô tả sản phẩm -----------------*/
	public String inputDescription(Scanner sc) {
		while(true) {
			boolean check = true;
			String inputDct = sc.nextLine();
			if(inputDct.length() > 0) {
				for(int i = 0; i < inputDct.length(); i++) {
					if(inputDct.charAt(i) == ' ' && inputDct.charAt(i) == inputDct.charAt(i+1)) {
						check = false;
						break;
					}
					if(check) return inputDct;
					else {
						System.err.println("Không được nhập 2 khoảng trắng liên tiếp !!!");
						System.out.print("Nhập lại: ");
					}
				}
			}else {
				System.err.println("Mô tả sản phẩm không được để trống !!!");
				System.out.print("Nhập lại: ");
			}
		}
	}
	
		/*--------- Kiểm tra trạng thái sản phẩm --------------------*/
	public Boolean inputStatus(Scanner sc) {
		while(true) {
			String inputSTT = sc.nextLine();
			if(inputSTT.equals("true") || inputSTT.equals("false")
					|| inputSTT.equals("TRUE") || inputSTT.equals("FALSE")) {
				return Boolean.parseBoolean(inputSTT);
			}else {
				System.err.println("Phải nhập 'true' hoặc 'false' ");
				System.out.print("Nhập lại: ");
			}
		}
	}
	/*-------------- HIỂN THỊ TRẠNG THÁI SẢN PHẨM -------------------------*/
	public String displayStatus() {
		if(this.productStatus == true) return "HOAT DONG";
		else return "KHONG HOAT DONG";
	}
	
}
