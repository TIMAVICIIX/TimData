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
   int n,m,i,j,t=0;//t�����ۼӻ���
  
   cin>>n;
   while(n<2)//nС��2ʱ����������
   cin>>n;
   bool prime;//����bool����
   for(i=2;i<n;i++)
   {
       prime=true;//����primeΪ��
       
       for(j=2;j<i;j++)//��2��m����ѭ��
       {
           if(i%j==0)//��i����jΪ0����primeΪ�٣�ѭ����ֹ
           {
               prime=false;
               break;
           }
       }
       if(prime)//��primeΪ�棬���n
       {
           cout<<i<<" ";
           t+=1;
           if(t%10==0)//��t����10Ϊ0���ٻ�һ�����
           cout<<endl;
       }
   }
   return 0;
}*/

