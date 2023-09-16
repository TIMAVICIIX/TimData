#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<conio.h>
void fun(char *ss)
{
	int i=0;
	while(*(ss+i)!='\0')
	{
		if(i%2!=0&&*(ss+i)>='a'&&*(ss+i)<='z')
		{
			*(ss+i)-=32;		
		
		}
		i++;
	}


}
void main()
{

	char tt[81],s[81]="abc4Efg";
	system("CLS");
	printf("Please enter an string within 80 charaters:\n");
	gets(tt);
	fun(tt);
	printf("\nBecomes:%s",tt);
}