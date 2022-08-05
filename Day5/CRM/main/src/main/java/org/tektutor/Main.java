package org.tektutor;

public class Main {

	public String getModuleName() {
		return "Main module";
	}

	public static void main ( String[] args ) {
			
		Frontend fe = new Frontend();
		BusinessLayer bl = new BusinessLayer();
		Backend be = new Backend();
		Main mainObj = new Main();
	
		System.out.println ( mainObj.getModuleName() );
		System.out.println ( fe.getModuleName() );
		System.out.println ( bl.getModuleName() );
		System.out.println ( be.getModuleName() );

	}

}
