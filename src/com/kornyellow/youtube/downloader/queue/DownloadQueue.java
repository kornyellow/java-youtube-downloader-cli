package com.kornyellow.youtube.downloader.queue;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DownloadQueue {
	private static final ArrayList<Queue> queues = new ArrayList<>();
	
	public static void clearQueue() {
		queues.clear();
	}
	public static ArrayList<Queue> getQueues() {
		return queues;
	}
	
	public static boolean tryAddQueue(String youtubeLink) {
		String youtubeID = tryGetYoutubeID(youtubeLink);
		if (youtubeID.isEmpty())
			return false;
		
		queues.add(new Queue(youtubeID));
		return true;
	}
	
	public static String tryGetYoutubeID(String youtubeLink) {
		try {
			URL url = new URI(youtubeLink).toURL();
			
			String hostname = url.getHost();
			String path = url.getPath();
			
			if ("www.youtube.com".equals(hostname) && "/watch".equals(path)) {
				Map<String, String> params = getQueryParams(url.getQuery());
				if (params.containsKey("v"))
					return params.get("v");
			} else if ("youtu.be".equals(hostname))
				return path.substring(1);
			
		} catch (Exception e) {
			return "";
		}
		return "";
	}
	
	private static Map<String, String> getQueryParams(String query) {
		Map<String, String> params = new HashMap<>();
		if (query == null)
			return params;
		
		String[] pairs = query.split("&");
		for (String pair : pairs) {
			String[] keyValue = pair.split("=");
			if (keyValue.length == 2)
				params.put(keyValue[0], keyValue[1]);
		}
		
		return params;
	}
	
	public static void downloadFromID(String videoId) {
		try {
			String youtubeLink = "https://www.youtube.com/watch?v=" + videoId;
			URL url = new URI(youtubeLink).toURL();
			
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			
			InputStream inputStream = connection.getInputStream();
			
			String outputFilePath = "downloaded_video.mp4";
			OutputStream outputStream = new FileOutputStream(outputFilePath);

			byte[] buffer = new byte[4096];
			int bytesRead;

			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outputStream.close();
			
			System.out.println("Video downloaded successfully to: " + outputFilePath);
			
		} catch (Exception e) {
			System.out.println("Error downloading video.");
			System.out.println(e.getMessage());
		}
	}
}
