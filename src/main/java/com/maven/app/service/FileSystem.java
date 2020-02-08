package com.maven.app.service;

public interface FileSystem {

	public void mkdir(String path);
	
	public void cd(String path);
	
	public void touch(String path);
	
	public void rm(String... path);
	
	public String pwd();
	
	public Iterable<String> ls(String... filePath);
}
