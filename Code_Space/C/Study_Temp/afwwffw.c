#include<stdio.h>
#include<stdlib.h>
typedef int Ele;
typedef struct node
{
	Ele data;
	struct node *next;

}slink;

slink *Crelink(int n)
{
  slink *head,*p,*s;
  int i;
  p=head=(slink *)malloc(sizeof(slink));
  for(i=1;i<=n;i++)
  {
  s=(slink *)malloc(sizeof(slink));
  printf("Please int num:");
  scanf("%d",&s->data);
  p->next=s;
  p=s;
  }
  p->next=NULL;
  return head;
}
 
void List(slink *head)
{
slink *p;
p=head->next;
while(p!=NULL)
{printf("%d ",p->data);
 p=p->next;
}
putchar('\n');
}

void Sort(slink *L)
{
slink *p,*q,*s,*r;
p=L;
while(p->next!=NULL)
{
	q=p->next;
	r=p;
	while(q->next!=NULL)
	{
	if(q->next->data<r->next->data)
		r=p;
		q=q->next;
	}
	if(r!=p)
	{
	s=r->next;
	r->next=s->next;
	s->next=p->next;
	p->next=s;
	}
	p=p->next;
	}
}

void Turn(slink *L)
{
	slink *q,*p;
	p=L->next;
	L->next=NULL;
	while(p)
	{
	q=p;
	p=p->next;
	q->next=L->next;
	L->next=q;
	}
}

int main()
{
	int i;
	slink *head;
	printf("Please intput number:");
	scanf("%d",&i);
	head=Crelink(i);
	List(head);
	Sort(head);
	List(head);
	Turn(head);
	List(head);
}