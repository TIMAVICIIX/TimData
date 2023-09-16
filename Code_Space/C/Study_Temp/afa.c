#include <stdio.h>
#include <stdlib.h>
typedef struct node
{
	int data;
	struct node *next;
}pnode;
pnode *creat(int m)
{
	pnode *head,*p,*q;
	int i;
	p=head=(pnode*)malloc(sizeof(pnode));
	for(i=1;i<=m;i++)
	{
		q=(pnode*)malloc(sizeof(pnode));
		printf("Please input number:");
		scanf("%d",&q->data);
		p->next=q;
		p=q;
	}
	p->next=NULL;
	return head;
}
void list(pnode *head)
{
	pnode *p=head->next;
	while(p!=NULL)
	{
		printf("%d->",p->data);
		p=p->next;
	}
	printf("\n");
}
void Sort(pnode *ll)
{pnode *p,*q,*r,*s;
 p=ll;
 while(p->next!=NULL)
 { q=p->next;
  r=p;
  while(q->next!=NULL)
  { if(q->next->data>r->next->data)
  r=q;
  q=q->next;
  }
  if(r!=p)
  {s=r->next;
  r->next=s->next;
  s->next=p->next;
  p->next=s;
  }
  p=p->next;
  }
 }
 int main()
 {
  pnode *head;int i;
  printf("How many num do List have?");
  scanf("%d",&i);
  head=creat(i);
  list(head);
  Sort(head);
  list(head);
 return 0;
 }
