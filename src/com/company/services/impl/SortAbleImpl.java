package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortAbleImpl implements SortAble {
    public static Scanner scanner = new Scanner(System.in);
    @Override
    public void printAllMovies() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.println("---------ALL MOVIES----------");
        for (Movie i: movieList) {
            System.out.println("Name:        " + i.getName());
            System.out.println("Year:        " + i.getYear());
            System.out.println("Description: " + i.getDescription());
            System.out.println("Director:    " + i.getDirector().getFullName());
            System.out.println("Cast: ");
            for (int j = 0; j < i.getCast().size(); j++) {
            System.out.println("Full name:   " + i.getCast().get(j).getFullName());
            System.out.println("Role:        " + i.getCast().get(j).getRole());
            }
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void findMovie() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter movie's name: ");
        String movieName = scanner.nextLine();
        int counter = 0;
        for (Movie movie : movieList) {
            if (movie.getName().equalsIgnoreCase(movieName) ||
                    movie.getName().toLowerCase().contains(movieName.toLowerCase())) {
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
            }
        }
        try {
            if (counter == 0)
                throw new Exception();
        } catch (Exception e) {
            System.out.println(movieName + " is not found");
        }
    }

    @Override
    public void sortByYear() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter 1 (sort In Accending Order)\nEnter 2 (sort In Deccending Order): ");
        String choose = scanner.nextLine();
        String choose1 = "1", choose2 = "2";
        if (choose.length() > 0) {
            if (choose.equals(choose1)) {
                Comparator<Movie> sortMovieByYearInAccendingOrder = new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getYear() - o2.getYear();
                    }
                };
                movieList.sort(sortMovieByYearInAccendingOrder);
                for (Movie i : movieList) {
                    System.out.println(i);
                }
            }
            if (choose.equals(choose2)) {
                Comparator<Movie> sortMovieByYearInDeccendingOrder = new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o2.getYear() - o1.getYear();
                    }
                };
                movieList.sort(sortMovieByYearInDeccendingOrder);
                for (Movie i : movieList) {
                    System.out.println(i);
                }
            }
            else{
                System.out.println("No such button!");
            }
        }
    }


    @Override
    public void sortByName() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter 1 (sort In Accending Order)\nEnter 2 (sort In Deccending Order): ");
        String choose = scanner.nextLine();
        String choose1 = "1", choose2 = "2";
        if (choose.length() > 0) {
            if (choose.equals(choose1)) {
                movieList.sort(Movie.sortMovieByNameInAccendingOrder);
                for (Movie i : movieList) {
                    System.out.println(i);
                }
            }
            if (choose.equals(choose2)) {
                movieList.sort(Movie.sortMovieByNameInDeccendingOrder);
                for (Movie i : movieList) {
                    System.out.println(i);
                }
            }
            else{
                System.out.println("No such button!");
            }
        }
    }


    @Override
    public void sortByDirector() {
        List<Movie> movieList = JsonIO.getMovies();
        System.out.print("Enter 1 (sort In Accending Order)\nEnter 2 (sort In Deccending Order): ");
        String choose = scanner.nextLine();
        String choose1 = "1", choose2 = "2";
        if (choose.length() > 0) {
            if (choose.equals(choose1)) {
                movieList.sort(Movie.sortMovieByDirectorInAccendingOrder);
                for (Movie i : movieList) {
                    System.out.println(i);
                }
            }
            if (choose.equals(choose2)) {
                movieList.sort(Movie.sortMovieByDirectorInDeccendingOrder);
                for (Movie i : movieList) {
                    System.out.println(i);
                }
            }
            else{
                System.out.println("No such button!");
            }
        }
    }
}
