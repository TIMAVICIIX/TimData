#include<stdio.h>
#include<stdlib.h>
#define INTSIZE 6
typedef int Ele;
typedef struct 
{
	Ele *data;
	int length;
	int listsize;
}sqlist;

void initlist(sqlist *L)
{
	L->	data=(Ele *)malloc(sizeof(Ele)*INTSIZE);
	L->length=0;
	L->listsize=INTSIZE;
}

int intsert(sqlist *L,int i,Ele sq)
{
int j;
if(i<1||i>L->length+1)return 0;
if(L->length==L->listsize)
{L->data=(Ele *)realloc(L->data,(L->listsize+1)*sizeof(Ele));
L->listsize++;
}
for(j=L->length-1;j>=i-1;j--)
{
	L->data[j+1]=L->data[j];
}
L->data[i-1]=sq;
L->length++;
return 1;
}

int findele(sqlist *L,Ele sq)
{int i;
for(i=0;i<L->length;i++)
{
	if(L->data[i]==sq){printf("The number in the list.\n");return 1;}
}
 printf("The number not in the list.\n");
 return 0;
}

int delment(sqlist *L,int i)
{int j;
if(i<1||i>L->length)return 0;
	for(j=i;j<L->length;j++)
	{
		L->data[j-1]=L->data[j];
	}
	L->length--;
	return 1;
}

void list(sqlist *L)
{int i=0;
for(;i<L->length;i++)
{
printf("%d ",L->data[i]);
}
}

void Plength(sqlist *L)
{
printf("This list length: %d\n",L->length);
}

int Findele(sqlist *L,Ele x)
{
	int i;
	for(i=0;i<L->length;i++)
	{
		if(L->data[i]==x){printf("The number has find in %d first.\n",i+1);return 1;}
	}
	return 0;
}

int main()
{
	int i=0;
	Ele a[INTSIZE]={11,2,35,41,65,2};
	sqlist L;
	initlist(&L);
	for(i=0;i<INTSIZE;i++)
	{
		intsert(&L,i+1,a[i]);
	}
	list(&L);
	putchar('\n');
	findele(&L,5);
	delment(&L,3);
	list(&L);
	putchar('\n');
	Plength(&L);
	Findele(&L,2);
}
