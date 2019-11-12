import java.io.*;
import java.util.*; 

class Memory {

    private PageTableEntry[] frames;
    
	public Memory() {
	    frames = new PageTableEntry[30];
	}
	
	void setFrame(int frame, PageTableEntry pte){
	    
	}
	
	PageTableEntry getFrame(int frameIdex){
	    return frames[frameIdex];
	}
	
	int getFreePage(){
	    return 0;
	}
	
	int findSwapPage(){
	    return 0;
	}
	
	int convert(int frame){
	    return 0;
	}
	
}
