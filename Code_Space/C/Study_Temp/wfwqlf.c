//3.ʹ�ú���ָ�룬������������֮����������ӡ������ˡ�����Ҳ����˵��ͨ������ָ��ֱ������4������ʵ���������㣩��
#include<stdio.h>
#include<stdlib.h>
static c;
int *fun1(int a,int b)
{
	c=a*b;
    return &c; 

}



int main()
{
	int a=2,b=4,*p=fun1(a,b);
	printf("%d\n",*p);
}