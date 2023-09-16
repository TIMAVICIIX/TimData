#include<iostream>
using namespace std;

class NUM{
	private:
	int count;
	public:
		void Re_count(int count=0){
			this->count=count;
		}
		void Find_Num(int mfiled,int Mfiled,bool p=true){
			int i,j;
			for(i=mfiled;i<=Mfiled;i++){
				p=true;
				for(j=2;j<i;j++){
					if(i%j==0){
						p=false;
						break;
					}
				}
				if(p&&i!=1){
					cout<<i<<" ";count++;
					if(count%5==0)cout<<endl;
					}
			}
			cout<<"NUM="<<count<<endl;
		}
	
}; 

int main(){
	int x,y;
	NUM n;
	cout<<"Please intput files:";
	cin>>x>>y;
	if(x>y){
		cout<<"ERROR!!"<<endl;return 0;
	}
	n.Re_count();
	n.Find_Num(x,y);
}

/*#include <iostream>
using namespace std;
int main()
{
   int n,m,i,j,t=0;//t用来累加换行
  
   cin>>n;
   while(n<2)//n小于2时需重新输入
   cin>>n;
   bool prime;//定义bool变量
   for(i=2;i<n;i++)
   {
       prime=true;//先令prime为真
       
       for(j=2;j<i;j++)//对2到m进行循环
       {
           if(i%j==0)//若i整除j为0，令prime为假，循环终止
           {
               prime=false;
               break;
           }
       }
       if(prime)//若prime为真，输出n
       {
           cout<<i<<" ";
           t+=1;
           if(t%10==0)//若t整除10为0，再换一行输出
           cout<<endl;
       }
   }
   return 0;
}*/

