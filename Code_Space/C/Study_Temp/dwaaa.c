#include<stdio.h>
void fun( int *px, int *py)

 {

 int a=0,b=0,k; //

 scanf("%d",&k);

 while (k!=0) //

 {

 if(k>0) a++;

 if(k<0) b++;

  //

}

 *px=a; *py=b;

 }

int main(void)

{

    int  littleZreo,bigZero;



    fun(&littleZreo,&bigZero);



    printf("С��0�����ĸ���:%d,����0�����ĸ���:%d\n",littleZreo,bigZero);



    return 0;

}