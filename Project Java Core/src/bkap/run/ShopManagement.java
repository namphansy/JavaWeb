package bkap.run;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import bkap.entity.Categories;
import bkap.entity.Product;

public class ShopManagement {
	public static Scanner sc = new Scanner(System.in);
	private final String pathProduct = "C:\\Users\\Dell\\Desktop\\Java Core I\\Final_Exam\\products.txt";
	private final String pathCate = "C:\\Users\\Dell\\Desktop\\Java Core I\\Final_Exam\\categories.txt";
	private List<Categories> listCategories = readFile(pathCate);
	private List<Product> listProduct = readFile(pathProduct);
	private int choice;
	
	public static void main(String[] args) {
		ShopManagement sm = new ShopManagement();
		sm.showMenu();
	}
	
	/*--------------------- SHOW TẤT CẢ MENU ---------------------------------------------------------*/
		/*------------- MENU chính -------------------------------------------------*/
	public void showMenu() {
		
		do {
			System.out.println("---------------- MENU ---------------------");
			System.out.println("1. Quản lý danh mục");
			System.out.println("2. Quản lý sản phẩm");
			System.out.println("3. Thoát");
			
			System.out.print("Nhập lựa chọn của bạn: "); choice = inputChoice();
			switch (choice) {
			case 1:
				showQuanLyDanhMuc();
				break;
			case 2:
				showQuanLySanPham();
				break;
			case 3:
				System.out.println("Bạn đã thoát khỏi chương trình !!!");
				System.exit(0);
				break;
			default:
				System.err.println("Bạn phải nhập từ 1 đén 3");
				break;
			}
		} while (true);
	}
	
		/*------------- Quản lý danh mục (MENU) ------------------------------------*/
	public void showQuanLyDanhMuc() {
		do {
			System.out.println("------------- QUẢN LÝ DANH MỤC ---------------");
			System.out.println("1. Danh sách danh mục");
			System.out.println("2. Thêm danh mục");
			System.out.println("3. Xóa danh mục");
			System.out.println("4. Tìm kiếm danh mục");
			System.out.println("5. Quay lại");
			
			System.out.print("Nhập lựa chọn của bạn: "); choice = inputChoice();
			switch (choice) {
			case 1:
				showDanhSachDanhMuc();
				break;
			case 2:
				inputCategories();
				break;
			case 3:
				removeCatagories();
				break;
			case 4: 
				findCatagories();
				break;
			case 5:
				showMenu();
			default:
				System.err.println("Bạn phải nhập từ 1 đến 5");
				break;
			}
		} while (true);
	}
	
		/*------------- Danh sách danh mục (Quản lý danh mục - MENU) -------------- */
	public void showDanhSachDanhMuc() {
		do {
			System.out.println("----------- DANH SÁCH DANH MỤC ----------------");
			System.out.println("1. Danh sách cây danh mục");
			System.out.println("2. Thông tin chi tiết danh mục");
			System.out.println("3. Quay lại");
			
			System.out.print("Nhập menu bạn lựa chọn: "); choice = inputChoice();
			switch (choice) {
			case 1:
				displayCatagoriesByTree();
				break;
			case 2:
				displayCatagoriesByName();
				break;
			case 3:
				showQuanLyDanhMuc();
				break;
			default:
				System.err.println("Bạn phải nhập từ 1 đến 3");
				break;
			}
		} while (true);
		
	}
	
