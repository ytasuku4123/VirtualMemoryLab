import java.io.*;
import java.util.*; 

class Memory {

    private PageTableEntry[] frames;
    
	public Memory() {
	    frames = new PageTableEntry[30];
	}
	
	void setFrame(int index, PageTableEntry pte){
		if(frames[index] == null){
			frames[index] = pte;
			frames[index].setInMemory(true);
			
		}else{
			frames[index].setInMemory(false);
			frames[index] = pte;
			frames[index].setInMemory(true);
		}
	    
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
