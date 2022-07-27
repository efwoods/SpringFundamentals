package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringFundamentalsApplicationTests {
	@Autowired
	private ApplicationContext ctx;

	@Autowired @Qualifier("defaultCurrencyFormat")
	private NumberFormat nf;

	@Test
	public void defaultCurrency() {
		double amount = 1234.9823749;
		System.out.println(nf.format(amount));
	}

	@Test
	public void germanCurrency() {
		NumberFormat deutschNF = ctx.getBean("germanCurrencyFormat", NumberFormat.class);
		double amount = 1234.9823749;
		System.out.println(deutschNF.format(amount));
	}

	@Test
	void contextLoads() {
		int count = ctx.getBeanDefinitionCount();
		System.out.println("There are " + count + " beans in the application context");
		for (String name : ctx.getBeanDefinitionNames()){
			System.out.println(name);
		}
	}

}
