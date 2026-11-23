package com.adorno.mapper;

public interface Mapper<S, T> {
	public T map(S s);

	public Object[] toInsertParams(T t);
}
