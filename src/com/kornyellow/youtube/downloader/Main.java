package com.kornyellow.youtube.downloader;

import com.kornyellow.lib.console.CommandConsole;
import com.kornyellow.youtube.downloader.commands.*;

public class Main {
	public static void main(String[] args) {
		CommandConsole console = new CommandConsole();
		
		console.setGreetingMessage("======================================================");
		console.addGreetingMessage(" Youtube Downloader version 1.0 MIT License 2024 korn ");
		console.addGreetingMessage("     built with IntelliJ IDEA.                        ");
		console.addGreetingMessage("======================================================");
		console.addGreetingMessage("type 'help' to see all available commands.");
		
		console.setFarewellMessage("Exiting...");
		
		console.registerCommand("add [youtube-link]", "to add YouTube link to the queue.", new Add());
		console.registerCommand("remove [index]", "to remove YouTube link from the queue at index.", new Remove());
		console.registerCommand("list", "to list all youtube links in the queue.", new List());
		console.registerCommand("clear", "to clear all youtube links in the queue.", new Clear());
		console.registerCommand("download", "to download all youtube links in the queue.", new Download());
		
		console.start();
	}
}