package com.confetystudios.test.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UsuarioResult implements ResultSetExtractor<List<Usuario>> {

	@Override
	public List<Usuario> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Usuario> result = new ArrayList<>();
		while (rs.next()) {
			Usuario user = new Usuario();
			user.setId(rs.getInt("id"));
			result.add(user);
		}
		return result;
	}

}
