package com.confetystudios.test.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.confetystudios.test.dto.GenericErrorResponse;
import com.confetystudios.test.dto.GenericResponse;

@RestController
@RequestMapping("/prueba")
public class Test {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping
	public List<Usuario> test() {
		List<String> params = new LinkedList<>();
		List<Usuario> rs = jdbcTemplate.query("Select * from Usuario", new UsuarioResult() /** , params */
		);

		return rs;
	}

	@PostMapping
	public ResponseEntity<?> insert() {
		try {
//			METODO 1
//			PreparedStatementSetter use = new PreparedStatementSetter() {
//				public void setValues(PreparedStatement preparedStatement) throws SQLException {
//					preparedStatement.setInt(1, 12222);
//				}
//			};
//			int response = jdbcTemplate.update("INSERT INTO Usuario VALUES ( ? )", use);
			int response = jdbcTemplate.update("INSERT INTO Usuario VALUES ( ? )", "s"+22221 );

			return new ResponseEntity<GenericResponse>(new GenericResponse(HttpStatus.OK , "[" + response + "]"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<GenericErrorResponse>(
					new GenericErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().toString(), e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
