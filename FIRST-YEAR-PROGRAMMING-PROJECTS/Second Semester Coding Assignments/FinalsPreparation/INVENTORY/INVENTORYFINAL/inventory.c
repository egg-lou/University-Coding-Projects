#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <conio.h>

struct shoeInventory{
  int stockNum; 
  int styleNum; //0 - 50
  int sizes[12]; // pairs (size range 3 - 14)
  float price;
};

int matchInput(int num);
void AddRecord(struct shoeInventory *record);
void DisplayRecord(struct shoeInventory *record);
void UpdateRecord(struct shoeInventory *record);
void DeleteRecord(struct shoeInventory *record);

bool isValidInput(int input) {
    return input >= 0;
}

int main(){
  int choice,exit;
  do{
    struct shoeInventory record;
    printf("\nSHOE INVENTORY MENU:\n");
    printf("\t[1] ADD NEW RECORD\n");
    printf("\t[2] DISPLAY RECORD\n");
    printf("\t[3] UPDATE RECORD\n");
    printf("\t[4] DELETE RECORD\n");
    printf("\t[5] EXIT\n");
    printf("ENTER CHOICE: ");
    scanf("%d",&choice);

      switch (choice){
        case 1:
          AddRecord(&record);
          break;
        case 2:
          DisplayRecord(&record);
          break;
        case 3:
          UpdateRecord(&record);
          break;
        case 4:
          DeleteRecord(&record);
          break;
        case 5:{
          printf ("ARE YOU SURE YOU WANT TO EXIT?\n");
          printf ("\t[1] YES\n\t[2] GO BACK TO MENU\n");
          printf ("ENTER CHOICE: ");
          scanf ("%d", &exit);

          if(exit == 2)
            continue;
        }
      }
  }while(exit != 1);
    printf ("THANK YOU FOR USING OUR PROGRAM\n");
    printf("Exiting program...\n");
}

//Check if the user input matches the current stock and style number
int matchInput(int num){
  FILE *shoeFile = fopen("inventory.txt","r");
  
  int stockNum, styleNum;
  char letter;

  while(fscanf(shoeFile, "%d %d", &stockNum, &styleNum) == 2){
    if(num == stockNum || num == styleNum){ //return True if may duplicate
     fclose(shoeFile);
      return 1;
    }

    while((letter = fgetc(shoeFile))!= '\n'){
      if (letter == EOF) //check if nasa end na para ma-end function
        break; 
    }
  }
  fclose(shoeFile);
  return 0;//walang nakitang duplicate
}



//CREATE
void AddRecord(struct shoeInventory *record){
  FILE *shoeFile = fopen("inventory.txt","a");//Append or Add
  int i;

  while(1){ //repeat until matchInput return 0
    printf ("ENTER STOCK NUMBER: ");
    if(scanf("%d",&record->stockNum) != 1){
      printf("INVALID INPUT, MUST BE A NUMBER\n");
      while(getchar() != '\n');
    }

    else if(matchInput(record->stockNum))
      printf("STOCK # %d ALREADY EXIST IN THIS RECORD!\n\n",record->stockNum);

    else if(isValidInput(record->stockNum))
      printf("INVALID INPUT, MUST NOT BE A NEGATIVE NUMBER\n"); 
    else 
      break;
  }
  
  while(1){ //repeat until matchInput return 0
    printf ("ENTER STYLE NUMBER (0 to 50): ");
    scanf("%d",&record->styleNum);
    if(matchInput(record->styleNum))
      printf("STOCK # %d ALREADY EXIST IN THIS RECORD!\n\n",record->styleNum);
    else 
      break;
  }
  printf("ENTER PRICE: ");
  scanf("%f",&record->price);

  printf ("ENTER STOCK ON HAND:\n");
  for (i = 0; i < 12; i++){ 
    printf ("\tSIZE %d: ",i+3);
    scanf ("%d", &record->sizes[i]);
  }
  //Insert (stockNum, styleNum, price) to shoeFile
  fprintf(shoeFile,"%d %d %.2f ", record->stockNum, record->styleNum, record->price);

  //Insert sizes (number of pairs in each size) into shoeFile
  for(i=0; i<12; i++){
    fprintf(shoeFile,"%d ",record->sizes[i]);
  }
  fprintf(shoeFile, "\n");
  fclose(shoeFile);

  printf ("\nRECORD ADDED SUCCESSFULLY!\n\n");
}

//DISPLAY
void DisplayRecord(struct shoeInventory *record){
  FILE *shoeFile = fopen("inventory.txt","r"); //Read
  int i,choice,found,searchKey,shoeCount = 1;

  printf("\nCHOOSE HOW TO DISPLAY:\n");
  printf ("\t[1] BASED ON STOCK/STYLE NUMBER\n");
  printf ("\t[2] ALL RECORDS\n");
  printf ("ENTER CHOICE: ");
  scanf("%d", &choice);

//Display based on specific stock number
  if (choice == 1){
    printf("ENTER STOCK/STYLE NUMBER TO SEARCH: ");
    scanf("%d", &searchKey);

    while(fscanf(shoeFile, "%d %d %f", &record->stockNum, &record->styleNum, &record->price) == 3){ 
      
  //Print Data
      if(record->stockNum == searchKey || record->styleNum == searchKey){
        for(i = 0; i < 12; i++)
        fscanf(shoeFile, "%d", &record->sizes[i]);

        printf("\tSTOCK NUMBER: %d\n", record->stockNum);
        printf("\tSTYLE NUMBER: %d\n", record->styleNum);
        printf("\tPRICE: %.2f\n\n", record->price);
      //Print Data in Array
        for(i = 0; i < 12; i++)
          printf ("\tSIZE %d: %d\n", i+3, record->sizes[i]);

        found = 1;
        break;
      }

    char letter;
    while((letter = fgetc(shoeFile))!= '\n'){
      if (letter == EOF)
        break;
      }
      shoeCount++;
    }

  }

//Display All Records
  if (choice == 2){
    while (fscanf(shoeFile, "%d %d %f", &record->stockNum, &record->styleNum, &record->price) != EOF){ //EOF = End of File
      for(i = 0; i < 12; i++){
        fscanf(shoeFile, "%d", &record->sizes[i]);
      }

      printf ("\nSHOE %d\n", shoeCount);
      printf("\tSTOCK NUMBER: %d\n", record->stockNum);
      printf("\tSTYLE NUMBER: %d\n", record->styleNum);
      printf("\tPRICE: %.2f\n\n", record->price);
      shoeCount++;//track shoe count

      for(i = 0; i < 12; i++)
        printf ("\tSIZE %d: %d\n", i+3, record->sizes[i]);
      
      found = 1;
    }
  }
  
  if (found == 1) {
        printf("\nDONE DISPLAYING RECORD!\n");
  } else {
        printf("RECORD NOT FOUND!\n");//for the stock number display
  }

  fclose(shoeFile);
}


