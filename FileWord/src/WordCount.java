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
public class WordCount {
	public static void sort(Map<String,Integer> map){//排序
		List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); 
		Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {   
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {   
	            return (o2.getValue() - o1.getValue());   
	        }   
	}); //排序
		for (int i = 0; i < infoIds.size(); i++) {   //输出
			Entry<String, Integer> id = infoIds.get(i);
		System.out.println(id.getKey()+":"+id.getValue());
			}
    	
    }
	public static void count(String filePath){//统计单词个数
		int wordCount=0;      //用于统计单词的总个数
		Map<String,Integer> map=new HashMap<String,Integer>();//用于统计各个单词的个数，排序
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
            			wordCount++;                                  
            			String word=token.nextToken(", ?.!:\"\"''\n");  //括号里的字符的含义是说按照,空格 ? . : "" '' \n去分割，如果这里你没明确要求，即括号里为空，则默认按照空格，制表符，新行符和回车符去分割
            			if(map.containsKey(word)){     //HashMap不允许重复的key，所以利用这个特性，去统计单词的个数
            				int count=map.get(word);
            				map.put(word, count+1);     //如果HashMap已有这个单词，则设置它的数量加1
            			}
            			else
            				map.put(word, 1);          //如果没有这个单词，则新填入，数量为1
            		}
            		System.out.println("总共单词数："+wordCount);
            		sort(map);                        //调用排序的方法，排序并输出！
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
	
	
	public static void main(String arg[]){
		
		String filePath = "/Users/sunny/Documents/workspace/FileWord/1.txt";
		String filePath1 = "/Users/sunny/Documents/workspace/FileWord/2.txt";
		count(filePath);
		count(filePath1);

	}

}
