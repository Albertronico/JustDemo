package com.just.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.just.model.Photo;
import com.just.repositories.PhotoRepository;

/**
 * Class Photo Service Implement.
 * @author Alberto Sainz
 *
 */
@Service("photoService")
@Transactional
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	public PhotoRepository photoRepo;

	@Override
	public List<Photo> findAll() {
		return photoRepo.findAll();
	}

	@Override
	public List<Photo> findPhotoByAlbumId(Integer albumId) {
		return photoRepo.findPhotoByAlbumId(albumId);
	}

	@Override
	public void saveAll(List<Photo> photos) {
		 photoRepo.saveAll(photos);
		
	}

	@Override
	public Photo save(Photo photos) {
		return photoRepo.save(photos);
		
	}

}
