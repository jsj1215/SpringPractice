package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchService {

	@Autowired
	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordSearchService() {
		
	}
	
	public WordSearchService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		}else {
			System.out.println("사용할 수 없습니다.");
		}
		return null;
	}
	
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null? true : false;
	}
	
	public void setWordDao(WordDao wrodDao) {
		this.wordDao = wordDao;
	}
}
