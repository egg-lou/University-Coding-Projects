#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define FILE_Acc "accounts.dat"

struct Account {
    char AccNum[6];
    char AccPin[5];
    float AccBal;
};

// Function prototypes
void CreateAccount();
void DeleteAccount();
void UpdateAccount(struct Account *acc, char *accNum, char *accPin);
bool SearchAccount(char *accNum, char *accPin);

int main() {
    int response;
    struct Account *acc = NULL;

    printf("WELCOME TO THE ONLINE BANK\n");

    // Main program loop
    do {
        // Display the menu options
        printf("\nMENU:\n");
        printf("1. Create Account\n");
        printf("2. Continue to Existing Account\n");
        printf("3. Delete an Existing Account\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");

        char input[50]; // Buffer to store user input

        while (1) {
            scanf("%s", input);
            if (sscanf(input, "%d", &response) == 1) {
                break; 
            } else {
                printf("Invalid input. Please enter a number: ");
            }
        }

        // Evaluate the user's choice using a switch statement
        switch (response) {
            case 1: {
                // Create an account and ask the user if they want to proceed
                CreateAccount();
                char proceed;
                printf("\nAccount created successfully.\n");
                printf("Do you want to proceed? (Y/N): ");
                scanf(" %c", &proceed);
                if (proceed != 'Y' && proceed != 'y') {
                    response = 4; // Change the response to exit the loop
                }
                break;
            }
            case 2: {
                // Continue to an existing account
                if (acc != NULL) {
                    free(acc); // Free the memory if an account already exists
                    acc = NULL;
                }

                char accNum[6], accPin[5];
                printf("Enter Account Number (5 digits): ");
                scanf("%s", accNum);
                printf("Enter Account Pin (4 digits): ");
                scanf("%s", accPin);

                // Search for the account with the provided account number and PIN
                if (SearchAccount(accNum, accPin)) {
                    // If the account is found, allocate memory and update the account
                    acc = (struct Account *)malloc(sizeof(struct Account));
                    if (acc == NULL) {
                        printf("Memory allocation failed.\n");
                        return 1;
                    }

                    strcpy(acc->AccNum, accNum);
                    strcpy(acc->AccPin, accPin);
                    printf("Valid Account Number and Pin\n");
                    UpdateAccount(acc, accNum, accPin); // Update account options
                } else {
                    printf("Invalid account number or PIN.\n");
                }
                break;
            }
            case 3: {
                // Delete an existing account
                if (acc != NULL) {
                    free(acc); // Free the memory if an account already exists
                    acc = NULL;
                }
                DeleteAccount(); // Delete the account from the file
                break;
            }
            case 4:
                printf("Thank you for using the On-Line Bank.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }

    } while (response != 4); // End of the main program loop when 'response' is 4 (Exit).

    if (acc != NULL) {
        free(acc); // Free the memory before exiting the program
    }

    return 0;
}

// Functions to Create, Delete, Update, and Search the accounts in the file...
#include <ctype.h> // Include the ctype.h header for the isdigit() function

    bool isNumeric(const char *str) {
        for (int i = 0; i < strlen(str); i++) {
            if (!isdigit(str[i])) {
                return false;
            }
        }
        return true;
    }


void CreateAccount() {
    struct Account acc; // Declare a new Account struct variable
    FILE *accountFile = fopen(FILE_Acc, "ab"); // Open the file in "ab" mode (append binary)

    if (accountFile == NULL) {
        printf("Error opening file.\n"); // If the file couldn't be opened, print an error and return
        return;
    }

    // Function to check if a string contains only numeric characters
  /*  bool isNumeric(const char *str) {
        for (int i = 0; i < strlen(str); i++) {
            if (!isdigit(str[i])) {
                return false;
            }
        }
        return true;
    } */

// XIAN VERSION //
    int c;
    do {

      while(1){
        printf("Enter Account Number (5 digits): ");
        scanf("%s", acc.AccNum); // Read 5 characters into acc.AccNum=
        if (strlen(acc.AccNum) == 5 && isNumeric(acc.AccNum)) 
            break;
         else 
            printf("Invalid input. Please enter 5 digits.\n");
      }

      while(1){
        printf("Enter Account Pin (4 digits): ");
        scanf("%s", acc.AccPin); // Read 4 characters into acc.AccNum
        if (strlen(acc.AccPin) == 4 && isNumeric(acc.AccPin)) 
           break;
         else 
            printf("Invalid input. Please enter 4 digits.\n");
      }
      
      while(1){
	    char charAccBal [80];
        printf("Enter Initial Deposit: ");
        scanf("%s", charAccBal); // Read the account balance into acc.AccBal
    
        if (isNumeric(charAccBal)) {
          acc.AccBal = strtof(charAccBal, NULL);
           break;
        }else 
            printf("Invalid input. Please enter initial deposit.\n");
      }
    } while ((c = getchar()) != '\n' && c != EOF);
    fwrite(&acc, sizeof(struct Account), 1, accountFile); // Write the account struct to the file

    fclose(accountFile); // Close the file 
    
}
//END


void DeleteAccount() {
    char accNum[6]; // Declare an array to store the account number (5 digits + 1 for null terminator)
    char accPin[5]; // Declare an array to store the account PIN (4 digits + 1 for null terminator)

    printf("Enter Account Number (5 digits): ");
    scanf("%5s", accNum); // Read 5 characters into accNum

    printf("Enter Account Pin (4 digits): ");
    scanf("%4s", accPin); // Read 4 characters into accPin

    if (SearchAccount(accNum, accPin)) { // Check if the account with the provided number and PIN exists
        FILE *accountFile = fopen(FILE_Acc, "rb"); // Open the file in "rb" mode (read binary)
        if (accountFile == NULL) {
            printf("Error opening file.\n"); // If the file couldn't be opened, print an error and return
            return;
        }

        FILE *tempFile = fopen("temp.dat", "wb"); // Open a temporary file in "wb" mode (write binary)
        if (tempFile == NULL) {
            printf("Error opening file.\n"); // If the temporary file couldn't be opened, print an error, close the accountFile, and return
            fclose(accountFile);
            return;
        }

        struct Account accTemp; // Declare a temporary Account struct variable to hold data while processing

        // Loop through the accounts in the main file and copy all except the one to be deleted to the temporary file
        while (fread(&accTemp, sizeof(struct Account), 1, accountFile) == 1) {
            if (strcmp(accTemp.AccNum, accNum) != 0 || strcmp(accTemp.AccPin, accPin) != 0) {
                fwrite(&accTemp, sizeof(struct Account), 1, tempFile);
            }
        }

        fclose(accountFile); // Close the main account file
        fclose(tempFile); // Close the temporary file

        remove(FILE_Acc); // Delete the main account file
        rename("temp.dat", FILE_Acc); // Rename the temporary file to the main account file
        printf("\nAccount deleted successfully.\n"); // Print a success message
    } else {
        printf("\nAccount not found or invalid PIN.\n"); // If the account was not found, print an error message
    }
}

void UpdateAccount(struct Account *acc, char *accNum, char *accPin) {
    int response; // Declare an integer variable to hold user response

    FILE *accountFile = fopen(FILE_Acc, "rb+"); // Open the file in "rb+" mode (read and write binary)
    if (accountFile == NULL) {
        printf("Error opening file.\n"); // If the file couldn't be opened, print an error and return
        return;
    }

    while (fread(acc, sizeof(struct Account), 1, accountFile) == 1) {
        if (strcmp(acc->AccNum, accNum) == 0 && strcmp(acc->AccPin, accPin) == 0) {
            break; // Read the file until a matching account is found and store its data in the provided acc pointer
        }
    }

    // The following code is a menu for updating account data based on user choice
            do {
                printf("\nAccount Number: %s", acc->AccNum);
                printf("\nAccount Balance: %.2f", acc->AccBal);
                printf("\n1. Withdraw\n");
                printf("2. Deposit\n");
                printf("3. Update Pin\n");
                printf("4. Back to Main Menu\n");
                printf("Enter your choice: ");
                scanf("%d", &response); // Read user choice
                
                switch (response) {
            case 1: {
                // Withdraw code here...
                float amount;
                printf("Enter amount to withdraw: ");
                scanf("%f", &amount);

                if (amount <= acc->AccBal) {
                    acc->AccBal -= amount;
                    printf("Withdrawal successful. New balance: %.2f\n", acc->AccBal);
                } else {
                    printf("Insufficient Balance\n");
                }
                break;
            }
            case 2: {
                // Deposit code here...
                float amount;
                printf("Enter amount to deposit: ");
                scanf("%f", &amount);

                acc->AccBal += amount;
                printf("Deposit successful. New balance: %.2f\n", acc->AccBal);
                break;
            }
            case 3: {
                // Update Pin code here...
                char NewPin[5];
                printf("Enter New Pin: ");
                scanf("%4s", NewPin); // Limit the input to 4 characters to match the struct size

                strcpy(acc->AccPin, NewPin);
                printf("PIN updated successfully.\n");
                break;
            }
            case 4:
                // Do nothing and exit the do-while loop
                break;
            default:
                printf("Invalid choice.\n");
                break;
        }
        // Move the file pointer back to the beginning of the current record in the file
        fseek(accountFile, -sizeof(struct Account), SEEK_CUR);

        fwrite(acc, sizeof(struct Account), 1, accountFile); // Write the updated account struct back to the file
        fflush(accountFile); // Flush the data to the file to ensure it's saved

    } while (response != 4); // Repeat until the user chooses to go back to the main menu

    fclose(accountFile); // Close the file
}

bool SearchAccount(char *accNum, char *accPin) {
    FILE *accountFile = fopen(FILE_Acc, "rb"); // Open the file in "rb" mode (read binary)
    if (accountFile == NULL) {
        printf("Error opening file.\n"); // If the file couldn't be opened, print an error and return false
        return false;
    }

    struct Account accTemp; // Declare a temporary Account struct variable to hold data while searching

    // Loop through the accounts in the file and check for a matching account number and PIN
    while (fread(&accTemp, sizeof(struct Account), 1, accountFile) == 1) {
        if (strcmp(accTemp.AccNum, accNum) == 0 && strcmp(accTemp.AccPin, accPin) == 0) {
            fclose(accountFile); // If a match is found, close the file and return true
            return true;
        }
    }

    fclose(accountFile); // If no match is found, close the file and return false
    return false;
}