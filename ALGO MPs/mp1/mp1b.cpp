#include <iostream>
#include "Data.h"
#include "implementation.cpp"
//05-08-2021: Starting with the program
//05-10-2021: Fixing the format
using namespace std;
int main()
{
    int choice;
    arrayManipulation array;    
    
    do
    {
        cout << "\n\t======================" << endl;
        cout << "\t= Array Manipulation =" << endl;
        cout << "\t======================" << endl << endl;
        cout << "\t[1] Display "<< endl;
        cout << "\t[2] Insert " <<endl;
        cout << "\t[3] Delete "<<endl;
        cout << "\t[4] SWAP"<<endl;
        cout << "\t[5] Exit"<<endl << endl;
        cout << "\t======================" << endl << endl;
        cout << "\tEnter choice : ";
        cin >> choice;
        cout << endl;
        
        switch (choice) {
            case 1:
                array.display();
                system("sleep 1s");
                break;
            case 2:
                array.insert();
                 system("sleep 1s");
                break;
            case 3:
                array.deleteElement();
                 system("sleep 1s");
                break;
            case 4:
                array.swap();
                system("sleep 1s");
                break;
          case 5:
                exit(0);
           default:
                cout << "\tInvalid Input"<<endl;
                break;
        }
    }
    while (choice != 5);
 
    return 0;
    

}
