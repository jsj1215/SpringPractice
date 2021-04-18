package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {

	// 프로퍼티나 메소드에 Autowired부여하려면,
	// 반드시 기본 생성자 명시해야 함.
	//@Autowired(required = false)
	//@Qualifier("usedDao")
	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;
	
	public  WordRegisterService() {

	}
	
	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		}else {
			System.out.println("이미 등록되었습니다.");
		}
	}
	
	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
	public void setWordDao(WordDao wrodDao) {
		this.wordDao = wordDao;
	}
	
	
}
