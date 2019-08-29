package com.geekerstar.mp.service.impl;

import com.geekerstar.mp.beans.Employee;
import com.geekerstar.mp.mapper.EmployeeMapper;
import com.geekerstar.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

	//不用再进行mapper的注入.

	/**
	 * EmployeeServiceImpl  继承了ServiceImpl
	 * 1. 在ServiceImpl中已经完成Mapper对象的注入,直接在EmployeeServiceImpl中进行使用
	 * 2. 在ServiceImpl中也帮我们提供了常用的CRUD方法， 基本的一些CRUD方法在Service中不需要我们自己定义.
	 *
	 *
	 */
}
