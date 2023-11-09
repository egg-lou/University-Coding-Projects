#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define FILE_Acc "account.dat"

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
bool isDigit(char c);
bool isNumeric(const char *str);
bool checker(int operation, const char *str);

int main() {
    int response;
    struct Account *acc = NULL;
    char proceed;

    printf("WELCOME TO THE ONLINE BANK\n");

    do {
        printf("\nMENU:\n");
        printf("1. Create Account\n");
        printf("2. Continue to Existing Account\n");
        printf("3. Delete an Existing Account\n");
        printf("4. Exit\n");
        printf("Enter your choice: ");

        while (scanf("%d", &response) != 1) {
            printf("Invalid input. Please enter a number: ");
            while (getchar() != '\n'); // Clear the input buffer
        }

        switch (response) {
            case 1:
                CreateAccount();
                printf("\nAccount created successfully.\n");
                printf("Do you want to proceed? (Y/N): ");
                scanf(" %c", &proceed);
                while (proceed != 'Y' && proceed != 'y' && proceed != 'N' && proceed != 'n') {
                    printf("Invalid input. Please enter 'Y' to continue or 'N' to exit: ");
                    scanf(" %c", &proceed);
                }

                if (proceed != 'Y' && proceed != 'y') {
                    printf("Thank you for using the On-Line Bank.\n"); // Print the thank-you message
                    response = 4; // Change the response to exit the loop
                    break; // Exit the do-while loop
                }
                break;
            case 2:
                if (acc != NULL) {
                    free(acc);
                    acc = NULL;
                }
                char accNum[6], accPin[5];
                printf("Enter Account Number (5 digits): ");
                while (scanf("%s", accNum) != 1 || !checker(1, accNum)) {
                    printf("Invalid account number. Please enter 5 digits: ");
                    while (getchar() != '\n');
                }
                printf("Enter Account Pin (4 digits): ");
                while (scanf("%s", accPin) != 1 || !checker(2, accPin)) {
                    printf("Invalid account PIN. Please enter 4 digits: ");
                    while (getchar() != '\n');
                }
                if (SearchAccount(accNum, accPin)) {
                    acc = (struct Account *)malloc(sizeof(struct Account));
                    if (acc == NULL) {
                        printf("Memory allocation failed.\n");
                        return 1;
                    }
                    strcpy(acc->AccNum, accNum);
                    strcpy(acc->AccPin, accPin);
                    printf("Valid Account Number and Pin\n");
                    UpdateAccount(acc, accNum, accPin);
                } else {
                    printf("Invalid account number or PIN.\n");
                }
                break;
            case 3:
                if (acc != NULL) {
                    free(acc);
                    acc = NULL;
                }
                DeleteAccount();
                break;
            case 4:
                printf("Thank you for using the On-Line Bank.\n");
                break;
            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }

    } while (response != 4);

    if (acc != NULL) {
        free(acc);
    }

    return 0;
}

bool isDigit(char c) {
    return (c >= '0' && c <= '9');
}

bool isNumeric(const char *str) {
    for (int i = 0; i < strlen(str); i++) {
        if (!isDigit(str[i])) {
            return false;
        }
    }
    return true;
}

bool checker(int operation, const char *str) {
    switch (operation) {
        case 1: {
            if (strlen(str) != 5) {
                printf("Invalid account number length. Account Number must be exactly 5 digits.\n");
                return false;
            }
            break;
        }
        case 2: {
            if (strlen(str) != 4) {
                printf("Invalid account PIN length. Account PIN must be exactly 4 digits.\n");
                return false;
            }
            break;
        }
        default:
            return false;
    }

    if (!isNumeric(str)) {
        printf("Invalid input. Account Number and PIN must be numeric.\n");
        return false;
    }

    return true;
}

void CreateAccount() {
    struct Account acc;
    FILE *accountFile = fopen(FILE_Acc, "ab");

    if (accountFile == NULL) {
        printf("Error opening file.\n");
        return;
    }

    int c;
    do {
        printf("Enter Account Number (5 digits): ");
        while (scanf("%s", acc.AccNum) != 1 || !checker(1, acc.AccNum)) {
            printf("Invalid account number. Please enter 5 digits: ");
            while ((c = getchar()) != '\n' && c != EOF); // Clear the input buffer
        }

        printf("Enter Account Pin (4 digits): ");
        while (scanf("%s", acc.AccPin) != 1 || !checker(2, acc.AccPin)) {
            printf("Invalid account PIN. Please enter 4 digits: ");
            while ((c = getchar()) != '\n' && c != EOF); // Clear the input buffer
        }

        char charAccBal[80];
        printf("Enter Initial Deposit: ");
        while (scanf("%s", charAccBal) != 1 || !isNumeric(charAccBal)) {
            printf("Invalid input. Please enter initial deposit: ");
            while ((c = getchar()) != '\n' && c != EOF); // Clear the input buffer
        }

        acc.AccBal = strtof(charAccBal, NULL);
    } while ((c = getchar()) != '\n' && c != EOF);

    fwrite(&acc, sizeof(struct Account), 1, accountFile);

    fclose(accountFile);
}

