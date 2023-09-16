#include<iostream>
using namespace std;

int fun(int n);

int main(){
	int Max=30;
	cout<<"Count:"<<fun(Max)<<endl;
}

int fun(int n){
	if(n==1||n==2){
		return 1;
	}
	if(n==3){
		return 2;
	}
	int sum=0;
	if(n>3){
		sum=fun(n-1)+fun(n-3);
	}
	
	return sum;
}
