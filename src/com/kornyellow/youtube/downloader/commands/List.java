package com.kornyellow.youtube.downloader.commands;

import com.kornyellow.lib.console.CommandExecutor;
import com.kornyellow.youtube.downloader.queue.DownloadQueue;
import com.kornyellow.youtube.downloader.queue.Queue;

public class List implements CommandExecutor {
	@Override
	public void execute(String[] parameters) {
		if (DownloadQueue.getQueues().isEmpty()) {
			System.out.println("Queue is currently empty.");
			return;
		}
		
		int queueIndex = 0;
		for (Queue queue : DownloadQueue.getQueues()) {
			System.out.print((queueIndex + 1) + ": ");
			System.out.print("https://youtube.com/watch?v=" + queue.getYoutubeID());
			System.out.println();
			
			queueIndex ++;
		}
	}
}
