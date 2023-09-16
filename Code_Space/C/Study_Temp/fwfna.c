#include<stdio.h>
#include<stdlib.h>
static int j=1;
typedef struct node
{
int c;
int e;
struct node* next;
}pnode;
pnode *Creat(int m)
{
pnode *head,*p,*q;
int i;
p=head=(pnode*)malloc(sizeof(pnode));
for(i=1;i<=m;i++)
{
q=(pnode*)malloc(sizeof(pnode));
printf("请输入第%d个链表第%d项:",j,i);
scanf("%d%d",&q->c,&q->e);
p->next=q;
p=q;
}
p->next=NULL;
j++;
return head;
}
void polyadd(pnode *h1,pnode *h2)
{
pnode *h,*p1,*p2,*q;
h=h1;
p1=h1->next;p2=h2->next;
while(p1!=NULL&&p2!=NULL)
{
if(p1->e>p2->e)
{
h->next=p1;h=p1;p1=p1->next;
}
else if(p2->e>p1->e)
{
h->next=p2;h=p2;p2=p2->next;
}
else if(p1->c+p2->c!=0)
{
p1->c=p1->c+p2->c;
h->next=p1;h=p1;p1=p1->next;
q=p2;
p2=p2->next;
free(q);
}
else
{
q=p1;p1=p1->next;free(q);
q=p2;p2=p2->next;free(q);
}
}
if(p1!=NULL)
{h->next=p1;}
else{h->next=p2;}
free(h2);
}
void List(pnode *head)
{pnode *p=head->next;
while(p!=NULL)
{
	if(p!=head->next)
printf("+(%dx%d)",p->c,p->e);
	else
printf("(%dx%d)",p->c,p->e);
p=p->next;
}
putchar('\n');
}
int main()
{
	int i;
	pnode *h1,*h2;
	printf("第一个链表有几项:");
	scanf("%d",&i);
	h1=Creat(i);
	printf("第二个链表有几项:");
	scanf("%d",&i);
	h2=Creat(i);
	polyadd(h1,h2);
    printf("After:");
	List(h1);
	putchar('\n');
}

