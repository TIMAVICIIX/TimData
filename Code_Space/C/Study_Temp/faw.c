/*��԰����ѩ
�����ߡ�ë�� 
������⣬ǧ����⣬����ѩƮ��
���������⣬Ω��çç��������£���ʧ���ϡ�
ɽ�����ߣ�ԭ�����������칫�Աȸߡ�
�����գ�����װ�ع���������次�
��ɽ��˶ཿ��������Ӣ�۾�������
ϧ�ػʺ��䣬�����Ĳɣ��������棬��ѷ��ɧ��
һ���콾���ɼ�˼����ֻʶ�乭����
�����ӣ���������������񳯡�*/
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