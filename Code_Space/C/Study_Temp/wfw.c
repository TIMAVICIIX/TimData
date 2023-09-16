#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define INTSIZE 100
typedef char Ele;
typedef struct{
Ele *base;
int top;
int stackSize;
}seqStack;

void intSize(seqStack *S){
S->base=(Ele*)malloc(INTSIZE*sizeof(Ele));
S->top=0;
S->stackSize=INTSIZE;
}

int getLen(seqStack *S){
return (S->top);
}

int getTop(seqStack *S,Ele *e){
if(S->top==0)return 0;
*e=S->base[S->top-1];
return 1;
}

int Push(seqStack *S,Ele x){
	if(S->top>=S->stackSize){
	S->base=(Ele *)realloc(S->base,(S->stackSize+1)*sizeof(Ele));
	if(!S->base)return 0;
	S->stackSize++;
	}
	S->base[S->top++]=x;
	return 1;
}

int Pop(seqStack *S,Ele *e){
if(S->top==0)return 0;
*e=S->base[--S->top];
}

void List(seqStack *S){
int i;
	for(i=S->top-1;i>=0;i--){
		printf(" %c",S->base[i]);
	}
	putchar('\n');
}

int emptyStack(seqStack *S){
	if(S->top==0){printf("Empty!");return 1;}
	else return 0;
}

int Match(Ele *exps){
int i=0,nomatch=0;
seqStack S;
Ele x;
intSize(&S);
while(!nomatch&&exps[i]!='\0'){
	switch(exps[i]){
	case '(':
	case '[':
	case '{':Push(&S,exps[i]);break;
	case ')':getTop(&S,&x);
		if(x=='(')Pop(&S,&x);
		else nomatch=1;
		break;
	case ']':getTop(&S,&x);
		if(x=='[')Pop(&S,&x);
		else nomatch=1;
		break;
	case '}':getTop(&S,&x);
		if(x=='{')Pop(&S,&x);
		else nomatch=1;
		break;
	}
	i++;
}
if(emptyStack(&S)&&!nomatch)return 1;
 return 0;
}

int main(){
Ele numChar[INTSIZE];
gets(numChar);
printf("%d\n",Match(numChar));
}
