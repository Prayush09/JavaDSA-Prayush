package com.Data_Structures_byprayush.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WaterJugProblem {
    private static class State {
        int jug1;
        int jug2;
        List<String> steps;

        State(int jug1, int jug2, List<String> steps) {
            this.jug1 = jug1;
            this.jug2 = jug2;
            this.steps = steps;
        }

        @Override
        public int hashCode() {
            int prime = 31;
            int result = 1;
            result = prime * result + jug1;
            result = prime * result + jug2;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            State other = (State) obj;
            return jug1 == other.jug1 && jug2 == other.jug2;
        }
    }

    private static void waterJugProblem(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Set<State> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();

        List<String> initialSteps = new ArrayList<>();
        State initialState = new State(0, 0, initialSteps);
        queue.offer(initialState);
        visited.add(initialState);

        while (!queue.isEmpty()) {
            State currentState = queue.poll();

            if (currentState.jug1 == targetCapacity || currentState.jug2 == targetCapacity) {
                System.out.println("Target capacity reached!");
                for (String step : currentState.steps) {
                    System.out.println(step);
                }
                return;
            }

            // Empty jug1
            List<String> newSteps = new ArrayList<>(currentState.steps);
            newSteps.add("Empty jug1");
            State newState = new State(0, currentState.jug2, newSteps);
            if (!visited.contains(newState)) {
                queue.offer(newState);
                visited.add(newState);
            }

            // Empty jug2
            newSteps = new ArrayList<>(currentState.steps);
            newSteps.add("Empty jug2");
            newState = new State(currentState.jug1, 0, newSteps);
            if (!visited.contains(newState)) {
                queue.offer(newState);
                visited.add(newState);
            }

            // Fill jug1
            newSteps = new ArrayList<>(currentState.steps);
            newSteps.add("Fill jug1");
            newState = new State(jug1Capacity, currentState.jug2, newSteps);
            if (!visited.contains(newState)) {
                queue.offer(newState);
                visited.add(newState);
            }

            // Fill jug2
            newSteps = new ArrayList<>(currentState.steps);
            newSteps.add("Fill jug2");
            newState = new State(currentState.jug1, jug2Capacity, newSteps);
            if (!visited.contains(newState)) {
                queue.offer(newState);
                visited.add(newState);
            }

            // Pour from jug1 to jug2
            int pourAmount = Math.min(currentState.jug1, jug2Capacity - currentState.jug2);
            newSteps = new ArrayList<>(currentState.steps);
            newSteps.add("Pour " + pourAmount + " from jug1 to jug2");
            newState = new State(currentState.jug1 - pourAmount, currentState.jug2 + pourAmount, newSteps);
            if (!visited.contains(newState)) {
                queue.offer(newState);
                visited.add(newState);
            }

            // Pour from jug2 to jug1
            pourAmount = Math.min(currentState.jug2, jug1Capacity - currentState.jug1);
            newSteps = new ArrayList<>(currentState.steps);
            newSteps.add("Pour " + pourAmount + " from jug2 to jug1");
            newState = new State(currentState.jug1 + pourAmount, currentState.jug2 - pourAmount, newSteps);
            if (!visited.contains(newState)) {
                queue.offer(newState);
                visited.add(newState);
            }
        }

        System.out.println("Target capacity cannot be reached!");
    }

    public static void main(String[] args) {
        int jug1Capacity = 8; // Capacity of jug 1
        int jug2Capacity = 5; // Capacity of jug 2
        int targetCapacity = 4; // Target capacity to be reached

        waterJugProblem(jug1Capacity, jug2Capacity, targetCapacity);
    }
}
