#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define MAXSIZE 100
typedef char ElemType;
#define VirNode '0'
typedef ElemType SeqTree[MAXSIZE];

void CreBiTree(SeqTree bt,int n){
	int i=1,j,m=0;
	while(m<n){
		for(j=i;j<2*i;j++){
			scanf("%c",bt+j);
			if(bt[j]!=VirNode)m++;
		}
		i=2*i;
	}
	bt[0]=i-1;
}

void LevelTree(SeqTree bt){
	int i=1,j;
	int count=bt[0]/2,ceng=0;
	int scount=count;
	while(i<=bt[0]){
		for(j=i;j<2*i;j++){
			while(scount){
				putchar(' ');
				scount--;
			}
			if(bt[j]==VirNode)printf("0 ");
			else printf("%c ",bt[j]);
		}
			putchar('\n');
			i=2*i;
			count=count-(pow(2,ceng));
			ceng++;
			scount=count;
	}
}

void PerOrder(SeqTree bt,int i){
	if(i<=bt[0]&&bt[i]!=VirNode){
		printf("%4c",bt[i]);
		PerOrder(bt,i*2);
		PerOrder(bt,2*i+1);
	}
}

void InOrder(SeqTree bt,int i){
	if(i<=bt[0]&&bt[i]!=VirNode){
		InOrder(bt,i*2);
		printf("%4c",bt[i]);
		InOrder(bt,2*i+1);
	}
}

void PostOrder(SeqTree bt,int i){
		if(i<=bt[0]&&bt[i]!=VirNode){
		PostOrder(bt,i*2);
		PostOrder(bt,2*i+1);
		printf("%4c",bt[i]);
	}
}

int main(){
	SeqTree bt;
	CreBiTree(bt,6);
	printf("Level_Tree(Changed):\n");
	LevelTree(bt);
	printf("\nPerOrder_Tree:\n");
	PerOrder(bt,1);
	printf("\nInOrder_Tree:\n");
	InOrder(bt,1);
	printf("\nPostOrder_Tree:\n");
	PostOrder(bt,1);
	
}
