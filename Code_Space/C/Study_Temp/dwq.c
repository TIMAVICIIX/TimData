#include<stdio.h>
#include<ctype.h>
#include<conio.h>
#include<stdlib.h>
/*void fun(char *str)
{
	int i,j;
	for(i=0;*(str+i)!='\0';i++)
	{
	if(*(str+i)==' ')
		{
			for(j=i;*(str+j-1)!='\0';j++)
			{
			*(str+j)=*(str+j+1);
			}
	
		}
	}
}*/
void fun(char *str)
{
	int i=0;
	char *p=str;
	while(*p)
	{
		if(*p!=' '){str[i++]=*p;}
		p++;
	}
	str[i]='\0';
}
int main()
{
char str[81];
char MAG[]="Input a string:";
int n;
printf(MAG);
gets(str);
fun(str);
printf("***str:%s\n",str);
puts(str);
}