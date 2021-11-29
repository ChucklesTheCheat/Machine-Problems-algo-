#ifndef Data_h
#define Data_h

class arrayManipulation
{
public:
    int size;
    int array[100];
    int values;
    int insertedElement;
    int position;

    
    arrayManipulation();
    void display();
    void insert();
    void updateArray();
    void deleteElement();
    void swap();
    void fileWriter();
};

#endif /* Data_h */
