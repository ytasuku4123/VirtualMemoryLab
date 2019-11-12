import java.io.*;
import java.util.*; 

public class main {
    static int newIndex;
    static int switchIndex;
    static int accessNum;
    //this is a process
    static ArrayList<PageTable> pts = new ArrayList<PageTable>();  
    static PageTable currentPageTable;
    static int miss = 0;
    static int compulsory = 0;
    static int hit = 0;
    static int access = 0;
    static Memory memory = new Memory();
    static int frameIndex = 0;

	public static void main(String[] args) {
		readFile();
		System.out.println("Accsess: " + access);
		System.out.println("Hit: " + hit);
		System.out.println("Miss: " + miss);
		System.out.println("Compulsory: " + compulsory);
	}

	static void readFile(){
	         try {
            // ファイルのパスを指定する
            File file = new File("VMInput.txt");
         
            // ファイルが存在しない場合に例外が発生するので確認する
            if (!file.exists()) {
                System.out.print("ファイルが存在しません");
                return;
            }
         
            // BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                String[] contents = data.split(" ");
                if(contents[0].equals("new")){
                    newIndex = Integer.parseInt(contents[1]);
                    createPageTable();
                }else if(contents[0].equals("switch")){
                    switchIndex = Integer.parseInt(contents[1]);
                    switchPageTable(switchIndex);
                }else if(contents[0].equals("access")){
                    accessNum = Integer.parseInt(contents[1]);
                    int indexAccessNum = accessNum>>10;
                    //System.out.println("access: " + indexAccessNum);
                    findIndex(indexAccessNum);
                }
                
            }
            
            // 最後にファイルを閉じてリソースを開放する
            bufferedReader.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    	
	static void createPageTable(){
        PageTable p = new PageTable();
        pts.add(p);
	}	
	
	static void switchPageTable(int switchIndex){
	    currentPageTable = pts.get(switchIndex - 1);
	}
	
	static void findIndex(int accessNum){
	    if(currentPageTable.getPTE(accessNum) == null){
	        miss++;
	        compulsory++;
	        access++;
	        PageTableEntry pte = new PageTableEntry();
	        int frameIndexNum = frameIndex % 30;
	        memory.setFrame(frameIndexNum, pte);
	        currentPageTable.setPTE(accessNum, pte);
	        frameIndex++;
	    }else{
	        if(currentPageTable.getPTE(accessNum).getInMemory() == true){
	            hit++;
	            access++;
	        }
	        else{
	            miss++;
	            access++;
	            int frameIndexNum = frameIndex % 30;
	            memory.setFrame(frameIndexNum, currentPageTable.getPTE(accessNum));
	            frameIndex++;
	        }
	    }
	}
	
	

}
