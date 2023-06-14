package com.springboot.imageupload.ImageUploadInFolder.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.imageupload.ImageUploadInFolder.Entity.FileData;
import com.springboot.imageupload.ImageUploadInFolder.Entity.ImageData;

public interface FileDataRepository extends JpaRepository<FileData, Long>{

	Optional<FileData> findByName(String fileName);

}
