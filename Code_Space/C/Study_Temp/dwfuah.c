#include <stdio.h>

	typedef union student

	{  char name[10];

	   long sno;

	   char sex;

	   float score[4];

	} STU;

	void main()

	{  STU a[4];

	   printf("%d\n",sizeof(a));

	}