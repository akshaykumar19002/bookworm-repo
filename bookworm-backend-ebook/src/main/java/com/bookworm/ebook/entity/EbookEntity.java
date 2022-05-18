package com.bookworm.ebook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bookworm.ebook.model.Ebook;

@Entity
@Table(name = "ebooks")
public class EbookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String booktitle;
	
	private String category;
	
	private String subcategory;
	
	private String publisher;
	
	private Double price;
	
	private String author;
	
	private String description;
	
	private String availability;
	
	private String actions;
	
	@Column(name = "img")
	private String imagePath;
	
	@Column(name = "pdf")
	private String  pdfPath;

	public String getPdfPath() {
		return pdfPath;
	}

	public void setPdfPath(String pdfPath) {
		this.pdfPath = pdfPath;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}
	
	public Ebook convertToModel() {
		Ebook ebook = new Ebook();
		ebook.setId(id);
		ebook.setBooktitle(booktitle);
		ebook.setActions(actions.split(","));
		ebook.setAuthor(author);
		ebook.setAvailability(availability);
		ebook.setCategory(category);
		ebook.setDescription(description);
		ebook.setPrice(price);
		ebook.setPublisher(publisher);
		ebook.setSubcategory(subcategory);
		ebook.setImage(imagePath);
		ebook.setPdf(pdfPath);
		return ebook;
	}

	@Override
	public String toString() {
		return "EbookEntity [id=" + id + ", booktitle=" + booktitle + ", category=" + category + ", subcategory="
				+ subcategory + ", publisher=" + publisher + ", price=" + price + ", author=" + author
				+ ", description=" + description + ", availability=" + availability + ", actions=" + actions + "]";
	}
}