		/*------------- Quản lý sản phẩm (MENU) ----------------------------------- */
	public void showQuanLySanPham() {
		do {
			System.out.println("------------ QUẢN LÝ SẢN PHẨM -------------------");
			System.out.println("1. Thêm sản phẩm mới");
			System.out.println("2. Tính lợi nhuận sản phẩm");
			System.out.println("3. Hiển thị thông tin sản phẩm");
			System.out.println("4. Sắp xếp sản phẩm");
			System.out.println("5. Cập nhật thông tin sản phẩm");
			System.out.println("6. Cập nhật trạng thái sản phẩm");
			System.out.println("7. Quay lại");
			
			System.out.print("Nhập lựa chọn menu của bạn: "); choice = inputChoice();
			switch (choice) {
			case 1:
				inputProduct();
				break;
			case 2:
				calculatorProfit();
				break;
			case 3: 
				showThongTinSanPham();
				break;
			case 4:
				showSapXepSanPham();
				break;
			case 5:
				upadateInfoProduct();
				break;
			case 6: 
				updateStatusProduct();
				break;
			case 7:
				showMenu();
				break;
			default:
				System.err.println("Bạn phải nhập từ 1 đến 7 !!!");
				break;
			}
		} while (true);
		
	}
	
		/*------------- Thông tin sản phẩm (Quản lý sản phẩm - MENU) ---------------*/
	public void showThongTinSanPham() {
		do {
			System.out.println("----------- THÔNG TIN SẢN PHẨM ------------------");
			System.out.println("1. Hiển thị sản phẩm theo danh mục");
			System.out.println("2. Hiện thị chi tiết sản phẩm");
			System.out.println("3. Quay lại");
			
			System.out.print("Nhập lựa chọn của bạn: "); choice = inputChoice();
			switch (choice) {
			case 1: 
				displayProductByCategories();
				break;
			case 2: 
				displayProductByName();
				break;	
			case 3: 
				showQuanLySanPham();
				break;
			default:
				System.err.println("Bạn phải nhập từ 1 đến 3 !!!");
				break;
			}
		} while (true);
		
	}
	
		/*------------- Sắp xếp sản phẩm (Quản lý sản phẩm - MENU) -----------------*/
	public void showSapXepSanPham() {
		do {
			System.out.println("----------- SẮP XẾP SẢN PHẨM --------------------");
			System.out.println("1. Sắp xếp sản phẩm theo giá bán tăng dần");
			System.out.println("2. Sắp xếp sản phẩm theo lợi nhuận tăng dần");
			System.out.println("3. Quay lại");
			
			System.out.print("Nhập lựa chọn của bạn: "); choice = inputChoice();
			switch (choice) {
			case 1: 
				sortProductByExPrice();
				break;
			case 2:
				sortProductByProfit();
				break;	
			case 3: 
				showQuanLySanPham();
				break;
			default:
				System.err.println("Bạn phải nhập từ 1 đến 3");
				break;
			}
		} while (true);
		
	}

	
	/*------------------ XỬ LÝ CASE TRONG CÁC MENU ---------------------------------------------------*/
		/*-------------- Xử lý case trong QUẢN LÝ DANH MỤC -----------------------------------*/
		// Nhập các danh mục - CASE 2
	public void inputCategories() {
//		listCategories.clear(); // xóa toàn bộ phần tử trong list
		System.out.print("Nhập số danh mục bạn muốn thêm: "); int n = inputChoice();
		for(int i = 0; i < n; i++) {
			Categories ctg = new Categories();
			System.out.println("Nhập danh mục thứ " + (i+1));
			////////////////////////////////////////////////
			while(true) {
				boolean check = true;
				System.out.print("Nhập mã danh mục: "); int ctgId = inputChoice();
				if(ctgId > 0) {
					for(Categories lct : listCategories) {
						if(lct.getCatalogId() == ctgId) {
							check = false;
							break;
						}
					}
					if(check == true) {
						ctg.setCatalogId(ctgId); 
						break;
					}else {
						System.err.println("Mã danh mục đã tồn tại !!!");
					}
				}else {
					System.err.println("Mã danh mục phải lớn hơn 0");
				}
			}
			/////////////////////////////////////////////////////////
			while(true) {
				boolean check = true;
				boolean check2 = true;
				System.out.print("Nhập mã danh mục cha: "); int parenID = inputChoice();
				if(parenID == 0) {
					ctg.setParentId(parenID); 
					break;
				}else if(ctg.getCatalogId() == parenID){
					System.err.println("Mã danh mục cha và mã danh mục không được trùng nhau !!!");
				}
				else {
					for(Categories lct : listCategories) {
						if(lct.getCatalogId() == parenID) {
							if(lct.getParentId() != 0) {
								for(Categories lctg : listCategories) {
									if(lct.getParentId() == lctg.getCatalogId()) {
										if(lctg.getParentId() == 0) {
											check = false;
											break;
										}else {
											check2 = false;
											break;
										}
									}
								}
							}else {
								check = false;
								break;
							}
						}
					}
					if(check2 == false) {
						System.err.println("Chỉ quản lý tối đa 3 cấp danh mục !!!");
					}else {
						if(check == false) {
							ctg.setParentId(parenID);
							break;
						}else {
							System.err.println("Mã danh mục chưa tồn tại !!!");
						}
					}
				}
			}
			////////////////////////////////////////////////////////
			ctg.inputData(sc);
			listCategories.add(ctg);
		}
		
		writeToFile(listCategories, pathCate);
	}
		
