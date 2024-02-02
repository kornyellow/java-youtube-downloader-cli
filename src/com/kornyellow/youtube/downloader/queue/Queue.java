package com.kornyellow.youtube.downloader.queue;

public class Queue {
	private String youtubeID;
	
	public String getYoutubeID() {
		return this.youtubeID;
	}
	public void setYoutubeID(String youtubeID) {
		this.youtubeID = youtubeID;
	}
	
	public Queue(String youtubeID) {
		this.youtubeID = youtubeID;
	}
}
