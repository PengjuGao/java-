package com.platform.base.utils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class JSONTypeHandler<T> extends BaseTypeHandler<T> {

	@Override
	public T getNullableResult(ResultSet rs, String coluname) throws SQLException {

		return null;
	}

	@Override
	public T getNullableResult(ResultSet rs, int i) throws SQLException {
		return null;
	}

	@Override
	public T getNullableResult(CallableStatement cs, int i)
			throws SQLException {
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, T obj,
			JdbcType type) throws SQLException {
	}

}
