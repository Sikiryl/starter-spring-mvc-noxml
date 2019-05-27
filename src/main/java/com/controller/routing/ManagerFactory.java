package com.controller.routing;

public class ManagerFactory implements AutoCloseable {

	// use inner class for lazy initialization + thread safety
	// worth reading: https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
	private static class SingletonHelper {
        private static final ManagerFactory INSTANCE = new ManagerFactory();
    }
	
	public static ManagerFactory getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	public static void destroy() {
		try { SingletonHelper.INSTANCE.close(); } catch (Exception ex) {
		}
	}
	
	@Override
	public void close() throws Exception {
	}
	
	private ManagerFactory() {
	}


}
