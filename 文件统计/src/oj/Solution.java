package oj;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	//返回各个单词及其出现次数的统计，用HashMap存储
	public static HashMap<String,Integer> getStatistics(String fileName) throws FileNotFoundException{
		HashMap<String,Integer> res=new HashMap<String,Integer>();
		Scanner scan=new Scanner(new FileInputStream(fileName));
		while(scan.hasNext()){
			String tmp=scan.next();
			if(res.containsKey(tmp)){
				int val=res.get(tmp);
				res.put(tmp, val);
			}
			else{
				res.put(tmp, 1);
			}
		}
		return res;
	}
	//返回两个文件的词汇表交集，用HashSet存储
	public static HashSet<String> intersection(String fileName1,String fileName2) throws FileNotFoundException{
		HashSet<String> res=new HashSet<String>();
		HashMap<String,Integer> hm1,hm2;
		hm1=getStatistics(fileName1);
		hm2=getStatistics(fileName2);
		for(String key:hm1.keySet()){
			if(hm2.containsKey(key)){
				res.add(key);
			}
		}
		return res;
	}
	//返回两个文件的词汇表并集，用HashSet存储
	public static HashSet<String> union(String fileName1,String fileName2) throws FileNotFoundException{
		HashSet<String> res=new HashSet<String>();
		HashMap<String,Integer> hm1,hm2;
		hm1=getStatistics(fileName1);
		hm2=getStatistics(fileName2);
		for(String key:hm1.keySet()){
			res.add(key);
		}
		for(String key:hm2.keySet()){
			res.add(key);
		}
		return res;
	}
	//返回两个文件独自含有单词站自己词汇表的比例，用一个double数组存储
	public static double[] diff(String fileName1,String fileName2) throws FileNotFoundException{
		double[] res=new double[2];
		HashMap<String,Integer> hm1,hm2;
		hm1=getStatistics(fileName1);
		hm2=getStatistics(fileName2);
		HashSet<String> hs=intersection(fileName1,fileName2);
		res[0]=(hm1.size()-hs.size())/(double)hm1.size();
		res[1]=(hm2.size()-hs.size())/(double)hm2.size();
		return res;
	}
	//测试
	public static void main(String[] args) throws FileNotFoundException{
		HashMap<String,Integer> hm;
		HashSet<String> hs;
		hm=getStatistics("data1");
		for(String key:hm.keySet()){
			System.out.println(key+hm.get(key));
		}
		System.out.println();
		
		hm=getStatistics("data2");
		for(String key:hm.keySet()){
			System.out.println(key+hm.get(key));
		}
		System.out.println();
		
		hs=intersection("data1","data2");
		for(String key:hs){
			System.out.println(key);
		}
		System.out.println();
		
		hs=union("data1","data2");
		for(String key:hs){
			System.out.println(key);
		}
		System.out.println();
		
		double[] res=diff("data1","data2");
		System.out.println(res[0]+":"+res[1]);
	}
}

