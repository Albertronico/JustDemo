package com.just.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.just.bean.PhotoDTO;
import com.just.model.Photo;
import com.just.service.PhotoService;

/**
 * @author Alberto Sainz
 *
 */

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PhotoRestController {
	
	@Autowired
	PhotoService photoService; 
	
	@Autowired
    private ModelMapper modelMapper;
	
	public static final Logger logger = LoggerFactory.getLogger(PhotoRestController.class);

	/**
	 * Retrieve all photos.
	 * @return  List of photos.
	 */
	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	public ResponseEntity<List<PhotoDTO>> getAll() {
		logger.info("Retrive all Photos:");
		List<Photo> photos = photoService.findAll();
		List<PhotoDTO> photosResponse = new ArrayList<PhotoDTO>();
		for (Iterator<Photo> iterator = photos.iterator(); iterator.hasNext();) {
			PhotoDTO photoDTO = new PhotoDTO();
			Photo photo = (Photo) iterator.next();
			photoDTO = modelMapper.map(photo, PhotoDTO.class);
			photosResponse.add(photoDTO);
		}

		if (photos.isEmpty()) {
			return new ResponseEntity<List<PhotoDTO>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<PhotoDTO>>(photosResponse, HttpStatus.OK);
	}
	
	/**
	 * Retrieve photos by AlbumId
	 * @param albumId Id of Album
	 * @return List of photos.
	 */
	@RequestMapping(value = "/photos/{albumId}", method = RequestMethod.GET)
	public  ResponseEntity<List<PhotoDTO>>  getPhotoByAlbumId(@PathVariable Integer albumId) {
		logger.info("Retrive photos by albumId: " + albumId);
		PhotoDTO photoDTO = new PhotoDTO();
		
		List<Photo> photos = photoService.findPhotoByAlbumId(albumId);
		List<PhotoDTO> photosResponse = new ArrayList<PhotoDTO>();
		for (Iterator<Photo> iterator = photos.iterator(); iterator.hasNext();) {
			Photo photo = (Photo) iterator.next();
			photoDTO = modelMapper.map(photo, PhotoDTO.class);
			photosResponse.add(photoDTO);
		}

		if (photos.isEmpty()) {
			return new ResponseEntity<List<PhotoDTO>>(photosResponse, HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<PhotoDTO>>(photosResponse, HttpStatus.OK);
	}
		

	/**
	 * Create list of photos.
	 * @param photos list.
	 * @return size of photos list
	 */
	@RequestMapping(value = "/photos", method = RequestMethod.POST)
	public ResponseEntity<String> createPhotos(@RequestBody List<PhotoDTO> photos, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Photos : ", photos);
		Photo photo = new Photo();
		List<Photo> myphotos = new ArrayList<Photo>();

		for (Iterator<PhotoDTO> iterator = photos.iterator(); iterator.hasNext();) {
			PhotoDTO photoDTO = (PhotoDTO) iterator.next();
			photo = modelMapper.map(photoDTO, Photo.class);
			myphotos.add(photo);

		}
		photoService.saveAll(myphotos);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/photos").buildAndExpand().toUri());

		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
