package model;

import java.util.Date;


public class TechTonics {
	private int id;
	private java.util.Date presentationDate;
	private String title;
	private String description;
	private String presenterName;
	
	
	
	public TechTonics(int id, Date presentationDate, String title,
			String description, String presenterName) {
		super();
		this.id = id;
		this.presentationDate = presentationDate;
		this.title = title;
		this.description = description;
		this.presenterName = presenterName;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	public java.util.Date getPresentationDate() {
		return presentationDate;
	}



	public void setPresentationDate(java.util.Date presentationDate) {
		this.presentationDate = presentationDate;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getPresenterName() {
		return presenterName;
	}



	public void setPresenterName(String presenterName) {
		this.presenterName = presenterName;
	}



	@Override
	public String toString() {
		return "TechTonics [id=" + id + ", presentationDate="
				+ presentationDate + ", title=" + title + ", description="
				+ description + ", presenterName=" + presenterName + "]";
	}

	
	
	
	

}
