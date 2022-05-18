package com.bookworm.ebook.service.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.bookworm.ebook.service.EbookService;
import com.bookworm.ebook.service.LendService;
import com.bookworm.ebook.service.RentService;

@Component
public class ServiceLocator implements ApplicationContextAware{
	
	public static ApplicationContext context;
	
	public static EbookService getEbookService() {
		return (EbookService) context.getBean("ebookService");
	}
	
	public static RentService getRentService() {
		return (RentService) context.getBean("rentService");
	}
	
	public static LendService getLendService() {
		return (LendService) context.getBean("lendService");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
		
	}

}
