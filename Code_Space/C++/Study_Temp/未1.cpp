/*编写一个字符串类，要求具有以下功能。
(1)以字符数组作为成员数据，用于存储字符串，字符串长度不会超过49.
(2)构造函数可以以字符串常量作为参数，对对象进行初始化
(3)构造函数可以以本类对象作为参数，实现对象的拷贝。
(4)具有替换字符的功能，如将字符串中所有字母r替换成字母R。
(5)具有求出字符串长度的功能，结尾符不计长度
(6)具有输出字符串的功能。（用成员函数实现）*/
#include<iostream>
#include<string>
#include<cstring>
#define N 50
using namespace std;

class String{
	private:
		char Str_Array[N];
	public:
		String(string Copy_Str){
			int j;
			for(j=0;j<Copy_Str.length();j++){
				this->Str_Array[j]=Copy_Str[j];
			}
			Str_Array[j]='\0';
		}
		String(String &S){
			int i;
			for(i=0;i<strlen(S.Str_Array);i++){
				this->Str_Array[i]=S.Str_Array[i];
			}
			Str_Array[i]='\0';
		}
		
		void Repleace_Array(char x,char y){
			for(int i=0;i<strlen(Str_Array);i++){
				if(Str_Array[i]==x){
					Str_Array[i]=y;
				}
			}
		}
		
		void Word_Upper_Lower(char x){
			int k;
			if(x>'a'&&x<'z'){
				k=-32;
			}
			else k=32;
			for(int i=0;i<strlen(Str_Array);i++){
				if(Str_Array[i]==x){
					Str_Array[i]+=k;
				}
			}
		}
		
		int Length(){
			return strlen(Str_Array);
		}
		
		void Print_Array(){
			cout<<Str_Array<<endl;
		}
	
};

int main(){
	string Copy_string;
	bool judge;
	cout<<"Please input String whcih have "<<N-1<<" letter or lower:"<<endl;
	cin>>Copy_string;
	if(Copy_string.length()>N-1){
		judge=true;
		while(judge){
			cout<<"Please input again!:"<<endl;
			cin>>Copy_string;
			if(Copy_string.length()<=N-1){
				judge=false;
			}
		}
	}
	String S(Copy_string);
	cout<<"S:";S.Print_Array();
	String S1(S);
	cout<<"Copy S:";S1.Print_Array();
	char x,y;
	cout<<"Repleace x to y:";
	cin>>x>>y;
	S.Repleace_Array(x,y);
	S.Print_Array();
	cout<<"Which to change:";
	cin>>x;
	S.Word_Upper_Lower(x);
	S.Print_Array();
	cout<<"S length is:"<<S.Length()<<endl;
	cout<<"S1 length is:"<<S1.Length()<<endl;
}

