package com.just.service;

import java.util.List;

import com.just.model.Photo;

/**
 * Interface Photo Service.
 * @author Alberto Sainz
 *
 */
public interface PhotoService {
	
	/**
	 * Retrieve all photos
	 * @return List of photos 
	 */
	List<Photo>  findAll();
	
	/**
	 * Retrieve photos by albumId
	 * @param albumId
	 * @return List of photos by albumId
	 */
	List<Photo> findPhotoByAlbumId(Integer albumId);
	
	
	/**
	 * Save photos list
	 * @param photos
	 */
	void saveAll(List<Photo> photos);

	/**
	 * Save a photo
	 * @param photos
	 * @return photo to saved
	 */
	Photo save(Photo photos);
	
	
}
