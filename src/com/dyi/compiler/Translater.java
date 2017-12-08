package com.dyi.compiler;
import java.io.*;


public class Translater {
	public static void main(String[] args) throws IOException {
		Parser parser = new Parser();
		parser.expr();
		System.out.println();
	}
}

class Parser{
	static int look;
	public Parser() throws IOException{
		look = System.in.read();
		
	}
	
	void expr() throws IOException{
		term();
		while(true){
			if(look == '+'){
				match('+');
				term();
				System.out.write('+');
			}else if(look == '-'){
				match('-');
				term();
				System.out.write('-');
			}else return;
		}
	}
	void term() throws IOException{
		if(Character.isDigit((char)look)){
			System.out.write((char)look);
			match(look);
		}else throw new Error("syntax error");
	}
	void match(int t) throws IOException{
		if(look == t){
			look = System.in.read();
		}else throw new Error("syntax error");
	}
	
}
