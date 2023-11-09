#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// struct Employee{
//     int id;
//     char name[20];
//     float salary;
// }emp;

// int main() {
//     FILE *file;

//     file = fopen("employee_data.bin", "ab");
//     if (file == NULL) {
//         printf("Unable to open file.\n");
//         return 1;
//     }

//     for(int i = 0; i < 2; i++){
//         printf("Enter employee ID: ");
//         scanf("%d", &emp.id);
//         printf("Enter employee name: ");
//         scanf("%s", emp.name);
//         printf("Enter employee salary: ");
//         scanf("%f", &emp.salary);

//         fwrite(&emp, sizeof(struct Employee), 1, file);
//     }
    
//     fclose(file);

//     printf("Data stored successfully in binary file.\n");


//     file = fopen("employee_data.bin", "rb");
//     if (file == NULL){
//         printf("Unable to open file.\n");
//         return 1;
//     }

//     for(int i = 0; i < 4; i++){

//         fread(&emp, sizeof(struct Employee), 1, file);
//         printf("\nEmployee Details:\n");
//         printf("ID: %d\n", emp.id);
//         printf("Name: %s\n", emp.name);
//         printf("Salary: %.2f\n", emp.salary);
//     }
    
//     fclose(file);

//     return 0;
// }


FILE *fp;

int main() {
    char phrase[80] = "BSIT 1-4 are responsible, very studious, and industrious";
    int password = 123212;

    fp = fopen("BSIT_Phrase.bin", "wb");

    // wb = Write Binary
    // ab = Append Binary
    // rb = Read Binary

    //NOTE: Hinde maganda gamitin si binary if magsstore ka ng string mas maganda siya for numbers like passwords or pins

    if (fp == NULL) {
        printf("Failed to open the file.\n");
        return 1;
    }

    fwrite(phrase, sizeof(char), strlen(phrase), fp);
    fwrite(&password, sizeof(int), 1, fp);

    //Note: Tumatanggap lang ng pointer variable para sa fwrite at fread 
    //Syntax: fwrite(variableYouWantToStore, sizeOfYouWillStore, How many times you want it to be stored, where iistore)

    fclose(fp);

    printf("BSIT 1-4 Phrase Stored Successfully in a binary file");

    return 0;
}