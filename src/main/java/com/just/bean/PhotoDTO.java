package com.just.bean;

import java.io.Serializable;

/**
 * @author Alberto Sainz
 *
 */
public class PhotoDTO implements Serializable {

	/**
	 * Serial version.
	 */
	private static final long serialVersionUID = 5116703737932164599L;
	
	
	/**
	 * String: AlbumId.
	 */
	private Integer albumId;
	
	
	/**
	 * Integer: id.
	 */
	private Integer id;
	
	/**
	 * String: title.
	 */
	private String title;
	
	/**
	 * String: url.
	 */
	private String url;
	
	
	/**
	 * String: thumbnailUrl.
	 */
	private String thumbnailUrl;


	/**
	 * @return the albumId
	 */
	public Integer getAlbumId() {
		return albumId;
	}


	/**
	 * @param albumId the albumId to set
	 */
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
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


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * @return the thumbnaiUrl
	 */
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}


	/**
	 * @param thumbnaiUrl the thumbnaiUrl to set
	 */
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}


	@Override
	public String toString() {
		return "AlbumDTO [albumId=" + albumId + ", id=" + id + ", title=" + title + ", url=" + url + ", thumbnaiUrl="
				+ thumbnailUrl + "]";
	}
	
	}
