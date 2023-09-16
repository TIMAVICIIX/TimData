#include<iostream>
using namespace std;

const int M=8;

int MatrixChianOrder(int *p,int Length,int m[][M],int s[][M]){
	
	int q,n=Length-1;
	
	for(int i=1;i<=n;i++){
		m[i][i]=0;
	}
	
	for(int l=2;l<=n;l++){
		
		for(int i=1;i<=n-l+1;i++){
			
			int j=i+l-1;
			m[i][j]=2147483647;
			
			for(int k=i;k<=j-1;k++){
				
				q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
				
				if(q<m[i][j]){
					
					m[i][j]=q;
					s[i][j]=k;
					
				}
				
			}
			
		}
		
	}
	
	return m[1][n];
	
}

void PrintPath(int s[][M],int i,int j){
	
	if(i==j){
		cout<<"A"<<i;
	}else{
		
		cout<<"(";
		PrintPath(s,i,s[i][j]);
		PrintPath(s,s[i][j]+1,j);
		cout<<")"; 
		
	}
	
}

int main(){
	
	int p[M]={30,35,15,5,10,20,25,10};
	int m[M][M],s[M][M];
	
	int k=MatrixChianOrder(p,M,m,s);
	
	cout<<"最优解为：\n"<<k<<endl; 
	PrintPath(s,1,7);
	
}
