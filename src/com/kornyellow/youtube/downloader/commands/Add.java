package com.kornyellow.youtube.downloader.commands;

import com.kornyellow.lib.console.CommandExecutor;
import com.kornyellow.youtube.downloader.queue.DownloadQueue;

public class Add implements CommandExecutor {
	@Override
	public void execute(String[] parameters) {
		if (parameters.length != 1 || parameters[0].isEmpty()) {
			System.out.println("Please provide a valid YouTube link.");
			System.out.println("* add [youtube-link]");
			return;
		}
		
		String youtubeLink = parameters[0];
		if (!DownloadQueue.tryAddQueue(youtubeLink)) {
			System.out.println(youtubeLink + " is invalid. Please provide a valid YouTube link.");
			return;
		}
		System.out.println("Added Youtube link to queue.");
	}
}
