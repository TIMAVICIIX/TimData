#include<stdio.h>
#include<string.h>
int main(){
	char a='a';
	char b='\xaf';
	char *p="\\name\\\101ddress\b\xaf";
	char *q="\b";
	char *u="\xaf";
	int x=strlen(p);
	int y=strlen(q);
	printf("%d,%d,%d\n",a,x,y);
	puts(p);
	puts(u);
	puts(q);
}
