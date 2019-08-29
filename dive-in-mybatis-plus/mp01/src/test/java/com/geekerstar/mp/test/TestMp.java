package com.geekerstar.mp.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.geekerstar.mp.beans.Employee;
import com.geekerstar.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


/**
 * @author geekerstar
 * @date 2018/12/11
 * description
 */
public class TestMp {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);


    /**
     * 条件构造器  删除操作
     */
    @Test
    public void testEntityWrapperDelete() {

        employeeMapper.delete(
                new EntityWrapper<Employee>()
                        .eq("last_name", "Tom")
                        .eq("age", 22)
        );
    }


    /**
     * 条件构造器  修改操作
     */
    @Test
    public void testEntityWrapperUpdate() {

        Employee employee = new Employee();
        employee.setLastName("苍老师");
        employee.setEmail("cls@sina.com");
        employee.setGender(0);


        employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                        .eq("last_name", "Tom")
                        .eq("age", 44)
        );
    }

    /**
     * 条件构造器   查询操作
     */
    @Test
    public void testEntityWrapperSelect() {
        //我们需要分页查询tbl_employee表中，年龄在18~50之间且性别为男且姓名为Tom的所有用户

//		List<Employee> emps =employeeMapper.selectPage(new Page<Employee>(1, 2),
//					new EntityWrapper<Employee>()
//					.between("age", 18, 50)
//					.eq("gender", 1)
//					.eq("last_name", "Tom")
//				);
//		System.out.println(emps);


        List<Employee> emps = employeeMapper.selectPage(
                new Page<Employee>(1, 2),
                Condition.create()
                        .between("age", 18, 50)
                        .eq("gender", "1")
                        .eq("last_name", "Tom")

        );

        System.out.println(emps);


        // 查询tbl_employee表中， 性别为女并且名字中带有"老师" 或者  邮箱中带有"a"

//		List<Employee> emps = employeeMapper.selectList(
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.like("last_name", "老师")
//				//.or()    // SQL: (gender = ? AND last_name LIKE ? OR email LIKE ?)
//				.orNew()   // SQL: (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
//				.like("email", "a")
//				);
//		System.out.println(emps);


        // 查询性别为女的, 根据age进行排序(asc/desc), 简单分页

//		List<Employee> emps  = employeeMapper.selectList(
//				new EntityWrapper<Employee>()
//				.eq("gender", 0)
//				.orderBy("age")
//				//.orderDesc(Arrays.asList(new String [] {"age"}))
//				.last("desc limit 1,3")
//				);
//		System.out.println(emps);

    }


    /**
     * 通用 删除操作
     */
    @Test
    public void testCommonDelete() {
        //1 .根据id进行删除
        Integer result = employeeMapper.deleteById(13);
        System.out.println("result: " + result);
        //2. 根据 条件进行删除
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "MP");
//		columnMap.put("email", "mp@atguigu.com");
//		Integer result = employeeMapper.deleteByMap(columnMap);
//		System.out.println("result: " + result );

        //3. 批量删除
//		List<Integer> idList = new ArrayList<>();
//		idList.add(3);
//		idList.add(4);
//		idList.add(5);
//		Integer result = employeeMapper.deleteBatchIds(idList);
//		System.out.println("result: " + result );
    }


    /**
     * 测试通用 查询操作
     */
    @Test
    public void testCommonSelect() {
        //1. 通过id查询
//		Employee employee = employeeMapper.selectById(7);
//		System.out.println(employee);

        //2. 通过多个列进行查询    id  +  lastName
//		Employee  employee = new Employee();
//		//employee.setId(7);
//		employee.setLastName("xx");
//		employee.setGender(0);
//
//		Employee result = employeeMapper.selectOne(employee);
//		System.out.println("result: " +result );


        //3. 通过多个id进行查询    <foreach>
//		List<Integer> idList = new ArrayList<>();
//		idList.add(4);
//		idList.add(5);
//		idList.add(6);
//		idList.add(7);
//		List<Employee> emps = employeeMapper.selectBatchIds(idList);
//		System.out.println(emps);

        //4. 通过Map封装条件查询
//		Map<String,Object> columnMap = new HashMap<>();
//		columnMap.put("last_name", "Tom");
//		columnMap.put("gender", 1);
//
//		List<Employee> emps = employeeMapper.selectByMap(columnMap);
//		System.out.println(emps);

        //5. 分页查询
        List<Employee> emps = employeeMapper.selectPage(new Page<>(1, 1), null);
        System.out.println(emps);
    }


    /**
     * 测试通用 更新操作
     */
    @Test
    public void testCommonUpdate() {
        //初始化修改对象
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("MybatisPlus");
        employee.setEmail("2222@qq.com");
        employee.setGender(0);
        employee.setAge(33);

//        Integer result = employeeMapper.updateById(employee);
        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println("result:" + result);

    }


    /**
     * 测试通用插入操作
     *
     * @throws SQLException
     */
    @Test
    public void testCommonInsert() {
        //初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("Geekerstar");
        employee.setEmail("247507792@qq.com");
        employee.setGender(1);
        employee.setAge(22);

        employee.setSalary(2000.0);
        //插入到数据库
        //Insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        //InsertAllColum方法在插入时，不管属性是否非空，属性所对应的字段都会出现到SQL语句中
        Integer result = employeeMapper.insert(employee);
        System.out.println("result:" + result);

        //获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key:" + key);


    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource ds = ioc.getBean("dataSource", DataSource.class);
        System.out.println(ds);

        Connection connection = ds.getConnection();
        System.out.println(connection);

    }
}
