/*沁园春·雪
【作者】毛泽东 
北国风光，千里冰封，万里雪飘。
望长城内外，惟余莽莽；大河上下，顿失滔滔。
山舞银蛇，原驰蜡象，欲与天公试比高。
须晴日，看红装素裹，分外妖娆。
江山如此多娇，引无数英雄竞折腰。
惜秦皇汉武，略输文采；唐宗宋祖，稍逊风骚。
一代天骄，成吉思汗，只识弯弓射大雕。
俱往矣，数风流人物，还看今朝。*/
#include<stdio.h>
#include<stdlib.h>
#define N 2
int main()
{
	FILE *fp;
	char poem[N][1000],(*p)[1000]=poem,ch='\n';
	int i;
	for(i=0;i<N;i++)
	{
		gets(*(p+i));
	}
	if((fp=fopen("D:\\text.txt","w+"))==NULL)
	{printf("ERROR!\n");exit(0);}
	else
	{printf("DONE!\n");}
	for(i=0;i<N;i++)
	{
		fputs(*(p+i),fp);
		fputc(ch,fp);
	}
	rewind(fp);
	ch=fgetc(fp);
	while(ch!=EOF){
	putchar(ch);
	ch=fgetc(fp);
	}
	fclose(fp);

	
}