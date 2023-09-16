#include<stdio.h>
#include<stdlib.h>
typedef struct node{
	char ch;
	struct node *next;
}LinkStr;

int Function[100]={0};

LinkStr *Initstring(void){
	LinkStr *s;
	s=(LinkStr *)malloc(sizeof(LinkStr));
	s->next=NULL;
	return s;
}

void StrAssign(LinkStr *s,char *t){
	int i;LinkStr *p,*q,*r;
	r=s;q=s->next;
	for(i=0;t[i]!='\0';i++){
		if(q!=NULL){
			q->ch=t[i];r=q;q=q->next;
		}
		else{
			p=(LinkStr*)malloc(sizeof(LinkStr));
			p->ch=t[i];
			r->next=p;
			r=p;
		}
	}
	r->next=NULL;
	while(q!=NULL){
		p=q->next;free(q);q=p;
	}
}

int Length(LinkStr *s){
	LinkStr *p;int n=0;
	p=s->next;
	while(p!=NULL){
		n++;p=p->next;
	}
	return n;
}


int Brute_Force(LinkStr *s,LinkStr *t,int pos,int n){
	int i,c=0,m;LinkStr *p,*q,*r;
	if(pos<1)return 0;
	for(i=0,r=s;i<pos&&r;i++,r=r->next);
	if(!r)return 0;
	while(r){
		p=r;q=t->next;
		while(p&&q&&q->ch==p->ch){
			p=p->next;q=q->next;
		}
		if(!q){
			Function[c++]=i;
			i+=n;
			for(m=0;m<n;m++){
				r=r->next;
			}
		}
		else
		{
			i++;r=r->next;
		}
	}return 0;
}

void PrintConclution(){
	int i;
	for(i=0;Function[i]!=0;i++){
		printf("The %d one is located %d\n",i+1,Function[i]);
	}
}

int main(){
	LinkStr *s=Initstring();
	LinkStr *t=Initstring();
	char ms[100],mt[100];int a,n;
	printf("Please input primary char:");
	gets(ms); StrAssign(s,ms);
	printf("Please input vice char:");
	gets(mt);StrAssign(t,mt);
	printf("Where to pos:");
	scanf("%d",&a);
	n=Length(t);
	Brute_Force(s,t,a,n);
	PrintConclution();
}
