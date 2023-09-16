#include<stdio.h>
#include<string.h>
#include<conio.h>
#include<stdlib.h>
#define N 10
typedef struct ss
{
	char num[10];
	int s;
}STU;
fun(STU a[],STU *s)
{int i;
s->s=a[0].s;
for(i=0;i<N;i++){
	if(s->s>a[i].s){s->s=a[i].s;strcpy(s->num,a[i].num);}
}
}
int main(){
	STU a[N]={{"A01",81},{"A02",89},{"A03",66},{"A04",87},{"A05",77},{"A07",79},{"A08",61},{"A08",61},{"A09",80},{"A10",71}},m;
	int i;
	system("CLS");
	printf("*****The original data******\n");
	for(i=0;i<N;i++){
	printf("No=%s Mark=%d\n",a[i].num,a[i].s);
	}
	fun(a,&m);
	printf("****The Result****\n");
	printf("The lowest:%s,%d\n",m.num,m.s);
}