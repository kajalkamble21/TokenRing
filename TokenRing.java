import java.util.Scanner;

public class TokenRing {
    private static int n; // Number of processes
    private static int token; // Index of the current process holding the token

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        n = sc.nextInt();

        System.out.println("Ring formed is as below: ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("0");

        token = 0; // Initialize token holder to process 0

        while (true) {
            System.out.println("Process " + token + " has the token.");

            System.out.println("Does process " + token + " want to access the shared resource? (yes/no)");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                // Process wants to access the shared resource
                System.out.println("Process " + token + " is in the critical section.");

                // Simulating critical section
                System.out.println("Process " + token + " is accessing the shared resource.");

                // Release the token
                System.out.println("Process " + token + " releases the token.");

                // Pass the token to the next process
                token = (token + 1) % n;
            } else {
                // Process doesn't want to access the shared resource, just pass the token
                System.out.println("Process " + token + " doesn't want to access the shared resource.");

                // Pass the token to the next process
                token = (token + 1) % n;
            }

            // Simulate some delay for token passing
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*PS C:\Users\Kajal\Desktop\ds codes> cd "c:\Users\Kajal\Desktop\ds codes\" ; if ($?) { javac TokenRing.java } ; if ($?) { java TokenRing }
Enter the number of processes: 5
Ring formed is as below: 
0 1 2 3 4 0
Process 0 has the token.
Does process 0 want to access the shared resource? (yes/no)
yes
Process 0 is in the critical section.
Process 0 is accessing the shared resource.
Process 0 releases the token.
Process 1 has the token.
Does process 1 want to access the shared resource? (yes/no)
no
Process 1 doesn't want to access the shared resource.
Process 2 has the token.
Does process 2 want to access the shared resource? (yes/no)
yes
Process 2 is in the critical section.
Process 2 is accessing the shared resource.
Process 2 releases the token.
Process 3 has the token.
Does process 3 want to access the shared resource? (yes/no)
no
Process 3 doesn't want to access the shared resource.
Process 4 has the token.
Does process 4 want to access the shared resource? (yes/no)
yes
Process 4 is in the critical section.
Process 4 is accessing the shared resource.
Process 4 releases the token.
Process 0 has the token.
Does process 0 want to access the shared resource? (yes/no)
no
Process 0 doesn't want to access the shared resource.
Process 1 has the token.
Does process 1 want to access the shared resource? (yes/no)
yes
Process 1 is in the critical section.
Process 1 is accessing the shared resource.
Process 1 releases the token.
Process 2 has the token.
Does process 2 want to access the shared resource? (yes/no)
no
Process 2 doesn't want to access the shared resource.
Process 3 has the token.
Does process 3 want to access the shared resource? (yes/no)
no
Process 3 doesn't want to access the shared resource.
Process 4 has the token.
Does process 4 want to access the shared resource? (yes/no)
yes
Process 4 is in the critical section.
Process 4 is accessing the shared resource.
Process 4 releases the token.
Process 0 has the token.
Does process 0 want to access the shared resource? (yes/no)
 */