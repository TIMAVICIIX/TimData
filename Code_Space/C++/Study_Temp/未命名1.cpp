#include<stdio.h>
#include<iostream>
#include<stdlib.h>
#include<math.h>
#include<algorithm>
#define MAX 99999
using namespace std;
int main()
{
    int num,c[10][10],i,j,temp[10],minCost=MAX,cost=0;
    cout<<"输入任务个数:\n";
    cin>>num;
    cout<<"输入成本矩阵\n";
    for(i=1;i<=num;i++){            //????????
        for(j=1;j<=num;j++)
            cin>>c[i][j];
        temp[i]=i;                  //?????????,????
    }
    do{                             //??next_permutation????????????
        cost=0;
        for(i=1;i<=num;i++)
            cost+=c[i][temp[i]];
        if(cost<minCost)minCost=cost;           //??????
    }while(next_permutation(temp+1,temp+1+num));
    cout<<"最小成本:\n"<<minCost;
    return 0;
}

