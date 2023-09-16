#include<stdio.h>
#include<stdlib.h>
#define INTSIZE 100
typedef struct{
char *ch;
int length;
int strsize;
}SeqStr;

void List(SeqStr *s){
int i;
for(i=0;i<s->length;i++){
printf("%c ",s->ch[i]);
}
putchar('\n');
}

void IntString(SeqStr *s){
s->ch=(char *)malloc(INTSIZE* sizeof(char));
s->length=0;
s->strsize=INTSIZE;
}

void StrAssign(SeqStr *s1,char *s2){
int i=0;
while(s2[i]!='\0')i++;
if(i>s1->strsize)
{
	s1->ch=(char*)realloc(s1->ch,i*sizeof(char));
	s1->strsize=i;
}
s1->length=i;
for(i=0;i<s1->length;i++)
s1->ch[i]=s2[i];
}

int Replace(SeqStr *s,int i,int j,SeqStr *t){
int k;
if(i<1||i>s->length||j<1||j>s->length-i+1)return 0;
if(j<t->length)
{if(s->length+t->length-j>s->strsize)
	{
	s->ch=(char*)realloc(s->ch,(s->length+t->length-j)*sizeof(char));
	s->strsize=s->length+t->length-j;
	}
	for(k=s->length-1;k>=i+j-1;k--)
	{s->ch[k-j+t->length]=s->ch[k];List(s);}
}
else
	for(k=i-1+j;k<s->length;k++)
	{s->ch[k-j+t->length]=s->ch[k];List(s);}
	s->length=s->length+t->length-j;
	for(k=0;k<t->length;k++)
	{s->ch[k+i-1]=t->ch[k];List(s);}
	return 1;
}


int main(){
SeqStr s,q;char a[10],b[10];
printf("input first str:");
gets(a);
IntString(&s);
StrAssign(&s,a);
List(&s);
printf("input last str:");
gets(b);
IntString(&q);
StrAssign(&q,b);
List(&q);
printf("After:\n");
Replace(&s,3,2,&q);
}
