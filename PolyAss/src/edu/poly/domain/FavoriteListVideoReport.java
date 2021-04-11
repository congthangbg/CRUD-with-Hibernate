package edu.poly.domain;

import java.util.Date;

public class FavoriteListVideoReport {
	private String videoTitle;
	private Long favoritecount;
	private Date newestDate;
	private Date oldestDate;
	
	public FavoriteListVideoReport() {
		
	}
	public FavoriteListVideoReport(String videoTitle, Long favoritecount, Date newestDate, Date oldestDate) {
		this.videoTitle = videoTitle;
		this.favoritecount = favoritecount;
		this.newestDate = newestDate;
		this.oldestDate = oldestDate;
	}

	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public Long getFavoritecount() {
		return favoritecount;
	}
	public void setFavoritecount(Long favoritecount) {
		this.favoritecount = favoritecount;
	}
	public Date getNewestDate() {
		return newestDate;
	}
	public void setNewestDate(Date newestDate) {
		this.newestDate = newestDate;
	}
	public Date getOldestDate() {
		return oldestDate;
	}
	public void setOldestDate(Date oldestDate) {
		this.oldestDate = oldestDate;
	}
	@Override
	public String toString() {
		return "FavoriteListVideoReport [videoTitle=" + videoTitle + ", favoritecount=" + favoritecount
				+ ", newestDate=" + newestDate + ", oldestDate=" + oldestDate + "]";
	}
	
	
}
