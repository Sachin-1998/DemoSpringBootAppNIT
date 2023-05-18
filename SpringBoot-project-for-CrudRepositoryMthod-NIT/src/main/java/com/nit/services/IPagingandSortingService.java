package com.nit.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nit.entity.Employee;

@Service
public interface IPagingandSortingService 
{
	public Iterable<Employee> getEmployeByOrder(boolean ascOrder, String... props);
    
	public Page<Employee> getEmployeThroughPaging(Integer pageNumber,Integer pageSize, boolean ascOrder,String props);
	
	public void showdataThroughPagination(int pageSize);
}
