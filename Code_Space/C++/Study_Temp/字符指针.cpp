#include<iostream>

using namespace std;



class Dog{

	private:

		string name;

		int age;

		static int Dogs;

	public:

		Dog(string name,int age){

			this->name=name;

			this->age=age;

			Dogs++;

		}

		static int Get_Dogs(){

			return Dogs;

		}

		void Show_Dogs(){

			cout<<"Dog's name:"<<name<<endl<<"Age:"<<age<<endl;

		}

};



int Dog::Dogs=0;



int main(){

	Dog D[3]={Dog("Black",4),Dog("Yellow",6),Dog("Red",9)};

	for(int i=0;i<3;i++){

		D[i].Show_Dogs();

	}

	cout<<"Have "<<Dog::Get_Dogs()<<" Dogs!"<<endl;

}


