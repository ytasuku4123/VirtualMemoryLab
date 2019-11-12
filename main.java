import java.io.*;
import java.util.*; 

public class main {
    public static int newProcess;
    public static int switchProcess;
    public static int accessNum;

	public static void main(String[] args) {
		readFile();
	}
	
	public static void readFile(){
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
            ArrayList<Integer> accessNumbers = new ArrayList<Integer>(); 
            while ((data = bufferedReader.readLine()) != null) {
                String[] contents = data.split(" ");
                if(contents[0].equals("new")){
                    newProcess = Integer.parseInt(contents[1]);
                }else if(contents[0].equals("switch")){
                    switchProcess = Integer.parseInt(contents[1]);
                }else if(contents[0].equals("access")){
                    accessNumbers.add(Integer.parseInt(contents[1]));
                }
                
            }
            
            System.out.println("new: " + newProcess);
            System.out.println("switch " + switchProcess);
            System.out.println("access: ");
            for(int a : accessNumbers){
                System.out.println(a);
            }
            
            // 最後にファイルを閉じてリソースを開放する
            bufferedReader.close();
         
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
