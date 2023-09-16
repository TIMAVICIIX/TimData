#include<iostream>

using namespace std;



class A

{

    private:

        int u;

        static int s;

    public:

        A(int x){u=x; s+=x;}

        static void show()

        {

            cout<<"s="<<s<<endl;

        }

        void display(){cout<<"u="<<u<<"s="<<s<<endl;}

};

int A::s=1000;

int main()

{

    A::show();

    A a1(5);

    a1.show();

    a1.display();

    A a2(8);

    a2.show();

    a2.display();

    return 0;
}



