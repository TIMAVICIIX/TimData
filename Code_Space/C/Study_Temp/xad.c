#include <stdio.h>

 

void  fun(int x, int y, int *z)

{
int a=0,b=0;
a+=x%10*1000;
a+=x/10*10; 
b+=y%10*100;
b+=y/10;
*z=a+b;
}

 

int main(void)

{

    int a, b, c;

 

    printf("input a,b:");

    scanf("%d %d",&a,&b);

 

    fun(a,b,&c);

    printf("c:%d\n",c);

 

    return 0;

}
