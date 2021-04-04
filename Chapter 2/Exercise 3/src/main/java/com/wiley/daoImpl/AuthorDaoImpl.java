package com.wiley.daoImpl;

import java.util.List;

import com.wiley.dao.AuthorDao;
import com.wiley.data.Data;
import com.wiley.model.Author;

public class AuthorDaoImpl implements AuthorDao{
	Data data;
	
	public AuthorDaoImpl() {
		data = Data.get();
	}

	@Override
	public Boolean add(Author author) {
		return data.getAuthorList().add(author);
	}
	
	public List<Author> getAuthors(){
		return data.getAuthorList();
	}
}
