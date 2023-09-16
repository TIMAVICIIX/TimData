/*#include<iostream>
using namespace std;

long fun(long x){
	if(x<=3){
		return x;
	}
	
	long act=0;
	
	if(x>3){
		act=fun(x-1)+fun(x-2);
	}
	
	return act;
}

int main(){
	cout<<"Please input range:";
	long a;
	cin>>a; 
	long count=fun(a);
	
	cout<<"Count:"<<count<<endl;
}*/
#include<iostream>
using namespace std;
int f[10010];
int main()
{
	int n;
	while(cin>>n)
	{
		f[1]=1;
		f[2]=2;
		for(int i=3;i<=n;i++)
		{
			f[i]=f[i-1]+f[i-2];
		}
		cout<<f[n]<<endl;
	}
	
	return 0;
}


