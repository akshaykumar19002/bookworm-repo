package com.bookworm.ebook.model;

import com.bookworm.ebook.entity.EbookEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ebook {

	private Integer id;

	private String booktitle;

	private String category;

	private String subcategory;

	private String publisher;

	private Double price;

	private String author;

	private String description;

	private String availability;

	private String[] actions;
	
	private String image;
	
	private String pdf;
	
	public String getPdf() {
		return pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBooktitle() {
		return booktitle;
	}

	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public String[] getActions() {
		return actions;
	}

	public void setActions(String[] actions) {
		this.actions = actions;
	}

	public static Ebook fromJson(String inputJson) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(inputJson, Ebook.class);
	}

	public EbookEntity convertToEntity() {
		EbookEntity ebook = new EbookEntity();
		ebook.setId(id);
		ebook.setBooktitle(booktitle);
		String ac = "";
		for(String action: actions)
			ac += action + ",";
		ac = ac.substring(0, ac.length()-1);
		ebook.setActions(ac);
		ebook.setAuthor(author);
		ebook.setAvailability(availability);
		ebook.setCategory(category);
		ebook.setDescription(description);
		ebook.setPrice(price);
		ebook.setPublisher(publisher);
		ebook.setSubcategory(subcategory);
		ebook.setImagePath(image);
		ebook.setPdfPath(pdf);
		return ebook;
	}

	@Override
	public String toString() {
		return "EbookModel [_id=" + id + ", booktitle=" + booktitle + ", category=" + category + ", subcategory="
				+ subcategory + ", publisher=" + publisher + ", price=" + price + ", author=" + author
				+ ", description=" + description + ", availability=" + availability + ", actions=" + actions + "]";
	}

}
