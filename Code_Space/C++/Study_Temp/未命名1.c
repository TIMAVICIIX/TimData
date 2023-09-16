#include<stdio.h>
#include<stdlib.h>

static int Two_Counts=0;
static int One_Counts=0;

typedef char ElemType;
typedef struct node{
	ElemType data;
	struct node *lchild,*rchild;
}BitTree;

BitTree* Create_Tree(){
	BitTree *bt;
	ElemType x;
	scanf("%c",&x);
	if(x==' ')
	bt=NULL;
	else{
		bt=(BitTree *)malloc(sizeof(BitTree));
		bt->data=x;
		bt->lchild=Create_Tree();
		bt->rchild=Create_Tree();
	}
	return bt;
}

void PreOrder(BitTree *bt){
	if(bt!=NULL){
		printf("%4c",bt->data);
		PreOrder(bt->lchild);
		PreOrder(bt->rchild);
	}
	
}

void InOrder(BitTree *bt){
	if(bt!=NULL){
		InOrder(bt->lchild);
		printf("%4c",bt->data);
		InOrder(bt->rchild);
	}
	
}

void PostOrder(BitTree *bt){
	if(bt!=NULL){
		PostOrder(bt->lchild);
		PostOrder(bt->rchild);
		printf("%4c",bt->data);
	}
	
}

int Find_Count_Two(BitTree *bt){
if(bt->lchild!=NULL){
		if(bt->lchild!=NULL&&bt->rchild!=NULL){
			Two_Counts++;
		}
		Find_Count_Two(bt->lchild);
	}
if(bt->rchild!=NULL){
		if(bt->rchild!=NULL&&bt->lchild!=NULL){
			Two_Counts++;
		}
		Find_Count_Two(bt->lchild);
}
}


int Find_Count_One(BitTree *bt){
if(bt->lchild!=NULL){
	One_Counts++;
	Find_Count_One(bt->lchild);
}
else if(bt->rchild!=NULL){
	One_Counts++;
	Find_Count_One(bt->rchild);
}


}

int main(){
	BitTree *bt=Create_Tree();
	PreOrder(bt);
	putchar('\n');
	InOrder(bt);
	putchar('\n');
	PostOrder(bt);
	putchar('\n');
	Find_Count_One(bt);
	Find_Count_Two(bt);
	printf("Count_Two has %d",Two_Counts);
	putchar('\n');
	printf("Count_One has %d",One_Counts);
}
