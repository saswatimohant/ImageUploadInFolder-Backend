package com.springboot.imageupload.ImageUploadInFolder.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.imageupload.ImageUploadInFolder.Entity.FileData;
import com.springboot.imageupload.ImageUploadInFolder.Entity.ImageData;
import com.springboot.imageupload.ImageUploadInFolder.Repositary.FileDataRepository;
import com.springboot.imageupload.ImageUploadInFolder.Repositary.Storagerepositary;
import com.springboot.imageupload.ImageUploadInFolder.Util.ImageUtils;

@Service
public class StrorageService {
	
	@Autowired
	private Storagerepositary repositary;
	
	@Autowired
	private FileDataRepository fileDataRepository;
	
	private final String folder="C:\\Users\\rajavisek\\Desktop\\UploadFile\\";
	
	public String uploadImage(MultipartFile file) throws IOException {
		
		ImageData imageData=repositary.save(ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build());
		   if(imageData!= null) {
			   return "file is uplopaded succesfully:" + file.getOriginalFilename();
		   }
		   
		   return null;
	}
	
	public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repositary.findByName(fileName);
         byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
	
	public String uploadImageToFileSystem(MultipartFile file) throws IOException {
		String filepath=folder+file.getOriginalFilename();
		FileData filedata=fileDataRepository.save(FileData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.filePath(filepath).build());
		file.transferTo(new File(filepath));
		 if(filedata!= null) {
			   return "file is uplopaded succesfully:" + filepath;
		   }
		   
		   return null;
	}
	
	
	public byte[] downloadImageFromFileSystem(String fileName) throws IOException{
		Optional<FileData>fileData=fileDataRepository.findByName(fileName);
		String filePath=fileData.get().getFilePath();
		byte[] images=Files.readAllBytes(new File(filePath).toPath());
		return images;
    }
	
	
	
	
}
