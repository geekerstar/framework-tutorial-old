package com.geekerstar.mp;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geekerstar.mp.beans.Employee;
import com.geekerstar.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

public class TestMP {
	private ApplicationContext ioc =
				new ClassPathXmlApplicationContext("applicationContext.xml");

	/**
	 * AR  分页复杂操作
	 */
	@Test
	public void  testARPage() {

		Employee employee = new Employee();

		Page<Employee> page = employee.selectPage(new Page<>(1, 1),
				new EntityWrapper<Employee>().like("last_name", "老"));
		List<Employee> emps = page.getRecords();
		System.out.println(emps);
	}


	/**
	 * AR 删除操作
	 *
	 * 注意: 删除不存在的数据 逻辑上也是属于成功的.
	 */
	@Test
	public void testARDelete() {

		Employee employee = new Employee();
		//boolean result = employee.deleteById(2);
//		employee.setId(2);
//		boolean result = employee.deleteById();
//		System.out.println("result:" +result );


		boolean result = employee.delete(new EntityWrapper<Employee>().like("last_name", "小"));
		System.out.println(result );
	}


	/**
	 * AR 查询操作
	 */
	@Test
	public void testARSelect() {
		Employee employee = new Employee();

		//Employee result = employee.selectById(14);
//		employee.setId(14);
//		Employee result = employee.selectById();
//		System.out.println(result );


//		List<Employee> emps = employee.selectAll();
//		System.out.println(emps);

//		List<Employee > emps=
//				employee.selectList(new EntityWrapper<Employee>().like("last_name", "老师"));
//		System.out.println(emps);

		Integer result = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
		System.out.println("result: " +result );



	}


	/**
	 * AR 修改操作
	 */
	@Test
	public void testARUpdate() {
		Employee employee = new Employee();
		employee.setId(20);
		employee.setLastName("宋老湿");
		employee.setEmail("sls@geekerstar.com");
		employee.setGender(1);
		employee.setAge(36);


		boolean result = employee.updateById();
		System.out.println("result:" +result );

	}



	/**
	 * AR  插入操作
	 */
	@Test
	public void  testARInsert() {
		Employee employee = new Employee();
		employee.setLastName("宋老师");
		employee.setEmail("sls@geekerstar.com");
		employee.setGender(1);
		employee.setAge(35);

		boolean result = employee.insert();
		System.out.println("result:" +result );
	}




}
