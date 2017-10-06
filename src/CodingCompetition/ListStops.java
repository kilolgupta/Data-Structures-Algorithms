package CodingCompetition;

import java.util.*;

public class ListStops {

    public static class Person {
        int weight;
        int floor;

        public Person(int x, int y) {
            this.weight = x;
            this.floor = y;
        }
    }

    private static int solution(int[] A, int[] B, int M, int X, int Y) {
        Queue<Person> listOfPersons = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            Person person = new Person(A[i], B[i]);
            listOfPersons.add(person);
        }


        int leftPersons = X;
        int leftWeight = Y;
        int personWeight;

        int countOfStops = 0;
        Set<Integer> stops = new TreeSet<Integer>();

        while (!listOfPersons.isEmpty()) {
            while (leftWeight > 0 && leftPersons > 0 && !listOfPersons.isEmpty()) {
                Person personInOrder = listOfPersons.peek();
                personWeight = personInOrder.weight;
                if (leftWeight - personWeight >= 0)
                    leftWeight -= personWeight;
                else break;

                leftPersons -= 1;
                stops.add(personInOrder.floor);
                listOfPersons.remove();
            }
            countOfStops += stops.size() + 1;
            leftPersons = X;
            leftWeight = Y;
            stops.clear();
        }
        return countOfStops;

    }


    public static void main(String[] args) {
        int[] A = {60, 80, 40};
        int[] B = {2, 3, 5};
        int X=2;
        int Y=200;
        int M=5;
        solution(A, B, M, X, Y);
    }


}


