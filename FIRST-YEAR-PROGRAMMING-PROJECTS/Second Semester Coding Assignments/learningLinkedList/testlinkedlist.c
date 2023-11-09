#include <stdio.h>


struct Node {
    int value;
    struct Node* next;
};

typedef struct Node node_t;

void printList(node_t *head){
    node_t *temp = head;
    
    while(temp != NULL){
        printf("%d - ", temp->value);
        temp = temp->next;
    }
}

int main(){

    node_t n1, n2, n3;
    node_t *head;

    n1.value = 1;
    n2.value = 4;
    n3.value = 3;

    

    head = &n3;
    n3.next = &n2;
    n2.next = &n1;
    n1.next = NULL;

    printList(head);

    printf("\nReversed Linked List: \n");
    printList(head);
    
    head = &n1;
    n3.next = NULL;
    n2.next = &n3;
    n1.next = &n2;

    return 0;
}