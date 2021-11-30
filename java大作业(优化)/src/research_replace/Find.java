package research_replace;

public class Find {
	public String sen;//原字符串
	public String find;//需要查找的字符串
	public int []memory=new int[10000];
	public int me_cnt;
	public int flag=0;//判断是否存在字串
	public Find(String sen,String find) {
		this.sen=sen;
		this.find=find;
	}
	//kmp算法
	public void kmp() {
		int len=sen.length();
		int len1=find.length();
		char []major=sen.toCharArray();
		char []minor=find.toCharArray();
		if(len1>len) {
			flag=1;
		}
		else {
			int []next=new int[100];
			next[0]=-1;//一号位置失配
			next[1]=0;//2号位置失配
			int i,j,k;
			i=j=0;
			k=1;
			int cnt=1;//判断循环次数
			me_cnt=0;
			for(i=2;i<len1;i++) {
				while(k<len1&&j<len1) {
					if(minor[j]!=minor[k]) {
						cnt++;//叠加
						k=cnt;
						j=0;
					}
					else {
						k++;
						j++;
					}
				}
				next[i]=j;
			}
			i=j=0;
			int count=0;
			while(i<len) {//进行匹配
				if(major[i]!=minor[j]) {
					j=next[j];//利用next数组来进行替换
					if(j==-1) {
						i++;
						j++;
					}
				}
				else {
					i++;
					j++;
				}
				if(j>=len1) {
					count++;
					int start=i-len1+1;
					memory[me_cnt]=start;
					memory[me_cnt+1]=i;
					me_cnt=me_cnt+2;
					j=0;
				}
			}
			if(count==0) flag=1;//同上
		}
	}
}
