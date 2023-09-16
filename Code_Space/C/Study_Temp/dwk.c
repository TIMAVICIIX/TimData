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
	printf("请输入第%d个数据:\n",i+1);
	printf("学号:");scanf("%s",STU[i].num);
	printf("姓名:");scanf("%s",STU[i].name);
	printf("成绩:");scanf("%d",&STU[i].score);
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
	printf("第%d个数据:\n",i+1);
	printf("学号:%s",STU[i].num);
	printf("姓名:%s",STU[i].name);
	printf("成绩:%d",STU[i].score);
	printf("\n结果:");
	if((double)i+1<=p)
		puts(F);
	else
		puts(T);
	putchar('\n');
	}
}
