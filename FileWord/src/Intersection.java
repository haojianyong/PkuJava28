import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class Intersection {
	
	public static void Collect(Map<String,Integer> map,String filePath){
		try {
            String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String sentence = null;
                while((sentence = bufferedReader.readLine()) != null){
                    //System.out.println(sentence);
            		StringTokenizer token=new StringTokenizer(sentence);//这个类会将字符串分解成一个个的标记
            		while(token.hasMoreTokens()){                      //循环遍历
            	                            
            			String word=token.nextToken(", ?.!:\"\"''\n");  //括号里的字符的含义是说按照,空格 ? . : "" '' \n去分割，如果这里你没明确要求，即括号里为空，则默认按照空格，制表符，新行符和回车符去分割
            			if(map.containsKey(word)){     //HashMap不允许重复的key，所以利用这个特性，去统计单词的个数
            				int count=map.get(word);
            				map.put(word, count+1);     //如果HashMap已有这个单词，则设置它的数量加1
            			}
            			else
            				map.put(word, 1);          //如果没有这个单词，则新填入，数量为1
            		}
            		
            	}
            	
                read.close();
    }else{
        System.out.println("找不到指定的文件");
    }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
	}
	
	public static void Intersection(String filePath,String filePath1){
		Map<String,Integer> map=new HashMap<String,Integer>();
		Map<String,Integer> map1=new HashMap<String,Integer>();
		
		Collect(map,filePath);
		Collect(map1, filePath1);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (map1.containsKey(entry.getKey())) {
				System.out.println(entry.getKey());
			}
		}
	}
	public static void main(String arg[]){
		
		String filePath = "/Users/sunny/Documents/workspace/FileWord/1.txt";
		String filePath1 = "/Users/sunny/Documents/workspace/FileWord/2.txt";
		System.out.println("两文件交集");
		Intersection(filePath,filePath1);

	}
}
