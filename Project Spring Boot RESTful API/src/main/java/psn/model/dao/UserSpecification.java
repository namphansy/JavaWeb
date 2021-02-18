package psn.model.dao;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import psn.model.entity.Brand;
import psn.model.entity.Categories;
import psn.model.entity.Material;
import psn.model.entity.Products;

public final class UserSpecification {
	
	// ------- Lọc sản phẩm theo danh mục -------------
	public static Specification<Products> catlogId(int catlogId) {
		return (root, query, cb) -> {
			Join<Products, Categories> cata = root.join("catalog");
			return cb.equal(cata.get("catalogId"), catlogId);
		};
	}
	
	//-------- Lọc sản phẩm theo thương hiệu -----------
	public static Specification<Products> brandName(String brandName) {
		return (root, query, cb) -> {
			if(brandName == null) {
				return cb.isTrue(cb.literal(true));
			}
			
			Join<Products, Brand> cata = root.join("brandProduct");
			return cb.equal(cata.get("brandName"), brandName);
		};
	}
	
	//---------- Lọc sản phẩm theo chất liệu ------------
	public static Specification<Products> materialName(String materialName) {
		return (root, query, cb) -> {
			if(materialName == null) {
				return cb.isTrue(cb.literal(true));
			}
			
			Join<Products, Material> cata = root.join("materialProduct");
			return cb.equal(cata.get("materialName"), materialName);
		};
	}
	
}
