/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package part1;
import java.util.Scanner;
/**
 *
 * @author Colin
 */
public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println("********* Password Encryption *********");
        Scanner input1 = new Scanner(System.in);
        System.out.print("Please enter an 8-character password to encrypt: ");
        String password = input1.nextLine();
        Scanner input2 = new Scanner(System.in);
        System.out.print("Please enter your Caesar Key (must be an integer): ");
        int keyvalue = input2.nextInt();
        System.out.print("Using the Caesar Cipher, your Encrypted Password is: ");
        StringBuffer Encryption = new StringBuffer();
        if (password.length() == 8) {
        for (int i = 0; i < password.length(); i++) {
            char p = password.charAt(i); // each character in input for encryption
            if (p >= 32 && p < 127) {
                if ((keyvalue % 95) < (127 - p)) {
                    char E1 = (char)(p + (keyvalue % 95));
                    Encryption.append(E1);
                    
                }
                else {
                    char E1 = (char)(((p + (keyvalue % 95)) % 127) + 32);
                    Encryption.append(E1);
                }
                
        } else {
               System.out.print("ERROR: Your password contains an invalid character (must be one of the 95 typeable ASCII characters, range: 32-126)");
               System.exit(0);
            }
        }
        System.out.println(Encryption);
        } else {
            System.out.print("ERROR: password must be 8 characters.");
            System.exit(0);
        }
        System.out.println("********* Decryption *********");
        Scanner input3 = new Scanner(System.in);
        System.out.print("Please enter an 8-character password to decrypt: "); 
        String password2 = input3.nextLine();
        Scanner input4 = new Scanner(System.in);
        System.out.print("Please enter your Caesar Key (must be an integer): ");
        int keyvalue2 = input4.nextInt();
        System.out.print("Using the Caesar Cipher, your Decrypted Password is: ");
        StringBuffer Decryption = new StringBuffer();
        if (password2.length() == 8) {
        for (int j = 0; j < password2.length(); j++) {
            char p2 = password2.charAt(j); // each character in input for decryption
            if (p2 >= 32 && p2 < 127) {
                if ((keyvalue2 % 95) < (p2 - 31)) {
                    char D1 = (char)(p2 - (keyvalue2 % 95));
                    Decryption.append(D1);
                } else {
                    char D1 = (char)(((p2 - (keyvalue2 % 95)) % 32) + 95);
                    Decryption.append(D1);
                }
                // find decryption formula
            } else {
               System.out.print("ERROR: Your password contains an invalid character (must be one of the 95 typeable ASCII characters, range: 32-126)");
               System.exit(0);
            }
        }
          System.out.println(Decryption);  
        } else {
          System.out.print("ERROR: password must be 8 characters.");
          System.exit(0);  
        }
        System.out.println("Original Plaintext Password: " + password);
        System.out.println("Decrypted Plaintext Password: " + Decryption);
        String DecryptionString = Decryption.toString(); // turns the stringbuffer to string so we can compare
        if (password.equals(DecryptionString)) {
            System.out.println("These two passwords are equivalent");
        } else {
            System.out.println("These two passwords are not equivalent");
        }
    }
    
}
