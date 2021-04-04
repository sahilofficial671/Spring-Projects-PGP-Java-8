package com.wiley.dao;

import java.util.List;

import com.wiley.model.Author;

public interface AuthorDao {
	public Boolean add(Author author);
	public List<Author> getAuthors();
}
