package com.nit.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.nit.Repository.EmployeeRepo;
import com.nit.Repository.PandSRepo;
import com.nit.entity.Employee;
import com.nit.services.IPagingandSortingService;
@Component
public class PagingandSortingServiceImpl implements IPagingandSortingService{

	@Autowired
	private PandSRepo PandSsevice;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	@Override
	public Iterable<Employee> getEmployeByOrder(boolean ascOrder, String... props) {
		//create a sort obj
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		//use repo
		Iterable<Employee> findAllByOrder = PandSsevice.findAll(sort);
		return findAllByOrder;
	}
	@Override
	public Page<Employee> getEmployeThroughPaging(Integer pageNumber, Integer pageSize, boolean ascOrder,
			String props) {
		//make sort obj
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,props);
		//make pagable obj
		Pageable pageable=PageRequest.of(1, 2, sort);
		Page<Employee> findAllByPagingAndSorting= PandSsevice.findAll(pageable);
		return findAllByPagingAndSorting;
	}
	@Override
	public void showdataThroughPagination(int pageSize) {
		long count = empRepo.count();
		long pageNumber=count/pageSize;
		if(count%pageNumber!=0)
			pageNumber++;
		
		for(int i=0;i<pageNumber;++i)
		{
			Pageable pageable=PageRequest.of(i, pageSize);
			Page<Employee> page = PandSsevice.findAll(pageable);
			System.out.println("Page::"+page.getNumber()+1+" "+"records of::"+page.getTotalPages());
			page.getContent().forEach(System.out::println);
			
		}
		
	}

}
