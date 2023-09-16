//设链表中每个节点包括学号，成绩和指针三个字段，试编程序将大于平均成绩的各个节点打印出来
#include<stdio.h>
#include<stdlib.h>
typedef struct node
{
	double score;
	char num[20];
	struct node *next;

}slink;
void List(slink *head,double ave)
{
slink *p;
p=head->next;
printf("The average is %.2lf\n",ave);
printf("Output scores who on the average:");
while(p!=NULL)
{if(p->score>ave){printf("%s  %.2lf",p->num,p->score);}
 p=p->next;
}
putchar('\n');
}
void *Crelink(int n)
{
  slink *head,*p,*s;
  int i;double ave=0.0;
  p=head=(slink *)malloc(sizeof(slink));
  for(i=1;i<=n;i++)
  {
  s=(slink *)malloc(sizeof(slink));
  printf("Please int num:");
  scanf("%s",s->num);
  printf("Please input score:");
  scanf("%lf",&s->score);
  p->next=s;
  p=s;
  ave+=s->score/n;
  }
  p->next=NULL;
  List(head,ave);
}
int main()
{
	int i;
	slink *head;
	printf("Please intput student menber:");
	scanf("%d",&i);
	head=Crelink(i);
}