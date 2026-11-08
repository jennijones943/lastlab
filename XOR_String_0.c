#include<stdlib.h>
#include<stdio.h>
void main(){
    char str[]="Hello World";
    char xor[12];
    int i,len;
    //len=strlen(str);
    for(i=0;i<11;i++){
        xor[i]=str[i]^0;
        printf("%c",xor[i]);
    }
}