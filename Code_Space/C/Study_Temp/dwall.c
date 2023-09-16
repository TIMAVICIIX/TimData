#include<stdio.h>
#include<stdlib.h>
void fun(char *s,int i)
{
	*(s+i-1)='\0';
}

void main()

{
	char s[80],t;
	int i;
	printf("str:");
	gets(s);
	printf("delete element number:");
	scanf("%d",&t);
	fun(s,t);
	printf("After:");
	puts(s);
}