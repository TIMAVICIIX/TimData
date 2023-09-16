#include<stdio.h>
#include<string.h>
#define N 80
int fun(char *s)
{int i,num=0,p=0;
for(i=0;i<N;i++,s++){
	if(*s!=' '){p=0;}
	if(*s==' '){p=1;}
	if(*(s++)==' '||*(s--)==' '){p=0;}
	if(p==1){num++;}
	}
return num;
}
void main()
{
	char line[N];
	int num=0;
	printf("Enter a String:\n");
	gets(line);
	num=fun(line);
	printf("The number has :%d",num);
	return 0;
}
