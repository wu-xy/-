package cn.wzx.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ���й���������ͽ���
 * @author wzx
 *
 */
public class HaFuManCode {
	static Map<Byte, String> mapCode;		//���������뼯
	public static void main(String[] args) {
		String str="i want to a offer aaaaa!";
		byte[] bytes = str.getBytes();				//���ַ���תΪ�ֽ�����				
		byte[] HFbytes = haFuManCode(bytes);		//��ɹ���������
		System.out.println("����ǰ���ȣ�"+bytes.length);
		System.out.println("����󳤶ȣ�"+HFbytes.length);
		byte[] newBytes = decode(HFbytes,mapCode);	//���н���
		System.out.println(new String(newBytes));	//��ԭ�ַ���
		 
	}
	
	/**
	 * ���н���
	 * @param hFbytes
	 * @param mapCode 
	 * @return
	 */
	private static byte[] decode(byte[] hFbytes, Map<Byte, String> mapCode) {		
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < hFbytes.length; i++) {
			boolean flag=true;
			if(i== hFbytes.length-1) {		//��������һλ���ò�ȫ8λ
				flag=false;
			}
			sb.append(toBinaryString(hFbytes[i], flag));
		}
		Map<String, Byte> map=new HashMap<String, Byte>();		//����ֵ�Է�ת
		for (Entry<Byte, String> entry : mapCode.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		List<Byte> list=new ArrayList<Byte>();		//����ȡ������byte
		for (int i = 0; i < sb.length();) {
			int count=1;
			String substring = null;
			boolean stop=true;
			while(stop) {
				substring = sb.substring(i, i+count);
				if(map.get(substring)==null) {		//û�ҵ���ֵ�ԣ�����ѭ��
					count++;
				}else {
					stop=false;		//�ҵ���ֵ�ԣ��˳�ѭ��
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
	 * ��������תΪ�ַ���
	 * �޶�ÿ���ַ����ĳ���Ϊ8
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
	 * ����������
	 * @param bytes
	 * @return
	 */	
	private static byte[] haFuManCode(byte[] bytes) {
		//ͳ��ÿ���ַ����ֵĸ���,��map��ֵ����ʽ������
		Map<Byte, Integer> map=countByte(bytes);
		//����map��ֵ�ԣ�������������
		HaFuManNode node=haFuMan(map);
		//���ݹ�����������ȡҶ�ӽڵ��·������map������
		mapCode=getStringCode(node);
		//���ַ�����ʽ��·��תΪ�ֽ�������ʽ����ɹ���������
		byte[] HFbytes=zip(bytes,mapCode);
						
		return HFbytes;						
	}
	private static byte[] zip(byte[] bytes, Map<Byte, String> mapCode) {
		StringBuilder sb=new StringBuilder();
		for (byte b : bytes) {
			sb.append(mapCode.get(b)); 	//	����ԭ�����ַ�˳�򣬰ѹ���������ƴ��һ�����ַ���
		}
		byte[] HFbytes;
		if(sb.length()%8==0) {			//  �ѹ���������תΪ�ֽ����飬8λһ���ֽ�
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
			//�ж��Ƿ���Ҷ�ӽڵ㣬����Ǽ����ݹ�
			getStringCode(node.leftNode, "0", sb2, mapCode);
			getStringCode(node.rightNode, "1", sb2, mapCode);
		}else {
			//�ҵ�Ҷ�ӽڵ㣬��Ӽ�ֵ��
			mapCode.put(node.data, sb2.toString());
		}
			
		
	}
	/**
	 * ͳ��ÿ���ַ����ֵĸ���
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
				map.put(b, count+1);		//ͳ��ÿ���ַ����ֵĸ���
			}			
		}
		
		return map;
		
	}
	
	/**
	 * ������������
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
	public int value;				//�ڵ��Ȩ��Я��������
	public HaFuManNode leftNode;		//���ӽڵ�
	public HaFuManNode rightNode;		//���ӽڵ�
			
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
