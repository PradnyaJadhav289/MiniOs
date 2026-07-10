package MiniOS.src.app;

import java.util.Scanner;

import MiniOS.src.terminal.Terminal;



public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Terminal.showwelcome();

        boolean running = true;

        while (running) {

            System.out.print("JavaOS> ");

            String command = scanner.nextLine();

           


            switch (command.toLowerCase()) {
                case "help":
                    Terminal.showhelp();
                    break;
                case "exit":
                    Terminal.showexit();
                    running = false;
                    break;
                case "clear":
                    Terminal.clearScreen();
                    break;
                case "date":
                    Terminal.showdate();
                    break;

                case "time":
                    Terminal.showtime();
                    break;

                case "about":
                    Terminal.showabout();
                    break;
            
                default:
                    Terminal.unknownCommand();
                    break;
            }
        }

        scanner.close();
    }
}
