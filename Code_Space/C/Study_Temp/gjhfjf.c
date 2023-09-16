#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int main()
{
int a[]={0,1,2,3,4};int *p[]={a,a+1,a+2,a+3,a+4};int **pp=p;
printf("%d %d %d %d %d",*a,*p,**p,*pp,**pp);
}
