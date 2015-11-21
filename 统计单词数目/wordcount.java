import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by ASUS on 2015/11/21.
 */
public class wordcount {
    public void word(String filepath1,String filepath2){//求单词个数
        /*File file1=new File("E:/text1");
        File file2=new File("E:/text2");*/
        int count1=0;
        int count2=0;
        Map<String,Integer> map=new HashMap<String, Integer>();
        File file1=new File(filepath1);
        File file2=new File(filepath2);
        try {
            BufferedReader reader1=new BufferedReader(new FileReader(file1));
            BufferedReader reader2=new BufferedReader(new FileReader(file2));
            String templineword=null;
            while ((templineword=reader1.readLine())!=null){
                count1+=wordcount(map,templineword);
            }
            while ((templineword=reader2.readLine())!=null){
                count2+=wordcount(map, templineword);
            }
            reader1.close();
            reader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Map.Entry<String,Integer>> iterator=map.entrySet().iterator();
        System.out.println("文本一中单词总数是："+count1);
        System.out.println("文本二中单词总数是："+count2);
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            System.out.println("单词："+entry.getKey()+" 单词个数："+entry.getValue());
        }
    }
    public void intersection_word(String filepath1,String filepath2){//求单词交集和它们的个数
        Map<String,Integer> map=new HashMap<String, Integer>();
        Map<String,Integer> intersection_map=new HashMap<String, Integer>();
        File file1=new File(filepath1);
        File file2=new File(filepath2);
        try {
            BufferedReader reader1=new BufferedReader(new FileReader(file1));
            BufferedReader reader2=new BufferedReader(new FileReader(file2));
            String templineword=null;
            while ((templineword=reader1.readLine())!=null){
                wordcount(map,templineword);
            }
            while ((templineword=reader2.readLine())!=null){
                intersection_wordcount(map,intersection_map,templineword);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<Map.Entry<String,Integer>> iterator=intersection_map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> entry=iterator.next();
            System.out.println("交集单词："+entry.getKey()+" 单词个数："+entry.getValue());
        }
    }
    public int wordcount(Map<String,Integer> map,String lineword){//计算一行中包括的单词个数和统计个单词个数
        int count=0;
        StringTokenizer token=new StringTokenizer(lineword);//这个类会将字符串分解成一个个的标记
        while (token.hasMoreTokens()){
            count++;
            String word=token.nextToken(",?.!:\" \"''\n");//括号里的字符的含义是说按照,空格 ? . : "" '' \n去分割，如果这里你没明
            // 确要求，即括号里为空，则默认按照制表符，新行符和回车符去分割
            if(map.containsKey(word)){
                int thisword_count=map.get(word);
                map.put(word,thisword_count+1);
            }
            else
                map.put(word,1);
        }
        return count;
    }
    public void intersection_wordcount(Map<String,Integer> map,Map<String,Integer> intersectionmap,String lineword){
        StringTokenizer token=new StringTokenizer(lineword);
        while (token.hasMoreTokens()){
            String word=token.nextToken(",?.!:\" \"''\n");
            if(map.containsKey(word)){
                if(intersectionmap.containsKey(word)){
                    int wordcount=intersectionmap.get(word);
                    intersectionmap.put(word,wordcount+1);
                }
                else{
                    int mapcount=map.get(word);
                    intersectionmap.put(word,mapcount+1);
                }
            }
        }
    }
    public static void main(String[] args){
        wordcount wordcount=new wordcount();
        wordcount.word("E:/text1.txt","E:/text2.txt");
        System.out.println("/************************************/");
        wordcount.intersection_word("E:/text1.txt", "E:/text2.txt");
    }
}
