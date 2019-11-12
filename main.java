import java.io.*;
import java.util.*; 

public class main {
    public static int newIndex;
    public static int switchIndex;
    public static int accessNum;
    //this is a process
    static ArrayList<PageTable> pts = new ArrayList<PageTable>();  
    static PageTable currentPageTable;

	public static void main(String[] args) {
		readFile();
	}

	static void readFile(){
	         try {
            // ファイルのパスを指定する
            File file = new File("VMInput1.txt");
         
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
                    createPageTable(newIndex);
                }else if(contents[0].equals("switch")){
                    switchIndex = Integer.parseInt(contents[1]);
                    switchPageTable(switchIndex);
                }else if(contents[0].equals("access")){
                    accessNum = Integer.parseInt(contents[1]);
                    int indexAccessNum = accessNum>>10;
                    System.out.println("access: " + indexAccessNum);
                }
                
            }
            
            // 最後にファイルを閉じてリソースを開放する
            bufferedReader.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
    	
	static void createPageTable(int newIndex){
        PageTable p = new PageTable();
        pts.add(p);
        currentPageTable = p;
	}	
	
	static void switchPageTable(int switchIndex){
	    currentPageTable = pts.get(switchIndex - 1);
	}
	
	

}
