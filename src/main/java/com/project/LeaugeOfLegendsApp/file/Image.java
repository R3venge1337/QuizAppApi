package com.project.LeaugeOfLegendsApp.file;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "images")
@Data
@NoArgsConstructor
public class Image {
	
	@Id
	private String id;
	
	private String imageName;
	
    private Binary imageFile;

	public Image(String imageName) {
		this.imageName = imageName;
	}

	public Image(String imageName, Binary imageFile) {
		this.imageName = imageName;
		this.imageFile = imageFile;
	}
	
	
}
