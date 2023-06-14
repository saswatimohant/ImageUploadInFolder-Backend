package com.springboot.imageupload.ImageUploadInFolder.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.imageupload.ImageUploadInFolder.Entity.ImageData;

public interface Storagerepositary extends JpaRepository<ImageData, Long>{
	
	Optional<ImageData>findByName(String fileName);

}
