#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main()
{
    int i;
char str[] = "Hello World";
for (i = 0;str[i]!='\0' ;i++) {
printf("%c",str[i]^127);
}
for (i = 0;str[i]!='\0' ;i++) {
printf("%c",str[i] & 127);
}
printf("\n");
return 0;
}