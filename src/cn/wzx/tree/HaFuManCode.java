package cn.wzx.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 进行哈夫曼编码和解码
 * @author wzx
 *
 */
public class HaFuManCode {
	static Map<Byte, String> mapCode;		//哈夫曼编码集
	public static void main(String[] args) {
		String str="i want to a offer aaaaa!";
		byte[] bytes = str.getBytes();				//将字符串转为字节数组				
		byte[] HFbytes = haFuManCode(bytes);		//完成哈夫曼编码
		System.out.println("编码前长度："+bytes.length);
		System.out.println("编码后长度："+HFbytes.length);
		byte[] newBytes = decode(HFbytes,mapCode);	//进行解码
		System.out.println(new String(newBytes));	//还原字符串
		 
	}
	
	/**
	 * 进行解码
	 * @param hFbytes
	 * @param mapCode 
	 * @return
	 */
	private static byte[] decode(byte[] hFbytes, Map<Byte, String> mapCode) {		
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < hFbytes.length; i++) {
			boolean flag=true;
			if(i== hFbytes.length-1) {		//如果是最后一位不用补全8位
				flag=false;
			}
			sb.append(toBinaryString(hFbytes[i], flag));
		}
		Map<String, Byte> map=new HashMap<String, Byte>();		//将键值对反转
		for (Entry<Byte, String> entry : mapCode.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		List<Byte> list=new ArrayList<Byte>();		//储存取出来的byte
		for (int i = 0; i < sb.length();) {
			int count=1;
			String substring = null;
			boolean stop=true;
			while(stop) {
				substring = sb.substring(i, i+count);
				if(map.get(substring)==null) {		//没找到键值对，继续循环
					count++;
				}else {
					stop=false;		//找到键值对，退出循环
				}
			}
			list.add(map.get(substring));
			i+=count;			
		}
		byte[] newBytes=new byte[list.size()];
		for (int i = 0; i < newBytes.length; i++) {
			newBytes[i]=list.get(i);
		}
		
		return newBytes;
	}
	
	/**
	 * 将二进制转为字符串
	 * 限定每个字符串的长度为8
	 * @param b
	 * @return
	 */
	private static String toBinaryString(byte b,boolean flag) {
		if(flag) {
			int temp=b;
			temp|=256;
			String binaryString = Integer.toBinaryString(temp);
			String substring = binaryString.substring(binaryString.length()-8);
			return substring;			
		}
		return Integer.toBinaryString(b);
	}

	/**
	 * 哈夫曼编码
	 * @param bytes
	 * @return
	 */	
	private static byte[] haFuManCode(byte[] bytes) {
		//统计每个字符出现的个数,用map键值对形式存起来
		Map<Byte, Integer> map=countByte(bytes);
		//根据map键值对，构建哈夫曼树
		HaFuManNode node=haFuMan(map);
		//根据哈夫曼树，获取叶子节点的路径，用map存起来
		mapCode=getStringCode(node);
		//把字符串形式的路径转为字节数组形式，完成哈夫曼编码
		byte[] HFbytes=zip(bytes,mapCode);
						
		return HFbytes;						
	}
	private static byte[] zip(byte[] bytes, Map<Byte, String> mapCode) {
		StringBuilder sb=new StringBuilder();
		for (byte b : bytes) {
			sb.append(mapCode.get(b)); 	//	按照原来的字符顺序，把哈夫曼编码拼成一个长字符串
		}
		byte[] HFbytes;
		if(sb.length()%8==0) {			//  把哈夫曼编码转为字节数组，8位一个字节
			 HFbytes=new byte[sb.length()/8];
		}else {
			 HFbytes=new byte[sb.length()/8+1];			
		}
		int index=0;
		for (int i = 0; i < sb.length(); i+=8) {
			String byteStr;
			if(i+8>=sb.length()) {
				byteStr=sb.substring(i);
			}else {
				byteStr=sb.substring(i,i+8);
			}
			byte b=(byte) Integer.parseInt(byteStr, 2);
			HFbytes[index]=b;
			index++;
		}
		
		
		return HFbytes;
	}
	private static Map<Byte, String> getStringCode(HaFuManNode node) {
		if(node==null) {
			return null;
		}
		StringBuilder sb=new StringBuilder();
		Map<Byte, String> mapCode=new HashMap<Byte, String>();
		getStringCode(node.leftNode,"0",sb,mapCode);
		getStringCode(node.rightNode,"1",sb,mapCode);
		
		return mapCode;		
	}
	private static void getStringCode(HaFuManNode node, String string, StringBuilder sb, Map<Byte, String> mapCode) {
		StringBuilder sb2=new StringBuilder(sb);
		sb2.append(string);
		if(node.data==null) {
			//判断是否是叶子节点，如果是继续递归
			getStringCode(node.leftNode, "0", sb2, mapCode);
			getStringCode(node.rightNode, "1", sb2, mapCode);
		}else {
			//找到叶子节点，添加键值对
			mapCode.put(node.data, sb2.toString());
		}
			
		
	}
	/**
	 * 统计每个字符出现的个数
	 * @param bytes
	 * @return
	 */
	public static Map<Byte, Integer> countByte(byte[] bytes){
		Map<Byte, Integer> map=new HashMap<Byte, Integer>();
		for (byte b : bytes) {
			Integer count=map.get(b);
			if(count==null) {
				map.put(b, 1);
			}else {
				map.put(b, count+1);		//统计每个字符出现的个数
			}			
		}
		
		return map;
		
	}
	
	/**
	 * 建立哈夫曼树
	 * @param map
	 * @return
	 */
	public static HaFuManNode haFuMan(Map<Byte, Integer> map) {
		List<HaFuManNode> list=new ArrayList<HaFuManNode>();
		for (Entry<Byte, Integer> entry : map.entrySet()) {
			list.add(new HaFuManNode(entry.getKey(), entry.getValue()));
		}
		while(list.size()>1) {
			list.sort(null);
			
			HaFuManNode node1=list.get(0);
			HaFuManNode node2=list.get(1);
			HaFuManNode node=new HaFuManNode(null,node1.value+node2.value);
			node.leftNode=node1;
			node.rightNode=node2;
			list.remove(1);
			list.remove(0);
			list.add(node);			 			
		}				
		return list.get(0);
		

	}
}
 class HaFuManNode implements Comparable<HaFuManNode> {
	 
	public Byte data;	 
	public int value;				//节点的权，携带的数据
	public HaFuManNode leftNode;		//左子节点
	public HaFuManNode rightNode;		//右子节点
			
	public HaFuManNode( Byte data,int value) {
		super();
		this.data=data;
		this.value = value;
	}
	
	public void frontShow() {
		System.out.println(this);
		if(leftNode!=null) {
			leftNode.frontShow();
		}
		if(rightNode!=null) {
			rightNode.frontShow();
		}
	}
	
	@Override
	public String toString() {
		return "HaFuManNode [data=" + data + ", value=" + value + "]";
	}

	@Override
	public int compareTo(HaFuManNode o) {
		
		return this.value-o.value;
	}
}
