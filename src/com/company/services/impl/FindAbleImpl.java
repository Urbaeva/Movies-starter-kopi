package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Movie;
import com.company.services.FindAble;

import java.util.*;

public class FindAbleImpl implements FindAble {
    public static Scanner scanner = new Scanner(System.in);

    @Override
    public void findMoviesByActor() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter actor's name: ");
        String actorName = scanner.nextLine();
        int counter = 0;
        for (Movie movie : movieList) {
            for (int j = 0; j < movie.getCast().size(); j++) {
                if (movie.getCast().get(j).getFullName().equalsIgnoreCase(actorName) ||
                        movie.getCast().get(j).getFullName().toLowerCase().contains(actorName.toLowerCase())) {
                    System.out.println("Actor name: " + movie.getCast().get(j).getFullName());
                    System.out.println("Movie:      " + movie.getName());
                    counter++;
                }
            }
        }
        try {
            if (counter == 0)
                throw new Exception();
        }
        catch (Exception e){
            System.out.println(actorName + " is not found");
        }
    }

    @Override
    public void findMoviesByDirector() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter director's name: ");
        String directorName = scanner.nextLine();
        int counter = 0;
        for (Movie movie : movieList) {
            if (movie.getDirector().getFullName().equalsIgnoreCase(directorName) ||
                    movie.getDirector().getFullName().toLowerCase().contains(directorName.toLowerCase())) {
                System.out.println("Name:        " + movie.getName());
                System.out.println("Year:        " + movie.getYear());
                System.out.println("Description: " + movie.getDescription());
                System.out.println("Director:    " + movie.getDirector().getFullName());
                System.out.println("Cast: ");
                for (int j = 0; j < movie.getCast().size(); j++) {
                    System.out.println("Full name:   " + movie.getCast().get(j).getFullName());
                    System.out.println("Role:        " + movie.getCast().get(j).getRole());
                }
                System.out.println("------------------------------");
                counter++;
                break;
            }
        }
        try {
            if (counter == 0)
                throw new Exception();
        }
        catch (Exception e){
            System.out.println(directorName + " is not found");
        }
    }

    @Override
    public void findMoviesByYear() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter movie's year: ");
        int year = scanner.nextInt();
        int counter = 0;
        for (int i = 0; i < movieList.size(); i++) {
            if (JsonIO.getMovies().get(i).getYear() == year){
                System.out.println("Name:        " + movieList.get(i).getName());
                System.out.println("Year:        " + movieList.get(i).getYear());
                System.out.println("Description: " + movieList.get(i).getDescription());
                System.out.println("Director:    " + movieList.get(i).getDirector().getFullName());
                System.out.println("Cast: ");
                for (int j = 0; j < movieList.get(i).getCast().size(); j++) {
                    System.out.println("Full name:   " + movieList.get(i).getCast().get(j).getFullName());
                    System.out.println("Role:        " + movieList.get(i).getCast().get(j).getRole());
                }
                System.out.println("------------------------------");
                counter++;
                break;
            }
        }
        try {
            if (counter == 0)
                throw new Exception();
        }
        catch (Exception e){
            System.out.println(year + " is not found");
        }
    }

    @Override
    public void findMoviesAndRoleByActor() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter actor's name: ");
        String actorName = scanner.nextLine();
        int counter = 0;
        for (Movie movie : movieList) {
            for (int j = 0; j < movie.getCast().size(); j++) {
                if (movie.getCast().get(j).getFullName().equalsIgnoreCase(actorName) ||
                        movie.getCast().get(j).getFullName().toLowerCase().contains(actorName.toLowerCase())) {
                    System.out.println("Actor name:   " + movie.getCast().get(j).getFullName());
                    System.out.println("Movie name: " + movie.getName());
                    System.out.println("Role:        " + movie.getCast().get(j).getRole());
                    counter++;
                    break;
                }
            }
        }
        try {
            if (counter == 0)
                throw new Exception();
        }
        catch (Exception e){
            System.out.println(actorName + " is not found");
        }
    }

    @Override
    public void showActorRoles() {
        List<Movie> movieList = JsonIO.getMovies();
        TreeSet<Cast> treeSetActors = new TreeSet<>();
        for (Movie i : movieList) {
            treeSetActors.addAll(i.getCast());
        }
        System.out.print("Enter 1 (sort In Accending Order)\nEnter 2 (sort In Deccending Order): ");
        int choose = scanner.nextInt();
        if (choose == 1) {
            for (Cast cast : treeSetActors) {
                System.out.println("Actor name: " + cast.getFullName());
                for (Movie movie : movieList) {
                    for (int k = 0; k < movie.getCast().size(); k++) {
                        if (cast.getFullName().equals(movie.getCast().get(k).getFullName())) {
                            System.out.println("Movie name: " + movie.getName());
                            System.out.print("Roles     : ");
                            System.out.println("* " + movie.getCast().get(k).getRole() + "  ");
                        }
                    }
                }
                System.out.println("________________________________");
            }
        }
        if (choose == 2) {
            TreeSet<Cast> treeSetActorDes = (TreeSet<Cast>) treeSetActors.descendingSet();
            for (Cast cast : treeSetActorDes) {
                System.out.println("Actor name: " + cast.getFullName());
                for (Movie movie : movieList) {
                    for (int k = 0; k < movie.getCast().size(); k++) {
                        if (cast.getFullName().equals(movie.getCast().get(k).getFullName())) {
                            System.out.println("Movie name: " + movie.getName());
                            System.out.print("Roles     : ");
                            System.out.println("* " + movie.getCast().get(k).getRole() + "  ");
                        }
                    }
                }
                System.out.println("________________________________");
            }
        }
    }

//    @Override
//    public void showActorRoles() {
//        List<Movie> movieList = JsonIO.getMovies();
//        List<Cast> listActors = new ArrayList<>();
//        for (Movie i : movieList) {
//            listActors.addAll(i.getCast());
//        }
//        System.out.print("Enter 1 (sort In Accending Order)\nEnter 2 (sort In Deccending Order): ");
//        int choose = scanner.nextInt();
//        if (choose == 1) {
//            listActors.sort(Cast.sortActorNameInAccendingOrder);
//            for (Cast i : listActors) {
//                System.out.println("Actor name: " + i.getFullName() + "\t\tRoll: " + i.getRole());
//            }
//        }
//        if (choose == 1) {
//            listActors.sort(Cast.sortActorNameInDeccendingOrder);
//            for (Cast i : listActors) {
//                System.out.println("Actor name: " + i.getFullName() + "\t\tRoll: " + i.getRole());
//            }
//        }
//    }


}
