package com.just.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.just.model.Photo;

/**
 * Interface Repository Photo
 * @author Alberto Sainz
 *
 */
@Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
	
	List<Photo> findAll();
	
	List<Photo> findPhotoByAlbumId(Integer albumId);
	
		

}
