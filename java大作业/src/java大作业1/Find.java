package java大作业1;

public class Find {
	String sen;//原字符串
	String find;//需要查找的字符串
	public Find(String sen,String find) {
		this.sen=sen;
		this.find=find;
	}
	//kmp算法
	public void kmp() {
		int len=sen.length();
		int len1=find.length();
		//String str;
		char []major=sen.toCharArray();
		char []minor=find.toCharArray();
		if(len1>len) System.out.println("没有这个字符串！");
		else {
			int []next=new int[100];
			next[0]=-1;//一号位置失配
			next[1]=0;//2号位置失配
			int i,j,k;
			i=j=0;
			k=1;
			int cnt=1;//判断循环次数
			int []memory=new int[10000];
			int me_cnt=0;
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
			int count=0;//匹配次数统计
			i=j=0;
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
					System.out.println("字符串出现了"+count+"次,字符串的位置是:"+start+"到"+i);
					memory[me_cnt]=start-1;
					memory[me_cnt+1]=i-1;
					me_cnt=me_cnt+2;
					j=0;
				}
			}
			System.out.println("me_cnt:"+me_cnt);
			me_cnt=0;//置为0
			if(count==0) System.out.println("额，似乎并没有这个字符串。。。。");
			else {
				System.out.println("总的来说，字串的位置即为标注出来的地方：");
				for(int pos=0;pos<len;pos++) {
					if(pos==memory[me_cnt]) {
						for(int _pos=pos;_pos<=memory[me_cnt+1];_pos++) {
							System.err.print(major[_pos]);
						}
						pos=memory[me_cnt+1];
						me_cnt=me_cnt+2;//取下一个字串的位置
					}
					else System.out.print(major[pos]);
				}
				System.out.println();
			}
		}
	}
}
