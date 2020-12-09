package com.pangchun.jpacrud.repository;

import com.pangchun.jpacrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmpRepository extends
        CrudRepository<Employee,Integer>,
        PagingAndSortingRepository<Employee,Integer>,
        JpaSpecificationExecutor<Employee> {
}
