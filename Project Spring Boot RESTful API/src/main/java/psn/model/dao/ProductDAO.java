package psn.model.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import psn.model.entity.Products;

@Repository
public interface ProductDAO extends JpaRepository<Products, String>, JpaSpecificationExecutor<Products>{
	
	/*--------- Hiển thị sản phẩm theo danh mục -------------------*/
	@Query(value = "SELECT pro FROM Products pro "
			+ "WHERE pro.catalog.catalogId IN :catalogId "
			+ "AND NOT EXISTS "
				+ "(SELECT pro FROM Products pro WHERE "
				+ "pro.catalog.catalogId IN :catalogId "
				+ "AND pro.brandProduct.brandName IN :brand )"
			+ "OR (pro.catalog.catalogId IN :catalogId "
				+ "AND pro.brandProduct.brandName IN :brand )")		
	Page<Products> findByCategories(
			@Param("catalogId") Integer catalogId,
			@Param("brand") String brand,
//			@Param("material") String material,
			Pageable pageable);
	
	/*----------- Tìm kiếm sản phẩm người dùng nhâp vào ---------------------*/
	@Query(value = "Select pro from Products pro where pro.productName like %:keyword%")
	List<Products> search(@Param("keyword") String keyword, Pageable pageable);
	
}

