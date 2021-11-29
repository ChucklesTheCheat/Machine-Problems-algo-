#include <stdio.h>
#include "Data.h"
#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;
 
/* Function to insert a node at the beginning of a linked list */
void doublyLinkedList::insertAtTheBegin(Node **start_ref, int data)
{
    struct Node *ptr1 = new Node;
    ptr1->data = data;
    ptr1->next = *start_ref;
    if (*start_ref != NULL)
       (*start_ref)->prev = ptr1;
    *start_ref = ptr1;
}
  
/* Function to print nodes in a given linked list */
void doublyLinkedList::printList(Node *start)
{
  
    ofstream doublyFile ("doublyFile.txt", std::ios_base::app);
    //write to text file
    doublyFile << endl;
    doublyFile << right << setw(15) << "ADDRESS";
    doublyFile << right << setw(15) << "PREV";
    doublyFile << right << setw(10) << "DATA";
    doublyFile << right << setw(15) << "NEXT";
    doublyFile << endl;
    
    cout << endl;
    cout << right << setw(15) << "ADDRESS";
    cout << right << setw(15) << "PREV";
    cout << right << setw(10) << "DATA";
    cout << right << setw(15) << "NEXT";
    cout << right << setw(15) << endl;
    
    
    Node* last;
    while (start != NULL)
    {
        last = start;
        start = start->next;
    }
  
    while (last != NULL)
    {
          
        cout << right << setw(15) << last; //address
        cout << right << setw(15) << last->next; //next
        cout << right << setw(10) << last->data; //data
        cout << right << setw(15) << last->prev; //prev
        cout << endl;
        
        //write to text file
        doublyFile << right << setw(15) << " " << last; //tinang gal ko yung  << '\t'
        doublyFile << right << setw(15) << " " << last->next;
        doublyFile << right << setw(10) << " " << last->data;
        doublyFile << right << setw(15) << " " << last->prev;
        doublyFile << endl;
        
        last = last->prev;
    }
    doublyFile.close();
}
  
/* Bubble sort the given linked list */
void doublyLinkedList::bubbleSort(Node *start)
{
    int swapped, i;
    Node *ptr1;
    Node *lptr = NULL;
    Node *temp;
    /* Checking for empty list */
    if (start == NULL)
        return;
  
    do
    {
        swapped = 0;
        ptr1 = start;
        while (ptr1->next != lptr)
       {
           if (ptr1->data < ptr1->next->data) //a < b
            {
                //swap(ptr1 -> data, ptr1->next -> data); no need na
                // 6 <- 5 <- 4 <- 3 <- 2 <- 1 (start) (654321 input) works
                // 6 <- 4 <- 1 <- 2 <- 3 <- 5 (start) (64123 input) works
                // 1 <- 2 <- 6 <- 4 <- 3 <- 5 (start) works
                //two inputs  6 <- 5 (start) works
                //have yet to try more inputs pls try and report thx
                temp = ptr1 -> next;
                if(ptr1 -> prev == NULL) {  //if at start
                  ptr1 -> next = ptr1 -> next -> next;
                  ptr1 -> prev = temp;
                  temp -> next = ptr1;
                  temp -> prev = NULL;
                  if(ptr1 -> next) { //if only two elements since you dont need to configure the prev of the next of the next of start
                    ptr1 -> next -> prev = ptr1;
                  }
                  start = temp;
                }
                else if(ptr1 -> next != NULL) { //if not at start
                  if(ptr1 -> next -> next != NULL) { //if at middle
                    ptr1 -> next = ptr1 -> next -> next;
                    ptr1 -> next -> prev = ptr1;
                    ptr1 -> prev -> next = temp;
                    temp -> prev = ptr1 -> prev;
                    ptr1 -> prev = temp;
                    ptr1 -> prev -> next = ptr1;
                  }
                  else { //if at second to the last
                    ptr1 -> next = NULL;
                    ptr1 -> prev -> next = temp;
                    temp -> prev = ptr1 -> prev;
                    ptr1 -> prev = temp;
                    temp -> next = ptr1;
                  }
                }    
                ptr1 = temp; //in order to keep skipping order when nodes are swapped e.g. 123456 instead of 136
                swapped = 1;
            }
            ptr1 = ptr1->next;
        }
      
        lptr = ptr1;
    }
    while (swapped);
}


