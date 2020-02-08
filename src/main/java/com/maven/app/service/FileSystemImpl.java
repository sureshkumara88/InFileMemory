package com.maven.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystemImpl implements FileSystem {

	class Dir {
        Map<String, Dir> dirs = new HashMap<>();
        Map<String, String> files = new HashMap<>();
    }
    
    Dir root;
    
    public FileSystemImpl() {
        root = new Dir();
    }
    
	@Override
	public void mkdir(String path) {
        Dir t = root;
        String[] d = path.split("/");
        for (int i = 1; i < d.length; i++) {
            if (!t.dirs.containsKey(d[i]))
                t.dirs.put(d[i], new Dir());
            t = t.dirs.get(d[i]);
        }
    }

	@Override
	public void cd(String path) {
		 Dir t = root;
		 String[] d = path.split("/");
		 for (int i = 1; i < d.length; i++) {
		 	t = t.dirs.get(d[i]);
		 }				 
	}

	@Override
	public void touch(String path) {
		 Dir t = root;
	        String[] d = path.split("/");
	        for (int i = 1; i < d.length - 1; i++) {
	            t = t.dirs.get(d[i]);
	        }
	        t.files.put(d[d.length - 1], t.files.getOrDefault(d[d.length - 1], "") );		
	}

	@Override
	public void rm(String... path) {
		 Dir t = root;
	        String[] d = path;
	        for (int i = 1; i < d.length; i++) {
	            if (t.dirs.containsKey(d[i]))
	                t.dirs.remove(d[i]);	           
	        }		
	}

	@Override
	public String pwd() {
		 Dir t = root;
		 String pwd = "";
		 for(String data : t.dirs.keySet()) {
			 pwd = "/" + data;
		 }		
		return pwd;
	}

	@Override
	public Iterable<String> ls(String... filePath) {

        Dir t = root;
        List < String > files = new ArrayList < > ();
        
        String[] d = filePath;
        for (int i = 1; i < d.length - 1; i++) {
        	t = t.dirs.get(d[i]);
        }
        if (t.files.containsKey(d[d.length - 1])) {
        	files.add(d[d.length - 1]);
        	return files;
        } else {
        	t = t.dirs.get(d[d.length - 1]);
        }
        
        files.addAll(new ArrayList < > (t.dirs.keySet()));
        files.addAll(new ArrayList < > (t.files.keySet()));
        Collections.sort(files);
        return files;
    
	}
	
}
