package com.just;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.just.bean.PhotoDTO;
import com.just.controller.PhotoRestController;
import com.just.model.Photo;
import com.just.repositories.PhotoRepository;
import com.just.service.PhotoService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired 
	private PhotoRestController photoRestController;
	
	@MockBean
	private PhotoService photoService;

	@Test
	void contextLoads() throws Exception{
		assertThat(photoRestController).isNotNull();
	}
	
	@Test
	public void testCreatePhotos() throws Exception {
		 PhotoDTO photoDTO = new PhotoDTO();
		 Photo photo = new Photo();
		 List<Photo> photosList= new ArrayList<Photo>(); 
		 
		 photoDTO.setId(45);
		 photoDTO.setAlbumId(5);
		 photoDTO.setTitle("nemo eaque facilis corporis occaecati autem ut");
		 photoDTO.setUrl("https://via.placeholder.com/600/53e4b9\"");
		 photoDTO.setThumbnailUrl("https://via.placeholder.com/600/53e4b9\"");
		 		    
		 photo = modelMapper.map(photoDTO, Photo.class);  
		 photosList.add(photo);		 
		 
		 when(photoService.findAll()).thenReturn(photosList);
	 	     
	    this.mockMvc
	        .perform(post("/api/photos")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content("[{\"id\":"+ 100 + ",\"albumId\":"+ 50 + ",\"title\": \"mi título\",\"url\": \"https://via.placeholder.com/600/53e4b9\", \"thumbnaiUrl\": \"https://via.placeholder.com/600/53e4b9\"}]")
	            )
	        .andExpect(status().isCreated())
	        .andExpect(header().exists("Location"))
	        .andExpect(header().string("Location", containsString(
	                "http://localhost/api/photos"))).andDo(print());
	}
	
	

}
