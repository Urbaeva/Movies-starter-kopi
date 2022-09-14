package com.company.models;

import java.util.Comparator;

public class Cast  implements Comparable<Cast>{

    private String fullName;
    private String role;

    public Cast(String fullName, String role) {
        this.fullName = fullName;
        this.role = role;
    }

    public Cast() {
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static Comparator<Cast> sortActorNameInAccendingOrder = new Comparator<Cast>() {
        @Override
        public int compare(Cast o1, Cast o2) {
            return o1.fullName.compareTo(o2.fullName);
        }
    };

    public static Comparator<Cast> sortActorNameInDeccendingOrder = new Comparator<Cast>() {
        @Override
        public int compare(Cast o1, Cast o2) {
            return o2.fullName.compareTo(o1.fullName);
        }
    };

    @Override
    public int compareTo(Cast o) {
        return this.fullName.compareTo(o.fullName);
    }
}
