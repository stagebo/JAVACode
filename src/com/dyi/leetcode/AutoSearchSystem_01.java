package com.dyi.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoSearchSystem_01 {
	private List<Item> resource = new ArrayList<Item>();
	private List<Item> resultList = new ArrayList<Item>();
	private StringBuilder tempString=new StringBuilder();
	private char endChar='#';
	/**
	 * '#'表示结束. 其他字符则表示继续查询。
	 * 
	 * @param c
	 * @return
	 */
	public ArrayList<Item> input(char c) {
		/*输入结束，处理结果并返回*/
		if(c==endChar){
			
			
		}
		return null;
	}
	public ArrayList<Item> getResult(){
		Collections.copy(resultList, resource);
		resultList.stream().forEach(x->{
			if(x.getContent().startsWith(tempString.toString())){
				resultList.remove(x);
			}
		});
		
		resultList.sort(null);
		ArrayList<Item> re=new ArrayList<Item>();
		re.add(re.get(0));
		
		return null;
	}
	public boolean refreshResultList() {

		return true;
	}

	public AutoSearchSystem_01(String[] strList, int[] countList) throws Exception {
		if (strList.length != countList.length) {
			throw new Exception("参数内容不对齐~");
		}
		for (int i = 0; i < strList.length; i++) {
			Item item = new Item(countList[i], strList[i]);
			this.resource.add(item);
		}
	}

	public List<Item> getResource() {
		return resource;
	}

	public void setResource(ArrayList<Item> resource) {
		this.resource = resource;
	}

	public List<Item> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<Item> resultList) {
		this.resultList = resultList;
	}

	public String resourceToString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		boolean isStart = true;
		for (Item item : resource) {
			sb.append(isStart ? "" : ",");
			isStart = false;
			sb.append(item.toString());
		}
		sb.append("]");

		return sb.toString();
	}
}

/**
 * 储存每一条记录
 * 
 * @author WANYONGBO
 *
 */
class Item implements Comparable<Item>{
	private int count;
	private String content;

	public Item(int c, String con) {
		this.count = c;
		this.content = con;
	}
	public Item(){}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Item [count=" + count + ", content=" + content + "]";
	}

	@Override
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		if(this.count>o.count)return 1;
		else if(this.count<o.count)return -1;
		else return this.content.compareTo(o.getContent());
	}

}
