package com.dyi.test;


public class WSDLTest {
	public static void main(String[] args) {
		We w=new We();
		String ad="http://127.0.0.1:12345";
	}
}
interface W{
	public String getW(String city);
}
class We implements W{

	public String getW(String city) {
		// TODO Auto-generated method stub
		System.out.println(city);
		return city+" is received~";
	}
	
}