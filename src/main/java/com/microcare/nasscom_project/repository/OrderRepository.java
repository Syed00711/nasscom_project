package com.microcare.nasscom_project.repository;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.microcare.nasscom_project.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

@Query(value="select o.* from orders o where o.order_date between ?1 and ?2",nativeQuery=true)
Collection<Order> findByOrderDateRange(LocalDate from,LocalDate to);
	
}
