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
  slink *head,*k,*s;
  int i;
  k=head=(slink *)malloc(sizeof(slink));
  for(i=1;i<=n;i++)
  {
  s=(slink *)malloc(sizeof(slink));
  printf("Please int num:");
  scanf("%d",&s->data);
  k->next=s;
  k=s;
  }
  k->next=NULL;
  return head;
}
 
void List(slink *head)
{
slink *k;
k=head->next;
while(k!=NULL)
{printf("%d ",k->data);
 k=k->next;
}
putchar('\n');
}

void Sort(slink *L)
{
slink *k,*q,*s,*r;
k=L;
while(k->next!=NULL)
{
	q=k->next;
	r=k;
	while(q->next!=NULL)
	{
	if(q->next->data>r->next->data)
		r=q;
		q=q->next;
	}
	if(r!=k)
	{
	s=r->next;
	r->next=s->next;
	s->next=k->next;
	k->next=s;
	}
	k=k->next;
	}
}

int main()
{
	int i;
	slink *head;
	printf("Please intput number:");
	scanf("%d",&i);
	head=Crelink(i);
	printf("Before:");
	List(head);
	printf("After:");
	Sort(head);
	List(head);
}