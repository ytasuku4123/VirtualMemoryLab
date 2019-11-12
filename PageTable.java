import java.io.*;
import java.util.*; 

class PageTable {
    
    private PageTableEntry[] entries;
    
	public PageTable() {
	    entries = new PageTableEntry[64];
	    
	}
	
	PageTableEntry getPTE(int pageEntryIndex){
	    return entries[pageEntryIndex];
	}
	
	void setPTE(int pt, PageTableEntry pte){
	    
	}
	
}