void UpdateRecord(struct shoeInventory *record){
  FILE *shoeFile = fopen("inventory.txt","r+"); //Read and Write
  //(temp file for updated record)
  FILE *tempFile = fopen("tempFile.txt", "w");//Write

  int i, choice, stockUpdate,found;
  float tempPrice, tempFloat; //For price
  int tempStock, tempInt, size; //For number of stock

    printf("\nCHOOSE WHAT TO UPDATE:\n");
    printf("\t[1] CHANGE PRICE OF STOCK ITEM\n");
    printf("\t[2] CHANGE NUMBER OF STOCK ON HAND\n");
    printf("ENTER CHOICE: ");
    scanf ("%d", &choice);

    printf("\nENTER STOCK OR STYLE NUMBER: ");
    scanf("%d", &stockUpdate);

    while(fscanf(shoeFile, "%d %d %f", &record->stockNum, &record->styleNum, &record->price) != EOF){ 

        for(i = 0; i < 12; i++)
          fscanf(shoeFile, "%d", &record->sizes[i]);
        
        if(record->styleNum == stockUpdate || record->stockNum == stockUpdate){
        
            if(choice == 1){ //CHANGE PRICE
              printf ("\nSTOCK NUMBER %d:\n",record->stockNum);
              printf("\tCURRENT PRICE: %.2f\n",record->price);
              printf("\tENTER NEW PRICE: ");
              scanf("%f", &tempPrice);

              tempFloat = record->price;
              record->price = tempPrice;
              tempPrice = tempFloat;
              tempFloat = record->price;
            }
            else if(choice == 2){//CHANGE STOCK
              printf ("\nSTOCK NUMBER %d:\n",record->stockNum);
              printf ("\nENTER SIZE THAT WILL BE UPDATED[3 - 14]: ");
              scanf("%d", &size);
              size -= 3; //since sa 3 magsisimula

              printf("\nNOW UPDATING SIZE %d:\n",size+3);
              printf("CURRENT STOCK ON HAND: %d\n",record->sizes[size]);
              printf("ENTER NEW STOCK ON HAND:");
              scanf("%d", &tempStock);
              
              record->sizes[size] = tempStock;
            }
          found = 1;
        }

        //Insert (stockNum, styleNum, price) to TempFile
        fprintf(tempFile,"%d %d %.2f ", record->stockNum, record->styleNum, record->price);

        //Insert sizes (number of pairs in each size) into tempFile
        for(i=0; i<12; i++){
          fprintf(tempFile,"%d ",record->sizes[i]);
        }
        
        fprintf(tempFile, "\n");
    }//END OF WHILE LOOP
    
  if (found == 1) {
    printf("SUCCESSULLY UPDATED %s OF STOCK # %d!\n",(choice == 1)? "PRICE RECORD" : "NUMBER ON HAND",stockUpdate);
  } else {
        printf("RECORD NOT FOUND!\n");
  }

    fclose(shoeFile);
    fclose(tempFile);

    //Remove Inventory since tempFile na gagamitin as inventory file
    remove("inventory.txt");
    //Rename tempFile to Inventory 
    rename("tempFile.txt","inventory.txt");
}

void DeleteRecord(struct shoeInventory *record){
  FILE *shoeFile = fopen("inventory.txt","r"); 
  FILE *tempFile = fopen("tempFile.txt", "w");

  int searchKey, found, i;
  printf("ENTER STOCK/STYLE NUMBER TO DELETE: ");
  scanf("%d", &searchKey);

  while(fscanf(shoeFile, "%d %d %f", &record->stockNum, &record->styleNum, &record->price) != EOF){ 

      for(i = 0; i < 12; i++)
        fscanf(shoeFile, "%d", &record->sizes[i]);
      
      if(record->styleNum == searchKey || record->stockNum == searchKey){
        found = 1;
        continue; // Skip writing this record to the temp file
      }

      fprintf(tempFile,"%d %d %.2f ",record->stockNum, record->styleNum, record->price);

      for(i = 0; i < 12; i++){
        fprintf(tempFile, "%d ", record->sizes[i]);
      }
      fprintf(tempFile,"\n");
  }
  fclose(shoeFile);
  fclose(tempFile);

  if (found == 1) {
        remove("inventory.txt");
        rename("tempFile.txt", "inventory.txt");
        printf("RECORD DELETED SUCCESSFULLY!\n");
  } else {
        remove("tempFile.txt");
        printf("RECORD NOT FOUND!\n");
  }
}