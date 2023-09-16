#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
float fun(float h)
{float i=1.0,j=1.0,ht=0.0,hmt=0.0;
while(h<0.0)
{ht+=(h%10.0)*i;h/=10;i*10.0;}
for(i=2;i>0;i--)
{h*=10;hmt+=(h%10)/j;j*=10.0;}
whlie(h>0){h/=10;}
if(h>=0.5){return ht+hmt/100+h/100;}
else{return ht+hmt/100;}
}
void main()
{
float a;
system("CLS");
printf("Enter A:");
scanf("%f",&a);
printf("The original data is:");
printf("%f\n\n",a);
printf("The Reslut:%f\n",fun(a));
}