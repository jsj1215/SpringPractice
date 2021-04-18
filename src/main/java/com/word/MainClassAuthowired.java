package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.word.service.WordRegisterService;
import com.word.service.WordSearchService;

public class MainClassAuthowired {
	
	public static void main(String[] args) {
		
		String[] keyWords= {"c","c++","java","jsp","spring"};
		String[] values= {"c 설명",
				"c++ 설명",
				"java 설명",
				"jsp 설명",
				"spring 설명"
		};
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtxUseAutowired.xml");
		
		WordRegisterService registerService = 
				ctx.getBean("registerService", WordRegisterService.class);
		
		for (int i = 0; i < values.length; i++) {
			WordSet wordSet = new WordSet(keyWords[i],values[i]);
			registerService.register(wordSet);
		}
		
		WordSearchService searchService = 
				ctx.getBean("searchService", WordSearchService.class);
		
		System.out.println("\n\n==============");
		for(int i=0; i<keyWords.length; i++) {
			WordSet wordSet = searchService.searchWord(keyWords[i]);
			System.out.println(wordSet.getWordKey() + "\t : ");
			System.out.println(wordSet.getWordValue());
			System.out.println("--------------------------");
		}
		System.out.println("\n\n");
		ctx.close();
	}

}