	// Xóa danh mục - CASE 3
	public void removeCatagories() {
		boolean check = true;
		System.out.print("Nhập mã danh mục bạn muốn xóa: "); int deleteID = inputChoice();
		for(int i = 0; i < listCategories.size(); i++) {
			if(listCategories.get(i).getCatalogId() == deleteID) {
				listCategories.remove(i);
				System.out.println("Đã xóa danh mục !!!");
				check = false;
				break;
			}
		}
		if(check) System.err.println("Mã danh mục bạn cần xóa không tồn tại !!!");
	}
		
	// Tìm kiếm danh mục - CASE 4
	public void findCatagories() {
		boolean check = true;
		System.out.print("Nhập tên danh mục cần tìm kiếm: "); 
		String nameCata = sc.nextLine();
		System.out.println("----Thông tin danh mục bạn cần tìm kiểm----");
		for(Categories lctg : listCategories) {
			if(lctg.getCatalogName().equals(nameCata)) {
				lctg.displayData();
				check = false;
				break;
			}
		}if(check) System.err.println("Tên danh mục bạn tìm không tồn tại !!!");
	}
		
	
		/*-------------- Xử lý case trong DANH SÁCH DANH MỤC --------------------------------*/
		// Hiển thị theo dạng cây - CASE 1
	public void displayCatagoriesByTree() {
		int size = listCategories.size(); if(size == 0) System.out.println("Không có danh sách hiển thị !!!");
		int a1 = 1 ; int a2 = 1; int a3 = 1;
		
		System.out.println("----Hiển thị danh mục theo dạng cây----");
		for(int i = 0; i < size; i++) {
			if(listCategories.get(i).getParentId() == 0) {
				System.out.println(a1 +"."+ listCategories.get(i).getCatalogName());
				a2 = 1;
				for(int j = 0; j < size; j++) {
					if(listCategories.get(j).getParentId() == listCategories.get(i).getCatalogId()) {
						System.out.println("\t"+ a1 +"." + a2 + "." + listCategories.get(j).getCatalogName());
						a3=1;
						for(int k = 0; k < size; k++) {
							if(listCategories.get(k).getParentId() == listCategories.get(j).getCatalogId()) {
								System.out.println("\t\t"+ a1 +"."+ a2 +"."+ a3++ +"."+ listCategories.get(k).getCatalogName());
							}
						}
						a2++;
					}
				}
				a1++;
			}
		}
	}
		