void DeleteAccount() {
    char accNum[6];
    char accPin[5];
    int c;
    do {
        printf("Enter Account Number (5 digits): ");
        while (scanf("%s", accNum) != 1 || !checker(1, accNum)) {
            printf("Invalid account number. Please enter 5 digits: ");
            while ((c = getchar()) != '\n' && c != EOF); // Clear the input buffer
        }

        printf("Enter Account Pin (4 digits): ");
        while (scanf("%s", accPin) != 1 || !checker(2, accPin)) {
            printf("Invalid account PIN. Please enter 4 digits: ");
            while ((c = getchar()) != '\n' && c != EOF); // Clear the input buffer
        }
    } while ((c = getchar()) != '\n' && c != EOF);

    if (SearchAccount(accNum, accPin)) {
        char confirmation;
        printf("Are you sure you want to delete the account? (Type 'Y' to confirm, 'N' to cancel): ");
        scanf(" %c", &confirmation);
        while (confirmation != 'Y' && confirmation != 'y' && confirmation != 'N' && confirmation != 'n') {
            printf("Invalid input. Please enter 'Y' to continue or 'N' to exit: ");
            scanf(" %c", &confirmation);
        }
        if (confirmation == 'Y' || confirmation == 'y') {
            FILE *accountFile = fopen(FILE_Acc, "rb");
            if (accountFile == NULL) {
                printf("Error opening file.\n");
                return;
            }

            FILE *tempFile = fopen("temp.dat", "wb");
            if (tempFile == NULL) {
                printf("Error opening file.\n");
                fclose(accountFile);
                return;
            }

            struct Account accTemp;

            while (fread(&accTemp, sizeof(struct Account), 1, accountFile) == 1) {
                if (strcmp(accTemp.AccNum, accNum) != 0 || strcmp(accTemp.AccPin, accPin) != 0) {
                    fwrite(&accTemp, sizeof(struct Account), 1, tempFile);
                }
            }

            fclose(accountFile);
            fclose(tempFile);

            remove(FILE_Acc);
            rename("temp.dat", FILE_Acc);
            printf("\nAccount deleted successfully.\n");
        } else {
            printf("\nAccount deletion canceled. Returning to the main menu.\n");
        }
    } else {
        printf("\nAccount not found or invalid PIN.\n");
    }
}

void UpdateAccount(struct Account *acc, char *accNum, char *accPin) {
    int response;

    FILE *accountFile = fopen(FILE_Acc, "rb+");
    if (accountFile == NULL) {
        printf("Error opening file.\n");
        return;
    }

    while (fread(acc, sizeof(struct Account), 1, accountFile) == 1) {
        if (strcmp(acc->AccNum, accNum) == 0 && strcmp(acc->AccPin, accPin) == 0) {
            break;
        }
    }

    do {
        printf("\nAccount Number: %s", acc->AccNum);
        printf("\nAccount Balance: %.2f", acc->AccBal);
        printf("\n1. Withdraw\n");
        printf("2. Deposit\n");
        printf("3. Update Pin\n");
        printf("4. Back to Main Menu\n");
        printf("Enter your choice: ");
        scanf("%d", &response);

        switch (response) {
            case 1: {
                float amount;
                int result = 0;

                while (result != 1) {
                    printf("Enter amount to withdraw: ");
                    result = scanf("%f", &amount);

                    if (result == 1) {
                        if (amount <= acc->AccBal) {
                            acc->AccBal -= amount;
                            printf("Withdrawal successful. New balance: %.2f\n", acc->AccBal);
                            break;
                        } else {
                            printf("Insufficient Balance\n");
                            result = 0;
                        }
                    } else {
                        printf("Invalid input. Please enter a valid number.\n");
                        while (getchar() != '\n'); // Clear the input buffer
                    }
                }
                break;
            }
            case 2: {
                int result = 0;
                float amount;

                while (result != 1) {
                    printf("Enter amount to deposit: ");
                    result = scanf("%f", &amount);

                    if (result == 1) {
                        acc->AccBal += amount;
                        printf("Deposit successful. New balance: %.2f\n", acc->AccBal);
                        break;
                    } else {
                        printf("Invalid input. Please enter a valid number.\n");
                        while (getchar() != '\n'); // Clear the input buffer
                        result = 0;
                    }
                }
                break;
            }
            case 3: {
                char NewPin[5];

                bool validInputPin = false;

                do {
                    printf("Enter New Account Pin (4 digits): ");
                    scanf("%s", NewPin);
                    if (checker(2, NewPin)) {
                        validInputPin = true;
                    }

                } while (!validInputPin);
                strcpy(acc->AccPin, NewPin);
                printf("PIN updated successfully.\n");
                break;
            }
            case 4:
                break;
            default:
                printf("Invalid choice.\n");
                break;
        }

        fseek(accountFile, -sizeof(struct Account), SEEK_CUR);
        fwrite(acc, sizeof(struct Account), 1, accountFile);
        fflush(accountFile);

    } while (response != 4);

    fclose(accountFile);
}

bool SearchAccount(char *accNum, char *accPin) {
    FILE *accountFile = fopen(FILE_Acc, "rb");
    if (accountFile == NULL) {
        printf("Error opening file.\n");
        return false;
    }

    struct Account accTemp;

    while (fread(&accTemp, sizeof(struct Account), 1, accountFile) == 1) {
        if (strcmp(accTemp.AccNum, accNum) == 0 && strcmp(accTemp.AccPin, accPin) == 0) {
            fclose(accountFile);
            return true;
        }
    }

    fclose(accountFile);
    return false;
}