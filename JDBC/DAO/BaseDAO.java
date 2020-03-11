package JDBC.DAO;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import JDBC.Util.JDBCUtils;

/*
 * 封装针对数据表的通用操作
 */

public abstract class BaseDAO<T> {

	private Class<T> cla = null;
	
	{
		//获取当前的子类继承的带泛型的父类
		Type genericSuperclass = this.getClass().getGenericSuperclass();	
		ParameterizedType paramType = (ParameterizedType) genericSuperclass;
		Type[] typeArguments = paramType.getActualTypeArguments();	//获取夫类的泛型
		cla = (Class<T>) typeArguments[0];	//泛型的第一个参数
	}
	
	// 通用的增删改操作
	public int Update(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps);
		}
		return 0;
	}

	// 通用的查询操作（返回一条记录）
	public T getInstance(Connection connection, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			resultSet = ps.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			if (resultSet.next()) {
				T t = cla.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columValue = resultSet.getObject(i + 1);
					Field field = cla.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		return null;
	}

	// 通用的查询操作（返回多条记录构成的集合）
	public List<T> getForList(Connection connection, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			resultSet = ps.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			List<T> list = new ArrayList<T>();
			while (resultSet.next()) {
				T t = cla.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columValue = resultSet.getObject(i + 1);
					Field field = cla.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		return null;
	}

	//查询特殊值的通用方法
	public <E> E getValue(Connection connection, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			resultSet = ps.executeQuery();
			if (resultSet.next())
				return (E) resultSet.getObject(1);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		return null;
	}

}
