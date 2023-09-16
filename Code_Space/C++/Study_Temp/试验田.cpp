//泛型类的研究 ，是库函数的由来 
#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int main(){ 
	unsigned int i;
	vector<string>List;
	List.insert(List.begin(),"This is a file!");
	List.insert(List.end(),"And we just do something in there!");
	List.insert(List.end(),"Bye!");
	for(i=0;i<List.size();i++)
		cout<<List[i]<<endl;
		for_each(List .begin(),List.end(),PrintLine);
}