		// Hiển thị chi tiết thông tin danh mục theo tên - CASE 2
	public void displayCatagoriesByName() {
		boolean check = true;
		System.out.print("Nhập tên danh mục bạn muốn hiển thị chi tiết: "); String nameCata = sc.nextLine();
		for(int i = 0; i < listCategories.size(); i++) {
			if(listCategories.get(i).getCatalogName().contains(nameCata)) {
				check = false;
				listCategories.get(i).displayData();
				System.out.println("//////////////////////////");
			}
		}if(check) System.err.println("Tên danh mục bạn nhập không tồn tại !!!");
	}
		
	
		/*----------------- Xử lý case trong QUẢN LÝ SẢN PHẨM ------------------------------*/
		// Thêm sản phẩm mới - CASE 1
	public void inputProduct() {
		listProduct.clear();
		System.out.print("Nhập số sản phẩm bạn muốn thêm: "); int n = inputChoice();
		for(int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin sản phẩm thứ " + (i+1));
			Product prd = new Product();
			/////// Nhập mã sản phẩm ///////
			while(true) {
				boolean checkId = true;
				System.out.print("Nhập mã sản phẩm: ");
				String inputPrdId = sc.nextLine();
				if(inputPrdId.length() == 4) {
					if(inputPrdId.charAt(0) == 'C') {
						for(Product lprd : listProduct) {
							if(lprd.getProductId().equals(inputPrdId)) {
								System.err.println("Mã sản phẩm đã tồn tại !!!");
								checkId = false;
								break;
							}
						}if(checkId == true) {
							prd.setProductId(inputPrdId);
							break;
						}
					}else {
						System.err.println("Mã sản phẩm phải bắt đầu bằng ký tự C");
					}
				}else {
					System.err.println("Mã sản phẩm phải đúng 4 ký tự !!!");
				}
			}
			/////// Nhập tên sản phẩm ////////
			while(true) {
				boolean checkName = true;
				System.out.print("Nhập tên sản phẩm: ");
				String inputNamePrd = sc.nextLine();
				if(inputNamePrd.length() >= 6 && inputNamePrd.length() <= 50) {
					for(Product lprd : listProduct) {
						if(lprd.getProductName().equals(inputNamePrd)) {
							System.err.println("Tên sản phẩm đã tồn tại !!!");
							checkName = false;
							break;
						}
					}if(checkName == true) {
						prd.setProductName(inputNamePrd);
						break;
					}
				}else {
					System.err.println("Tên sản phẩm phải có độ dài từ 6 đến 50 ký tự !!!");
				}
			}
			////// Nhập danh mục sản phẩm cho sản phẩm ///////
			while(true) {
				boolean checkCateId = true;
				System.out.print("Nhập mã danh mục chứa sản phẩm: "); 
				int inputCateId = inputChoice();
				for(Categories lct : listCategories) {
					if(lct.getCatalogId() == inputCateId) {
						prd.setCatalog(lct);
						checkCateId = false;
						break;
					}
				}if(checkCateId == false) {
					break;
				}else{
					System.err.println("Mã danh mục chưa tồn tại !!!");
				}
			}
			////// Nhập dữ liệu cho các trường còn lại ///////////
			prd.inputData(sc);
			listProduct.add(prd);
		}
		
		writeToFile(listProduct, pathProduct);
	}
	
		// Tình lợi nhuận sản phẩm - CASE 2
	public void calculatorProfit() {
		for(Product lprd : listProduct) {
			lprd.calProfit();
		}
		System.out.println("Đã hoàn thành việc tính toán !!!");
		writeToFile(listProduct, pathProduct);
	}
	
		// Cập nhật thông tin sản phẩm - CASE 5
	public void upadateInfoProduct() {
		while(true) {
			System.out.print("Nhập mã thông tin sản phẩm cần cập nhật: ");
			String inputPrdID = sc.nextLine();
			for(int i = 0; i < listProduct.size(); i++) {
				if(listProduct.get(i).getProductId().equals(inputPrdID)) {
					listProduct.get(i).inputData(sc);
					listProduct.get(i).calProfit();
					System.out.println("Đã cập nhật thông tin cho sản phẩm !!!");
					break;
				}
			}
			break;
		}
		writeToFile(listProduct, pathProduct);
	}
	
