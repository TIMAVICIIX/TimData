#include<stdio.h>
#define N 10
struct stu
{
	char num[20];
	char name[20];
	int score;
};
int main()
{
	struct stu STU[N],t;
	char T[]="PASS";
	char F[]="NOPASS";
	int i,j;double p;
	for(i=0;i<N;i++)
	{
	printf("�������%d������:\n",i+1);
	printf("ѧ��:");scanf("%s",STU[i].num);
	printf("����:");scanf("%s",STU[i].name);
	printf("�ɼ�:");scanf("%d",&STU[i].score);
	}
	for(i=0;i<N-1;i++)
	{
		for(j=0;j<N-1-i;j++)
		{
			if(STU[j].score>STU[j+1].score)
			{
				t=STU[j];
				STU[j]=STU[j+1];
				STU[j+1]=t;
			}
		}
	}
	p=N*0.4;
	for(i=0;i<N;i++)
	{
	printf("��%d������:\n",i+1);
	printf("ѧ��:%s",STU[i].num);
	printf("����:%s",STU[i].name);
	printf("�ɼ�:%d",STU[i].score);
	printf("\n���:");
	if((double)i+1<=p)
		puts(F);
	else
		puts(T);
	putchar('\n');
	}
}
