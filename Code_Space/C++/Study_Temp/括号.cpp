#include<bits/stdc++.h> //万能头文件，超好用
using namespace std;
long long a[1001];
int main(){
a[0]=1;//根据题意要先找到n为1和2的答案
a[1]=2;
a[2]=3;
int i;
for(i=3;i<51;i++)
    a[i]=a[i-2]+a[i-1]; //递推公式，两种情况加在一起
int n;
while(cin>>n)
{
    cout<<a[n-1]<<endl;
}
    return 0;
}

