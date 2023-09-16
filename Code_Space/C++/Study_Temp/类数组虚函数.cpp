#include<iostream>
using namespace std;

class area_cl{

    protected:

        double height;

        double width;

public:

        area_cl (double r, double s){ height= r;width=s;}

        virtual double area()=0;

};

int main(){
	
}
