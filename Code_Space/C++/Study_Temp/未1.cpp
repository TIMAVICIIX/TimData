/*��дһ���ַ����࣬Ҫ��������¹��ܡ�
(1)���ַ�������Ϊ��Ա���ݣ����ڴ洢�ַ������ַ������Ȳ��ᳬ��49.
(2)���캯���������ַ���������Ϊ�������Զ�����г�ʼ��
(3)���캯�������Ա��������Ϊ������ʵ�ֶ���Ŀ�����
(4)�����滻�ַ��Ĺ��ܣ��罫�ַ�����������ĸr�滻����ĸR��
(5)��������ַ������ȵĹ��ܣ���β�����Ƴ���
(6)��������ַ����Ĺ��ܡ����ó�Ա����ʵ�֣�*/
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

