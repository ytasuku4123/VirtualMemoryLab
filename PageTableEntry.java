import java.io.*;
import java.util.*; 

class PageTableEntry {
    
    private boolean inMemory;
    private int frame;

	public PageTableEntry() {
	    inMemory = true;
	    frame = 0;
	}
	
	int getFrame(){
	    return frame;
	}
	
	void setInMemory(boolean tf){
		inMemory = tf;
	}
	
	boolean getInMemory(){
	    return inMemory;
	}
	
	void swapToDisk(int diskFrame){
	    
	}
	
	void swapToMemory(int memFrame){
	    
	}
	
}