package com.pangchun.jpacrud.controller;

import com.pangchun.jpacrud.entity.Employee;
import com.pangchun.jpacrud.entity.PageInfo;
import com.pangchun.jpacrud.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class EmpController {

    @Autowired
    EmpRepository empRepository;

    @GetMapping("/list")
    public String toListPage(Model model) {
        PageInfo pageInfo =  new PageInfo();
        pageInfo.setPageNum(0);
        pageInfo.setPageSize(8);

        Pageable pageable = PageRequest.of(pageInfo.getPageNum(),pageInfo.getPageSize());
        Page<Employee> page = empRepository.findAll(pageable);

        pageInfo.setTotalRecords((int) page.getTotalElements());//数据总条数
        pageInfo.setTotalPages(page.getTotalPages());//总页数
        List<Employee> employeeList = page.getContent();//所有员工列表

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("employeeList",employeeList);
        return "list";
    }

    @GetMapping("/list/{pageNum}")
    public String findByPageNum(@PathVariable("pageNum") Integer pageNumParam,Model model){

        PageInfo pageInfo =  new PageInfo();
        pageInfo.setPageNum(pageNumParam);
        pageInfo.setPageSize(8);

        Pageable pageable = PageRequest.of(pageInfo.getPageNum(),pageInfo.getPageSize());
        Page<Employee> page = empRepository.findAll(pageable);

        pageInfo.setTotalRecords((int) page.getTotalElements());//数据总条数
        pageInfo.setTotalPages(page.getTotalPages());//总页数
        List<Employee> employeeList = page.getContent();//所有员工列表

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("employeeList",employeeList);

        return "list";
    }

    @GetMapping("/list/specQuery")
    public String specQuery(Employee employee,Model model){
        PageInfo pageInfo =  new PageInfo();
        pageInfo.setPageNum(0);
        pageInfo.setPageSize(8);
        Pageable pageable = PageRequest.of(pageInfo.getPageNum(),pageInfo.getPageSize());


        List<Employee> employeeList = empRepository.findAll(new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Predicate predicate = cb.conjunction();

                if (!ObjectUtils.isEmpty(employee)) {
                    if (!ObjectUtils.isEmpty(employee.getEmpNo()))
                        predicate.getExpressions().add(cb.equal(root.get("empNo"), employee.getEmpNo()));
                    if (!ObjectUtils.isEmpty(employee.getEmpName()))
                        predicate.getExpressions().add(cb.like(root.get("empName"), "%" + employee.getEmpName() + "%"));
                    if (!ObjectUtils.isEmpty(employee.getEducation()))
                        predicate.getExpressions().add(cb.equal(root.get("education"), employee.getEducation()));
                }

                return predicate;
            }
        });

        model.addAttribute("employeeList",employeeList);
        return "list";
    }


    @GetMapping("/emp")
    public String toAddPage(){
        return "addPage";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){

       // System.out.println(employee);

        empRepository.save(employee);

        return "redirect:/list";
    }

    @GetMapping("/emp/{empNo}")
    public String toEditPage(@PathVariable("empNo") Integer empNo,Model model){

        Optional<Employee> employeeOptional = empRepository.findById(empNo);
        Employee employee = employeeOptional.get();

        model.addAttribute("employee",employee);

        //System.out.println(employee);

        return "addPage";
    }

    @PutMapping("/emp")
    public String editEmp(Employee employee){
        //System.out.println(employee);

        empRepository.save(employee);

        return "redirect:/list";
    }

    @DeleteMapping("/emp/{empNo}")
    public String delEmp(@PathVariable("empNo") Integer empNo){
        //System.out.println("delete");

        empRepository.deleteById(empNo);

        return "redirect:/list";
    }
}
