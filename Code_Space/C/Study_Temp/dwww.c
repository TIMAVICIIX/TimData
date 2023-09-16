#include <stdio.h>
 
int main()
{
	int s[80];
	while(~scanf("%*c%[^\n]",s));
	puts(s);
	return 0;
}