package com.capg.anuraag.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.anuraag.entity.EmployeeDet;
@Repository

public interface EmployeeDaoI  extends JpaRepository<EmployeeDet, Integer>{
	@Query("select e.name,e.salary from EmployeeDet e where e.salary=?1")
	Optional<EmployeeDet> findSalBt(@Param("c") Integer sal1);
	@Query("select e.name,e.salary from EmployeeDet e where e.salary between ?1 and ?2")
	List findSalBet(Integer sal1, Integer sal2);
	
	

}
