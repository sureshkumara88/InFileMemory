package com.maven.app.executor;

import com.maven.app.service.FileSystem;
import com.maven.app.service.FileSystemImpl;

public class AppExecutor {

	public static void main(String[] args) {		
		FileSystem service = new FileSystemImpl();

		for (String arg : args) {
			String[] arr = arg.split(",");
			if(arr[0].equals("mkdir")) {
				service.mkdir(arr[1]);
			} else if(arr[0].equals("ls")) {
				String[] params = arr[1].split(":");
				Iterable<String> files = service.ls(params);
				files.forEach(f -> System.out.println(f));
			} else if(arr[0].equals("cd")) {
				service.cd(arr[1]);
			} else if(arr[0].equals("touch")) {
				service.touch(arr[1]);
			} else if(arr[0].equals("pwd")) {
				service.pwd();
			} else if(arr[0].equals("rm")) {
				String[] params = arr[1].split(":");
				service.rm(params);
			}
		}

	}

}
