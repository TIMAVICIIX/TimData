#include<stdio.h>
#define PAI 3.14
int main(){
	double arae,line;
printf("Input the line:");
scanf("%lf",&line);
arae=PAI*(line*line)/2;
printf("The arae is:%.4lf",arae);
return 0;
}