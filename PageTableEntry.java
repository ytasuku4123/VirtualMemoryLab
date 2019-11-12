import java.io.*;
import java.util.*; 

class PageTableEntry {
    
    private boolean inMemory;
    private int frame;

	public PageTableEntry() {
	    inMemory = false;
	    frame = 0;
	}
	
	int getFrame(){
	    return frame;
	}
	
	boolean inMemory(){
	    return inMemory;
	}
	
	void swapToDisk(int diskFrame){
	    
	}
	
	void swapToMemory(int memFrame){
	    
	}
	
}