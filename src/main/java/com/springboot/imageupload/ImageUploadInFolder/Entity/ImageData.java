package com.springboot.imageupload.ImageUploadInFolder.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="imagedata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="name")
    
	private String name;
    
	@Column(name="type")
	
	private String type;
	@Lob
	@Column(name="imagedata" )
	private byte[] imageData;
	
}
