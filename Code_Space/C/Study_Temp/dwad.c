#include<stdio.h>
#include<stdlib.h>
#define N 80
int main()
{
	FILE *fp;
	char ch;
	int i;
	if((fp=fopen("D:\\text.txt","r"))==NULL)
	{printf("ERROR!\n");exit(0);}
	else
	{printf("DONE!\n");}
	ch=fgetc(fp);
	while(ch!=EOF){
		if(ch>='A'&&ch<='Z')
		{ch+=32;putchar(ch);}
		else{putchar(ch);}
	 ch=fgetc(fp);
	}
	putchar('\n');
	fclose(fp);
}
