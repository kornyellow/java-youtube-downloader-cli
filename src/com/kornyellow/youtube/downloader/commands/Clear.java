package com.kornyellow.youtube.downloader.commands;

import com.kornyellow.lib.console.CommandExecutor;
import com.kornyellow.youtube.downloader.queue.DownloadQueue;

public class Clear implements CommandExecutor {
	@Override
	public void execute(String[] parameters) {
		int clearCount = DownloadQueue.getQueues().size();
		DownloadQueue.clearQueue();
		System.out.println("Queue was being cleared. Removed " + clearCount + " YouTube link(s) from queue.");
	}
}
