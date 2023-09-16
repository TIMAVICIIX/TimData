#include<iostream>
using namespace std;

class Vehicle{
	protected:
		int wheels;
		int weight;
	public:
		Vehicle(int wheels,int weight){
			this->weight=weight;
			this->wheels=wheels; 
		}
		
		void Show_Vehicle(){
			cout<<"wheels:"<<wheels<<endl;
			cout<<"weight:"<<weight<<endl;
		}
};

class Car:private Vehicle{
	private:
		int passengerLoad;
	public:
		Car(int passengerLoad,int wheels,int weight):Vehicle(wheels,weight){
			this->passengerLoad=passengerLoad;
		} 
		
	void Show_Car(){
		cout<<"\nCar:"<<endl;
		Vehicle::Show_Vehicle();
		cout<<"PassengerLoad:"<<passengerLoad<<endl;
	}
};

class Truck:private Vehicle{
	private:
		int passengerLoad;
		int payload;
	public:
		Truck(int passengerLoad,int payload,int wheels,int weight):Vehicle(wheels,weight){
			this->passengerLoad=passengerLoad;
			this->payload=payload;
		}
		
		void Show_Truck(){
			cout<<"\nTruck:"<<endl;
			Vehicle::Show_Vehicle();
			cout<<"Passenger_Load:"<<passengerLoad<<endl;
			cout<<"Pay Load:"<<payload<<endl;
		}
};

int main(){
	Car C(7,4,45);
	C.Show_Car();
	Truck T(7,432,8,89);
	T.Show_Truck();
}
