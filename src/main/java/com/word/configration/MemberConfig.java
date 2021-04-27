package com.word.configration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.word.DataBaseConnection;
import com.word.dao.StudentDao;
import com.word.service.EmsInforamationService;
import com.word.service.StudentRegisterService;

// xml 대신 java에서 스프링 설정
@Configuration
public class MemberConfig {

	// xml에서의 bean 객체 생성
	
	// 1.
	// <bean id=""studentDao" class="com.word.dao.StudentDao"/>
	
	// 메소드명 : bean태그의 ID 값 / 반환형 : 객체 (데이터 타입)
	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	//-------------------------------------------------------------------------
	
	// 2.
	//<bean id="registerService" class="com.word.service.StudentRegisterService">
	//<constructor-arg ref="studentDao" ></constructor>
	//</bean>
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	//-------------------------------------------------------------------------
	
	//3. 
	//<bean id="dataBaseConnectionInfo" class="com.word.DataBaseConnection">
	//<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe"/>
	//<property name="userId" value="scott"/>
	//<property name="userPwd" value="1234"/>
	//</bean>
	@Bean
	public DataBaseConnection dataBaseConnectionInfo() {
		DataBaseConnection dataBaseConnection = new DataBaseConnection();
		dataBaseConnection.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataBaseConnection.setUserId("scott");
		dataBaseConnection.setUserId("1234");
		
		return dataBaseConnection;
	}

	//-------------------------------------------------------------------------
	
	//4.
	
	@Bean
	public EmsInforamationService informantionService() {
		EmsInforamationService info = new EmsInforamationService();
		
		info.setInfo("aaaa");
		info.setCopyriggt("CCCCCCC");
		info.setVer("version2.0");
		info.setYear("2015");
		
		ArrayList<String> developers = new ArrayList<String>();
		developers.add("aa");
		developers.add("bb");
		
		info.setDevelopers(developers);
		
		Map<String,String> administrators = new HashMap<String,String>();
		administrators.put("aa","aaaaaa");
		administrators.put("bb","bbbbbb");
		
		info.setAdministrators(administrators);
		
		return info;
	}
}
