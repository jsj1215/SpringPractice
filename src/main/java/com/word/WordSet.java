package com.word;

public class WordSet {

	private String wordKey;
	private String wordValue;
	
	public WordSet(String wordKey, String wordVaue) {
		this.wordKey = wordKey;
		this.wordValue = wordVaue;
	}
	
	public String getWordKey() {
		return wordKey;
	}

	public void setWordKey(String wordKey) {
		this.wordKey = wordKey;
	}
	
	public String getWordValue() {
		return wordValue;
	}
	
	public void setWordValue(String wordValue) {
		this.wordValue = wordValue;
	}
	
}
