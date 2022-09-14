package com.company;

import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        FindAbleImpl findAble = new FindAbleImpl();
        SortAbleImpl sortAble = new SortAbleImpl();


        while (true) {
            commands();
            String button = button();
            switch (button) {
                case "1" -> sortAble.printAllMovies();
                case "2" -> sortAble.findMovie();
                case "3" -> sortAble.sortByYear();
                case "4" -> sortAble.sortByName();
                case "5" -> sortAble.sortByDirector();
                case "6" -> findAble.findMoviesByActor();
                case "7" -> findAble.findMoviesByDirector();
                case "8" -> findAble.findMoviesByYear();
                case "9" -> findAble.findMoviesAndRoleByActor();
                case "10" -> findAble.showActorRoles();
            }
            if (button.equals("x")) break;
        }


//        String number = "null";
//        while (!number.equals("x")){
//            commands();
//            System.out.println("Choose a command: ");
//            number = in.nextLine();
//            try{
//                if (Character.isDigit(number.charAt(0))){
//                    switch (number){
//                        case "1" -> sortAble.printAllMovies();
//                        case "2" -> sortAble.findMovie();
//                        case "3" -> sortAble.sortByYear();
//                        case "4" -> sortAble.sortByName();
//                        case "5" -> sortAble.sortByDirector();
//                        case "6" -> findAble.findMoviesByActor();
//                        case "7" -> findAble.findMoviesByDirector();
//                        case "8" -> findAble.findMoviesByYear();
//                        case "9" -> findAble.findMoviesAndRoleByActor();
//                        case "10" -> findAble.showActorRoles();
//                    }
//                }else {
//                    throw new RuntimeException();
//                }
//            } catch (RuntimeException e) {
//                System.out.println("It is not a button");
//            }
//    }
    }


    static void commands() {
        System.out.println("--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }

    static String button() {
        System.out.print("Choose a command: ");
        return in.nextLine();
    }
}
