#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
void fun(int array[3][3])
{int i,j,t;
for(i=0;i<3;i++)
{
	for(j=0;j<3;j++)
	{if(j<i){t=array[i][j];array[i][j]=array[j][i];array[j][i]=t;}	}
}
}
void main()
{
int i,j;
int array[3][3]={{100,200,300},{400,500,600},{700,800,900}};
system("CLS");
for(i=0;i<3;i++)
{
	for(j=0;j<3;j++)
	{
		printf("%7d",array[i][j]);
	}
	printf("\n");
}
fun(array);
printf("Converted array:\n");
for(i=0;i<3;i++)
{
	for(j=0;j<3;j++)
	{
		printf("%7d",array[i][j]);
	}
	printf("\n");
}
}
