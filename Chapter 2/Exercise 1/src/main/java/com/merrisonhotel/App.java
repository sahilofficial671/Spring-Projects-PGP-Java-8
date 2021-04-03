package com.merrisonhotel;

public class App 
{
	public App() {}
	
	public static void main( String[] args )
    {
		Index index = new Index();
		index.serveActions();
		index.action(index.getAction());
    }
}
