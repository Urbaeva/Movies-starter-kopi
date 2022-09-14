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
        String actorName = scanner.nextLine().trim();
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
        String directorName = scanner.nextLine().trim();
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
        try {
            System.out.print("Enter movie's year: ");
            int year = scanner.nextInt();
            if (year >= 2005 && year <= 2022) {
                for (Movie movie : movieList) {
                    if (movie.getYear() == year) {
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
                    }
                }
            } else {
                System.out.println("This movie is not in the catalog!");
            }
        } catch (Exception e){
            System.out.println("It's not year!");
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
        String choose = scanner.nextLine();
        String choose1 = "1", choose2 = "2";
        if (choose.length() > 0) {
            if (choose.equals(choose1)) {
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
            if (choose.equals(choose2)) {
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
            } else {
                System.out.println("No such button!");
            }
        }
    }
}
