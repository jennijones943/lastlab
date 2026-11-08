#include<stdlib.h>
#include<stdio.h>

void main(){

    char *str="Hello World";

    char xor[12];
    char and[12];
    char or[12];

    for(int i=0;i<11;i++){
        xor[i]=str[i]^127;
        printf("%c",xor[i]);
    }
    printf("\n");
    for(int i=0;i<11;i++){
        and[i]=str[i]&127;
        printf("%c",and[i]);
    }
    printf("\n");
    for(int i=0;i<11;i++){
        or[i]=str[i]|0;
        printf("%c",or[i]);
    }
}