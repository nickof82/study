#include<stdlib.h>  
#include<stdio.h>  
//多级指针 n级指针 用来保存n-1级指针的地址  2级指针用来保存1级指针的地址  3级指针用来保存2级指针的地址
//用1级指针保存1级指针的地址 可以编译运行 但是 只能存不能做 **p的操作 保存指针变量的地址还是要使用多级指针 
main(){  
      int i = 123;
      int* p = &i;
      int q = &p;
      //**q = 456;
      int** p2 = &p;
      //有几个*就是几级指针   
      int*** p3 = &p2;
      
      ***p3 = 456;
      printf("i = %d\n",i); 
       system("pause"); 
       } 
