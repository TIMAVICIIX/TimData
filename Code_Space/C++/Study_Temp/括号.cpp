#include<bits/stdc++.h> //����ͷ�ļ���������
using namespace std;
long long a[1001];
int main(){
a[0]=1;//��������Ҫ���ҵ�nΪ1��2�Ĵ�
a[1]=2;
a[2]=3;
int i;
for(i=3;i<51;i++)
    a[i]=a[i-2]+a[i-1]; //���ƹ�ʽ�������������һ��
int n;
while(cin>>n)
{
    cout<<a[n-1]<<endl;
}
    return 0;
}

