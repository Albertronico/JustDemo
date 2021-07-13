package com.just.bean;

import java.io.Serializable;

/**
 * @author Alberto Sainz
 *
 */
public class AlbumDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 5116703737932164599L;
	
	
	/**
	 * String: AlbumId.
	 */
	private Integer userId;
	
	
	/**
	 * Integer: id.
	 */
	private Integer id;
	
	/**
	 * String: title.
	 */
	private String title;
	

	/**
	 * @return the albumId
	 */
	public Integer getAlbumId() {
		return userId;
	}


	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(Integer albumId) {
		this.userId = albumId;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}


	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	@Override
	public String toString() {
		return "AlbumDTO [userId=" + userId + ", id=" + id + ", title=" + title + "]";
	}
	
	


}	