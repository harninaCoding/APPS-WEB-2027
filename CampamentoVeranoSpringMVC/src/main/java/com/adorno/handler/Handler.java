package com.adorno.handler;

import java.sql.ResultSet;

public interface Handler<T> {
	T transform(ResultSet resultSet);
}
