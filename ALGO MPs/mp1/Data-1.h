#ifndef Data_h
#define Data_h

// structure of a node
struct Node {
    int data;
    Node* prev = NULL;
    Node* next = NULL;
};

class doublyLinkedList 
{
  public:

  
  doublyLinkedList(){}
  void insertAtTheBegin(struct Node **start_ref, int data);
  void printList(Node *start);
  void bubbleSort(Node *start);
  void save();
};

#endif 
