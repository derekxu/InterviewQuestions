package linkedIn;

import java.util.*;
import java.io.*;

public class TextFileReader implements Iterable<String> {
	private BufferedReader reader;
	private class TextIterator implements Iterator<String>{
		String next=null;
		@Override
		public boolean hasNext(){
			if(next==null){
				try{
					next = reader.readLine();
				}catch(IOException e){
					return false;
				}
			}
			
			return next!=null;
		}
		@Override
		public String next(){
			if(hasNext()){
				return next;
			}
			else{
				return null;
			}
		}
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	public TextFileReader(String fileName) throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(fileName));
	}
	
	@Override
	public Iterator<String> iterator(){
		return new TextIterator();
	}
}
