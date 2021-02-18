package psn.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import psn.model.entity.ProductsDetails;

public interface ProductDetailDAO extends JpaRepository<ProductsDetails, Integer>  {

}
