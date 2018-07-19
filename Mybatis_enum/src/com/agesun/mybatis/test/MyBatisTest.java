package com.agesun.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.agesun.mybatis.bean.Employee;
import com.agesun.mybatis.bean.EmpsStatus;
import com.agesun.mybatis.dao.EmployeeMapper;



/**
 * 1、接口式编程
 * 	原生：		Dao		====>  DaoImpl
 * 	mybatis：	Mapper	====>  xxMapper.xml
 * 
 * 2、SqlSession代表和数据库的一次会话；用完必须关闭；
 * 3、SqlSession和connection一样她都是非线程安全。每次使用都应该去获取新的对象。
 * 4、mapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象。
 * 		（将接口和xml进行绑定）
 * 		EmployeeMapper empMapper =	sqlSession.getMapper(EmployeeMapper.class);
 * 5、两个重要的配置文件：
 * 		mybatis的全局配置文件：包含数据库连接池信息，事务管理器信息等...系统运行环境信息
 * 		sql映射文件：保存了每一个sql语句的映射信息：
 * 					将sql抽取出来。	
 * 
 * 
 * @author nishuai
 *
 */
public class MyBatisTest {
	

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 1、根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象 有数据源一些运行环境信息
	 * 2、sql映射文件；配置了每一个sql，以及sql的封装规则等。 
	 * 3、将sql映射文件注册在全局配置文件中
	 * 4、写代码：
	 * 		1）、根据全局配置文件得到SqlSessionFactory；
	 * 		2）、使用sqlSession工厂，获取到sqlSession对象使用他来执行增删改查
	 * 			一个sqlSession就是代表和数据库的一次会话，用完关闭
	 * 		3）、使用sql的唯一标志来告诉MyBatis执行哪个sql。sql都是保存在sql映射文件中的。
	 * 
	 * @throws IOException
	 */


	/*
	 * 默认myabtis在处理枚举对象的时候，保存的是枚举的名字，EnumTypeHandler
	 * 改变使用 EnumOrdinalTypeHandler
	 * */
	
	@Test
	public void testEnum()throws IOException{
		SqlSessionFactory sqlSessionFactory= getSqlSessionFactory();
		SqlSession openSession= sqlSessionFactory.openSession();
		
		try{
		   EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
		   Employee employee=new Employee("test_enum","enum@agesun.com","1");
		   mapper.addEmp(employee);
		   System.out.println("保存成功！"+employee.getId());
		   
		   Employee emp=mapper.getEmpById(employee.getId());
		   System.out.println(emp.getLastName());
		   System.out.println(emp.getEmpsStatus().getMsg());
			openSession.commit();
		}finally{
			openSession.close();
		}
	}
	
	@Test
	public void testEnumUse(){
		EmpsStatus empsStatus=EmpsStatus.LOGIN;
		System.out.println("枚举的索引"+empsStatus.ordinal());
		System.out.println("枚举的名字"+empsStatus.name());
		
		System.out.println("枚举的状态码："+empsStatus.getCode());
		System.out.println("枚举的提示消息："+empsStatus.getMsg());
		
	}
	
	
	@Test
	public void testEnumStaus()throws IOException{
		SqlSessionFactory sqlSessionFactory= getSqlSessionFactory();
		SqlSession openSession= sqlSessionFactory.openSession();
		
		try{
		   EmployeeMapper mapper=openSession.getMapper(EmployeeMapper.class);
		   List<Employee> emplist=  mapper.getEmps();
		   Employee emp=new Employee();
		 //利用枚举类，对员工登录状态类型字段进行翻译
		     EmpsStatus empsStatus=null;
	         for(int i=0;i<emplist.size();i++){
	        	 emp=emplist.get(i);
	        	 empsStatus= empsStatus.getEmpEnum(Integer.parseInt(emp.getEmpstsus()));
	        	 System.out.println("code"+Integer.parseInt(emp.getEmpstsus()));
	        	 System.out.println("msg1"+empsStatus.getMsg());
	            if(empsStatus!=null) {
	                emp.setEmpstsus(empsStatus.getMsg());
	                System.out.println("msg2"+empsStatus.getMsg());
	            }
	         }
	         
		     for (Employee employee : emplist) {
			     System.out.println(employee);
		      }
			
		
			/*openSession.commit();*/
		}finally{
			openSession.close();
		}
	}
	
	
	
	
	

}
