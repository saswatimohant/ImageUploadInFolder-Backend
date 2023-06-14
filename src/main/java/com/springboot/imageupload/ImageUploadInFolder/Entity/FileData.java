package com.springboot.imageupload.ImageUploadInFolder.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="filedata")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name="name")
    
	private String name;
    
	@Column(name="type")
	
	private String type;
	
	@Column(name="filePath" )
	
	private String filePath;

}
