#include<iostream>
#include<string>
using namespace std;

class Person{
	private:
		string identifier;
		string name;
	public:
		Person(){
			cout<<"Please input ID:";
			cin>>identifier;
			cout<<"Please input name";
			cin>>name;
		}
		
		void Show_Person(){
			cout<<"Person's ID"<<identifier<<endl;
			cout<<"Person's name"<<name<<endl;
		}
};

class Student:public Person{
	private:
		int Class_num;
		double score;
	public:
		Student(){
			cout<<"Please input your Class number:";
			cin>>Class_num;
			cout<<"Please input your score:";	
			cin>>score;
		}
		
		Show_Student(){
			cout<<"The Student:"<<endl;
			Show_Person();
			cout<<"The Student's Class num is:"<<Class_num<<endl;
			cout<<"The Student's score is:"<<score<<endl;
		}
};

class Teacher:public Person{
	private:
		string work;
		string department;
	public:
		Teacher(){
			cout<<"Please input your work:";
			cin>>work;
			cout<<"Please input your department:";	
			cin>>department;
		}
		
		Show_Teacher(){
			cout<<"The Teacher:"<<endl;
			Show_Person();
			cout<<"The Tercher's work is:"<<work<<endl;
			cout<<"The Teacher's department is:"<<department<<endl;
		}
};

int main(){
	Student S;
	cout<<endl;
	S.Show_Student();
	cout<<endl;
	Teacher T;
	cout<<endl;
	T.Show_Teacher();
}
