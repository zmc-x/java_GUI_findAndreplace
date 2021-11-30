package java大作业1;

import java.util.Scanner;

public class Main {
	static int cnt=0;//help统计
	static String compare;
	static int cnt_=0;//operate统计
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String str1="welcome to HNUST!";//初始字符串
		System.out.println("嗨，这是个简单的字符串处理工具。");
		while(true) {
			System.out.println("输入一段字符串");
			cnt_=0;
			StringBuffer sen=new StringBuffer();
			String mid=in.nextLine();
			if(mid.length()==0) {
				System.out.println("现在是默认字符串");
				System.out.println("ok,字符串的长度为"+str1.length());
				sen.append(str1);
				operate(sen);
			}
			else {
				System.out.println("ok,字符串的长度为"+mid.length());
				sen.append(mid);
				operate(sen);
			}
			if(compare.equals("exit")) break;
		}
		System.out.println("期待你的下次使用！");
		in.close();
}
	public static void operate(StringBuffer sen) {
		System.out.println("请开始操作！");
		System.out.println("不了解这个工具的相关操作请输入help来寻求帮助");
		Scanner in=new Scanner(System.in);
		while(true) {
		cnt_++;
		if(cnt_!=1) System.out.println("你还想进行哪些操作？");
		compare=in.nextLine();
		if(compare.equals("help")) {
			if(cnt>3) System.out.println("我感觉我设计的操作不难啊，为啥你要输入help这多次，都"+cnt+"次了，我哭了呀。。。。");
			System.out.println("请按照下面的相关字符进行操作");
			System.out.println("insert--插入\n"+"delete--删除\n"+"replace--替代\n"+"find--统计字符或者字串数目\n"+"exit--退出");
			System.out.println("初始默认字符串为welcome to HNUST!");
			operate(sen);
			cnt++;//help次数叠加
		}
		else if(compare.equals("insert")) {
			System.out.println("当前字符:"+sen+"\n"+"你期待在这个字符串的那个地方插入什么字符？");
			System.out.println("插入字符：");
			String s=in.nextLine();
			System.out.println("插入位置：");
			int pos=in.nextInt();
			sen.insert(pos, s);
			System.out.println("ok,插入成功。当前字符为："+sen);
		}
		else if (compare.equals("delete")) {
			System.out.println("当前字符:"+sen+"\n"+"你希望删掉哪些字符？");
			System.out.println("请输入你想要删除的字符的起始和结束位置(注意起始地址是从0开始的,删除操作不包括结束位置)：");
			System.out.println("start:");
			int pos1=in.nextInt();
			System.out.println("end:");
			int pos2=in.nextInt();
			sen.delete(pos1, pos2);
			System.out.println("删除之后的字符串是："+sen);
		}
		else if(compare.equals("replace")) {
			System.out.println("当前字符:"+sen+"\n"+"你希望替换哪些字符？");
			System.out.println("替换的新字符：");
			String s=in.nextLine();
			System.out.println("输入原替换起始位置(包括)：");
			int start=in.nextInt();
			System.out.println("输入原替换结束位置(不包括)：");
			int end=in.nextInt();
			sen.replace(start, end, s);
			System.out.println("替换之后的字符串为:"+sen);
		}
		else if(compare.equals("find")) {
			System.out.println("你当前的字符串是:"+sen+"\n输入你想要查找的字串:");
			String found=in.nextLine();
			String _sen=sen.toString();
			Find find=new Find(_sen, found);//创建find对象
			find.kmp();
		}
		else if(compare.equals("exit")) break;
		else {
			System.out.println("没有这项操作哦，请输入help查看帮助文档");
		}
	  }
	in.close();
	}

}
