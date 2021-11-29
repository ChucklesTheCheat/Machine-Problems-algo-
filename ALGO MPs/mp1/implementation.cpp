#include <stdio.h>
#include "Data.h"
#include <iostream>
#include <fstream>

using namespace std;

//Constructor
arrayManipulation::arrayManipulation()
{

    ofstream arrayFile ("arrayFile.txt", std::ios_base::app);
    
    cout << "\nEnter size of array you wanna start with : ";
    cin >> size;


    //initialize all elements to 0
    for(int values = 0; values <= sizeof(array); values++)
    {
        array[values] = 0;
    }

    //insert 1-10 in the array
    for(values = 0; values < 10; values++)
    {
       array[values] = values+1;

    }
    
    //textfile formatting
    arrayFile<< "\t======================" << endl;
    arrayFile << "\t=   INITIAL ARRAY    =" <<endl;
    arrayFile<< "\t======================" << endl;
    
    //will write initial dsata of  array to file
    for (int i = 0; i<=size; i++)
    {
            arrayFile << "\t\t[" <<i<<"] " << array[i] <<endl;
    }
    arrayFile << endl;
    
}


//function that will display whats in the array
void arrayManipulation::display()
{
    
    ofstream arrayFile ("arrayFile.txt", std::ios_base::app);
  
    //text file formatting
    arrayFile << endl;
    arrayFile<< "\t======================" << endl;
    arrayFile <<"\t=  DISPLAY OPERATION =" <<endl;
    arrayFile<< "\t======================" << endl;


    fileWriter();
}


//funstion will insert an element to the array
void arrayManipulation::insert()
{
    //text file formatting
    ofstream arrayFile ("arrayFile.txt", std::ios_base::app);
    arrayFile << endl;
    arrayFile<< "\t======================" << endl;
    arrayFile <<"\t=  INSERT OPERATION  =" <<endl;
    arrayFile<< "\t======================" << endl;
    
    int i;
    //system("clear");
    cout << "\tEnter element to insert : ";
    cin >> insertedElement;
    cout << "\tWhich position : ";
    cin >> position;
     
    cout << endl;
    cout<< "\t======================" << endl;
    cout <<"\t=  INSERT OPERATION  =" <<endl;
    cout<< "\t======================" << endl;
    //insert element to the array
    for (i=size; i>=position; i--)
    {
        array[i]=array[i-1];
    }
    array[i+1]=insertedElement;
    size++;
    
    
    cout <<"\t-> After inserting " <<  insertedElement << " to position [" <<position <<"]: "<<endl<<endl;
    arrayFile <<"\t-> After inserting " <<  insertedElement << " to position [" <<position <<"]:"<<endl;
    
    
    fileWriter();
    
}


//to delete an element via the array index
void arrayManipulation::deleteElement()
{

    ofstream arrayFile ("arrayFile.txt", std::ios_base::app);
   
    //text file formatting
    arrayFile << endl;
    arrayFile<< "\t======================" << endl;
    arrayFile <<"\t=  DELETE OPERATION  =" <<endl;
    arrayFile<< "\t======================" << endl;
    
    
    cout << "\tEnter position : ";
    cin >> position;
    
    
    if(position < 0 || position >= size)    //check if position is valid
    {
        cout << "\tInvalid position" << endl;
    }
    else    //if position inputted is found
    {
        for(int i=position; i<=size-1; i++)
        {
            array[i]=array[i+1];
        }
        array[size-1]={}; //it will be set to null
        
        cout<<"\tDELETED"<<endl;
    }
    

    cout <<"\t-> After deleting position [" << position << "]: " << endl << endl;
    arrayFile <<"\t-> After deleting position [" << position << "]:" << endl;
    
    fileWriter();
    
    
}



//to swap two elements via array index
void arrayManipulation::swap()
{
    ofstream arrayFile ("arrayFile.txt", std::ios_base::app);
    //text file formatting
    arrayFile << endl;
    arrayFile<< "\t======================" << endl;
    arrayFile <<"\t=   SWAP OPERATION   =" <<endl;
    arrayFile<< "\t======================" << endl;
    
    int temp, pos1, pos2;
    //system("clear");
 
    cout << "\tEnter pos1 : ";
    cin >> pos1;
    
    cout << "\tEnter pos2 : ";
    cin >> pos2;
    
  //where the swapping occurs
    temp = array[pos1];
    array[pos1] = array[pos2];
    array[pos2] = temp;
    
    
    cout <<"\t-> After swapping position [" << pos1 << "] and [" << pos2<<"]:"<<endl << endl;
    arrayFile <<"\t-> After swapping position [" << pos1 << "] and [" << pos2<<"]:" << endl;
    
    fileWriter();
}


//function for writing data to text file
void arrayManipulation::fileWriter()
{
    ofstream arrayFile ("arrayFile.txt", std::ios_base::app);
    
    arrayFile << endl;
    for (int i = 0; i<=size; i++)
    {
        cout << "\t\t[" <<i<<"] " << array[i] <<endl;
        arrayFile << "\t\t[" <<i<<"] " << array[i] <<endl;
    }
    
    arrayFile<< endl;
    arrayFile.close();

}

