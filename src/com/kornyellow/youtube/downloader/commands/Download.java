package com.kornyellow.youtube.downloader.commands;

import com.kornyellow.lib.console.CommandExecutor;
import com.kornyellow.youtube.downloader.queue.DownloadQueue;

public class Download implements CommandExecutor {
	@Override
	public void execute(String[] parameters) {
		DownloadQueue.downloadFromID(DownloadQueue.getQueues().getFirst().getYoutubeID());
	}
}
