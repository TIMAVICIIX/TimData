#include<iostream>
#include<string>
using namespace std;

typedef struct {
			int year;
			int month;
			int day;
}Brith_Day;

class Person{
	private:
		string ID_Preson;
		string name;
		string Sex;
		Brith_Day B;		
		string *Home_Address;
	public:
	Person(string ID_Preson,string name,string Sex,Brith_Day B,string Home_Address){
		this->ID_Preson=ID_Preson;
		this->name=name;
		this->Sex=Sex;
		this->B=B;
		int Length=Home_Address.length();
		this->Home_Address=new string[Length+1];
		*(this->Home_Address)=Home_Address;
	}
	Person(Person &P){
		this->ID_Preson=P.ID_Preson;
		this->name=P.name;
		this->Sex=P.Sex;
		this->B=P.B;
		int Length=P.Home_Address->length();
		this->Home_Address=new string[Length+1];
		*(this->Home_Address)=*(P.Home_Address);
	}
	
	void Print_Format(){
		cout<<"ID:"<<ID_Preson<<endl<<"Name:"<<name<<endl<<"Sex:"<<Sex<<endl;
		cout<<"Brith Day:"<<B.year<<"year,"<<B.month<<"month,"<<B.day<<"day"<<endl;
		cout<<"Home_Address:"<<*(Home_Address)<<endl<<endl;
	}
}; 

int main(){
	Person P1("522725200312020058","wzh","Man",{2003,12,02},"China");
	P1.Print_Format();
	Person P2(P1);
	P2.Print_Format();
}