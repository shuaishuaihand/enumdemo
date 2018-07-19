package com.agesun.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.agesun.mybatis.bean.EmpsStatus;



/*
 * 实现TypeHandler,或者继承BaseTypeHandler 
 * 
 * */
public class MyEnumEmpStatusTypeHandler implements TypeHandler<EmpsStatus>{

	/*
	 * 定义当前数据如何保存到数据库中
	 * */
	@Override
	public void setParameter(PreparedStatement ps, int i, EmpsStatus parameter,
			JdbcType arg3) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("要保存的状态码"+parameter.getCode());
		 ps.setString(i, parameter.getCode().toString());
	}
	
	
	@Override
	public EmpsStatus getResult(ResultSet rs, String columnName)
			throws SQLException {
		//需要根据从数据库拿到的枚举的状态码返回一个枚举对象
	    int code=	rs.getInt(columnName);
	    System.out.print("从数据库中获得的状态码"+code);
	    EmpsStatus status=EmpsStatus.getEmpStatusByCode(code);
		return status;
	}

	@Override
	public EmpsStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		  int code=	rs.getInt(columnIndex);
		    System.out.print("从数据库中获得的状态码"+code);
		    EmpsStatus status=EmpsStatus.getEmpStatusByCode(code);
			return status;
	}

	@Override
	public EmpsStatus getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		    int code=	cs.getInt(columnIndex);
		    System.out.print("从数据库中获得的状态码"+code);
		    EmpsStatus status=EmpsStatus.getEmpStatusByCode(code);
			return status;
	}

	

}
