// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>

// struct TEMPLATE {
//     char name[15];
//     int age;
//     struct TEMPLATE* next;
// };

// struct HEAD_TAIL_CURRENT {
//     struct TEMPLATE* head;
//     struct TEMPLATE* tail;
//     struct TEMPLATE* current;
// };

// int main() {
//     struct HEAD_TAIL_CURRENT list;

//     // Allocate memory for CURRENT
//     list.current = (struct TEMPLATE*)malloc(sizeof(struct TEMPLATE));

//     // Assign values to CURRENT
//     strcpy(list.current->name, "Loyda");
//     list.current->age = 24;
//     list.current->next = NULL;

//     // Point HEAD and TAIL to CURRENT
//     list.head = list.current;
//     list.tail = list.current;

//     // Repeat item #3
//     list.current = (struct TEMPLATE*)malloc(sizeof(struct TEMPLATE));

//     // Use scanf to assign values to 1st and 2nd members of CURRENT
//     printf("Enter name: ");
//     scanf("%s", list.current->name);
//     printf("Enter age: ");
//     scanf("%d", &list.current->age);
//     list.current->next = NULL;

//     // Repeat item #6, #7, and #8
//     list.tail->next = list.current;
//     list.tail = list.current;

//     // Display the value of 1st and 2nd member of HEAD
//     printf("HEAD - Name: %s, Age: %d\n", list.head->name, list.head->age);

//     // Display the value of 1st and 2nd member of TAIL
//     printf("TAIL - Name: %s, Age: %d\n", list.tail->name, list.tail->age);

//     return 0;
// }


// #include <stdio.h>
// #include <conio.h>
// #include <stdlib.h>
// #include <string.h>

// struct roy{
//       int item;
//       struct roy *next;
// };

// void main()
// {
// struct roy *r1, *r2, *r3;
// r1 = (struct roy *) malloc (sizeof(struct roy));
// r2 = (struct roy *) malloc (sizeof(struct roy));
// r3 = (struct roy *) malloc (sizeof(struct roy));



// r1 -> item = 357;
// r1 ->next = NULL;
// r2 -> item = 5654;
// r2 -> next = NULL;
// r3 -> item = 14344;
// r3 -> next = NULL;
// r2 -> next = r3;
// r3 = r1;
// r1 = r2 -> next;
// r3 -> next = r2;
// r1 -> next = r1;
// printf("r1 %d\n", r1 -> item);
// printf("r2 %d\n", r2 -> item);
// printf("r3 %d\n", r3 -> item);
// getch();
// }


// struct record
// {
//      char name[10];
//      int age;
// };
// struct record myfriend = {"Dhang", 24};
// struct record *ptrtomyfriend = &myfriend;

// void main(){
//       printf("%s", ptrtomyfriend->name);
//       printf("%d", ptrtomyfriend->age);

//       scanf("%s", ptrtomyfriend->name);
//       ptrtomyfriend->age = 22;

//       printf("%s", ptrtomyfriend->name);
//       printf("%d", ptrtomyfriend->age);
// }

// #include <stdio.h>
// #include <stdlib.h>

// struct TEMPLATE {
//     char name[15];
//     int age;
//     struct TEMPLATE *next;
// };

// int main() {
//     struct TEMPLATE *HEAD, *TAIL, *CURRENT;

//     CURRENT = NULL;
//     HEAD = NULL;
//     TAIL = NULL;

//     // Allocate memory location for CURRENT
//     CURRENT = (struct TEMPLATE *) malloc(sizeof(struct TEMPLATE));

//     // Assign "Loyda" to the CURRENT's first member
//     strcpy(CURRENT->name, "Loyda");

//     // Assign 24 to CURRENT's second member
//     CURRENT->age = 24;

//     // Point CURRENT's third member to NULL
//     CURRENT->next = NULL;

//     // Point HEAD to CURRENT
//     HEAD = CURRENT;

//     // Point TAIL to CURRENT
//     TAIL = CURRENT;

//     // Repeat item #3
//     CURRENT = (struct TEMPLATE *) malloc(sizeof(struct TEMPLATE));

//     // Using scanf() function, assign values to the 1st and 2nd members of CURRENT
//     printf("Enter Name: ");
//     scanf("%s", CURRENT->name);
//     printf("Enter Age: ");
//     scanf("%d", &(CURRENT->age));

//     // Repeat item #6, 7, and 8
//     CURRENT->next = NULL;
//     HEAD->next = CURRENT;
//     TAIL = CURRENT;

//     // Display the value of the 1st and 2nd members of HEAD
//     printf("HEAD - NAME: %s\n", HEAD->name);
//     printf("HEAD - AGE: %d\n", HEAD->age);

//     // Display the value of the 1st and 2nd members of TAIL
//     printf("TAIL - NAME: %s\n", TAIL->name);
//     printf("TAIL - AGE: %d\n", TAIL->age);

//     return 0;
// }

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct roy{
      int item;
      struct roy *next;
};

void main()
{
struct roy *r1, *r2, *r3;
r1 = (struct roy *) malloc (sizeof(struct roy));
r2 = (struct roy *) malloc (sizeof(struct roy));
r3 = (struct roy *) malloc (sizeof(struct roy));


r1 -> item = 357;
r1 ->next = NULL;
r2 -> item = 5654;
r2 -> next = NULL;
r3 -> item = 14344;
r3 -> next = NULL;

printf("r1: %d\n", r1 -> item);
printf("r2: %d\n", r2 -> item);
printf("r3: %d\n", r3 -> item);

r2->next = r3;
r3 = r1;
r1 = r2->next;
r3->next = r2;
r1->next = r1;

printf("r1: %d\n", r1 -> item);
printf("r2: %d\n", r2 -> item);
printf("r3: %d\n", r3 -> item);
getch();
}