		// Cập nhật trạng thái sản phẩm - CASE 6
	public void updateStatusProduct() {
		boolean check = true;
		System.out.print("Nhập mã sản phẩm để cập nhật trạng thái: ");
		String inputPrdID = sc.nextLine();
		for(int i = 0; i < listProduct.size(); i++) {
			if(listProduct.get(i).getProductId().equals(inputPrdID)) {
				check = false;
				boolean statusOld = listProduct.get(i).isProductStatus();
				listProduct.get(i).setProductStatus(!statusOld);
				boolean statusNew = listProduct.get(i).isProductStatus();
				System.out.printf("Đã chuyển trạng thái sản phẩm từ %b sang thành %b", statusOld, statusNew);
				System.out.println();
				break;
			}
		}if(check) System.err.println("Mã sản phẩm bạn nhập không tồn tại !!!");
		
		writeToFile(listProduct, pathProduct);
	}
	
	
		/*----------------- Xử lý case trong THÔNG TIN SẢN PHẨM ----------------------------*/
		// Hiển thị sản phẩm theo danh muc - CASE 1
	public void displayProductByCategories() {
		for(Categories lctg : listCategories) {
			boolean check = true;
			String nameCata = lctg.getCatalogName();
			for(Product lprd : listProduct) {
				if(lprd.getCatalog().getCatalogName().equals(nameCata)) {
					System.out.println("Các sản phẩm của danh mục " + nameCata);
					String nameProd = lprd.getProductName();
					System.out.println("\t"+nameProd);
				}
			}
		}
	}
	
		// Hiển thi chi tiết sản phẩm - CASE 2
	public void displayProductByName() {
		System.out.print("Nhập tên sản phẩm cần hiển thị: ");
		String nameCata = sc.nextLine();
		for(Product lprd : listProduct) {
			if(lprd.getProductName().contains(nameCata)) {
				lprd.displayData();
				System.out.println("///////////////////");
			}
		}
	}
	
	
		/*----------------- Xử lý case trong SẮP XẾP SẢN PHẨM -------------------------------*/
		// Sắp xếp theo giá bán sản phẩm - CASE 1
	public void sortProductByExPrice() {
		Collections.sort(listProduct, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				if(o1.getExportPrice() > o2.getExportPrice()) {
					return 1;
				}else return -1;
			}
		});
		System.out.println("Đã hoàn thành việc sắp xếp !!!");
		System.out.println("Danh sách sau khi đã sắp xếp");
		int i = 1;
		for(Product lprd : listProduct) {
			System.out.println("Thông tin sản phẩm thứ " + i);
			System.out.printf("Tên sản phẩm: %s - Giá bán sản phẩm: %f", 
					lprd.getProductName(), lprd.getExportPrice());
			i++;
		}
	}
	
		// Sắp xếp theo lợi nhuận - CASE 2
	public void sortProductByProfit() {
		Collections.sort(listProduct, new Comparator<Product>() {

			@Override
			public int compare(Product o1, Product o2) {
				if(o1.getProfit() > o2.getProfit()) {
					return 1;
				}else return -1;
			}
		});
		System.out.println("Đã sắp xếp xong !!!");
		System.out.println("Danh sách sau khi đã sắp xếp");
		int i = 1;
		for(Product lprd : listProduct) {
			System.out.println("thông tin sản phẩm thứ " + i);
			System.out.printf("Tên sản phẩm: %s - Lợi nhuận của sản phẩm: %f", 
					lprd.getProductName(), lprd.getProfit());
			i++;
		}
	}
	
	/*------------------- XỬ LÝ ĐỌC GHI FILE ------------------------------------------------------*/
		// Ghi file
	public <T> void writeToFile(List<T> inputlist, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(inputlist);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Đã ghi thông tin vào file !!!");
	}
		
		// Đọc File
	@SuppressWarnings("unchecked")
	public <T> List<T> readFile(String path) {
		List<T> listCtg = new ArrayList<T>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			listCtg = (List<T>) ois.readObject();
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return listCtg;
	}
	
	
	/*----- XỬ LÝ NHẬP DỮ LIỆU CHO KIỂU DỮ LIỆU INTEGER ------*/
	public Integer inputChoice() {
		while(true) {
			try {
				int inChoice = Integer.parseInt(sc.nextLine());
				return inChoice;
			} catch (Exception e) {
				System.err.println("Bạn phải nhập số nguyên !!!");
				System.out.print("Nhập lại: ");
			}	
		}
	}
	
}
