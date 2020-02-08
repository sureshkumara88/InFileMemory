package com.maven.app.executor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppExecutorTest extends TestCase
{	

	@Before
	public void beforeEachTest() {
		System.out.println("This is executed before each Test");
	}

	@After
	public void afterEachTest() {
		System.out.println("This is exceuted after each Test");
	}

	@Test
	public static void testSum() {
		String[] args = {"mkdir,/a/b/c", "ls,a", "pwd", "touch,/a/b/c/d", "cd,a", "rm,d"};
		AppExecutor.main(args);		
	}
}
