//3.使用函数指针，调用两个整数之间四则运算加、减，乘、除（也就是说，通过函数指针分别调用这4个函数实现四则运算）。
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