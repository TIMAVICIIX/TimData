#include<stdio.h>
#include<stdlib.h>
#define MAXVER 20
typedef char ElemType;
typedef struct node{
	int num;
	struct node *next;
}slink;
typedef struct{
	int kind;
	int vexnum;
	int arcnum;
	struct{
		ElemType vertex;
		slink *first;
	}ve[MAXVER];
}AdjList;

void CreGraph(AdjList *G,int k,int n,int e,ElemType a[]){
	int i,j,t;slink *s;
	G->kind=k;
	G->vexnum=n;
	G->arcnum=e;
	for(t=0;t<G->vexnum;t++){
		G->ve[t].vertex=a[t];
		G->ve[t].first=NULL;
	}
	printf("ÊäÈë%dÌõ±ß£¨»¡£©:\n",G->arcnum);
	for(t=0;t<G->arcnum;t++){
		scanf("%d%d",&i,&j);
		s=(slink *)malloc(sizeof(slink));
		s->num=j;
		s->next=G->ve[i].first;
		G->ve[i].first=s;
		if(!G->kind){
		s=(slink *)malloc(sizeof(slink));
		s->num=i;
		s->next=G->ve[j].first;
		G->ve[j].first=s;
		}
	}
} 

/*void List(AdjList *G){
	int i;slink *p;
	for(i=0;i<G->vexnum;i++){
		printf("%d:%c",i,G->ve[i].vertex);
		p=G->ve[i].first;
		while(p){
			printf("%3d",p->num);
			p=p->next;
		}
		putchar('\n');
	}
}*/

int visited[MAXVER];
void DFS(AdjList *G,int v){
	slink *p;
	printf("%3c",G->ve[v].vertex);
	visited[v]=1;
	p=G->ve[v].first;
	while(p){
		if(!visited[p->num]){
			DFS(G,p->num);
		}
		p=p->next;
	}
}

void DFSGraph(AdjList *G){
	int i;
	for(i=0;i<G->vexnum;i++){
		if(!visited[i])
		DFS(G,i);
	}
}

int main(){
	AdjList *G;
	ElemType a[5]={'A','B','C','D','E'};
	CreGraph(G,1,5,7,a);
	List(G);
}
