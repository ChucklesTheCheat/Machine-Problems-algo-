#include <iostream>
#include "Data.h"
#include "Implementation.cpp"
// LOG BOOK:
// 05/09/2021: started working on the code -Rj and Renee
// 05/10/2021: started working on the format -Rj and Renee
// 05/11/2021: finalizing the format -Rj and Renee

using namespace std;
int main()
{
    doublyLinkedList dl;
    int num;
    system("clear"); 
    cout << endl;
    cout << "\t=============== |MP problem 3| ==================" << endl;
    cout << "\tEnter the amount of the array will be: ";
    cin >> num;
    cout << endl;
    int arr[num];

    /* start with empty linked list */
    Node *start = NULL;
   
    cout << "\tPlease enter approximately " << num << " elements: ";
    for (int i = 0; i < num; i++)
    {
      cin >> arr[i];
      dl.insertAtTheBegin(&start, arr[i]);
    }
    system("clear");
    cout << "\t================== |Results| ====================" << endl;
        
    /* print list before sorting */
    dl.printList(start);
    cout << endl;
    dl.bubbleSort(start);
    //print list after sorting
    dl.printList(start);

    return 0;
}
