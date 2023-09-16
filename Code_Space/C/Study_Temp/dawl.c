#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<stdlib.h>
char *fun(char (*a)[81],int num,char *max)
{
	int i,j=0;
	for(i=1;i<num;i++)
	{
		while(j<81)
		{
			if(*((*a+i)+j)=='\0'&&*(*(a+i-1)+j)!='\0'){*max=i;}
			else if(*((*a+i)+j)!='\0'&&*(*(a+i-1)+j)=='\0'){*max=i+1;}
			j++;
		}

	}
}
void main()
{
char ss[10][81],*ps=NULL;
int i=0,n;
system("CLS");
printf("ÊäÈëÈô¸É¸ö×Ö·û´®:");
gets(ss[i]);
puts(ss[i]);
while(!strcmp(ss[i],"****")==0)
{
i++;
gets(ss[i]);
puts(ss[i]);
}
n=i;
ps=fun(ss,n,ps);
printf("\nmax=%s\n",ps);
}