package com.Data_Structures_byprayush.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MissionariesCannibals {

    public static void main(String[] args) {
        System.out.println("==== Missionaries and Cannibals Problem ====");
        String optionStr = "1";


        int option = Integer.parseInt(optionStr);
        State initialState = new State (3, 3, Position.LEFT, 0, 0);
        switch(option) {
            case 1:
                executeBFS(initialState);
                break;
            default:
                System.out.println("[ERROR] Invalid search option.");
        }
    }

    private static void executeBFS(State initialState) {
        BreadthFirstSearch search = new BreadthFirstSearch();
        State solution = search.exec(initialState);
        printSolution(solution);
    }

    private static void printSolution(State solution) {
        if (null == solution) {
            System.out.print("\nNo solution found.");
        } else {
            System.out.println("\nSolution (cannibalLeft,missionaryLeft,boat,cannibalRight,missionaryRight): ");
            List<State> path = new ArrayList<State>();
            State state = solution;
            while(null!=state) {
                path.add(state);
                state = state.getParentState();
            }

            int depth = path.size() - 1;
            for (int i = depth; i >= 0; i--) {
                state = path.get(i);
                if (state.isGoal()) {
                    System.out.print(state.toString());
                } else {
                    System.out.print(state.toString() + " -> ");
                }
            }
            System.out.println("\nDepth: " + depth);
        }
    }
}

class BreadthFirstSearch {

    public State exec(State initialState) {
        if (initialState.isGoal()) {
            return initialState;
        }
        Queue<State> frontier = new LinkedList<State>();	// FIFO queue
        Set<State> explored = new HashSet<State>();
        frontier.add(initialState);
        while (true) {
            if (frontier.isEmpty()) {
                return null;	// failure
            }
            State state = frontier.poll();
            explored.add(state);
            List<State> successors = state.generateSuccessors();
            for (State child : successors) {
                if (!explored.contains(child) || !frontier.contains(child)) {
                    if (child.isGoal()) {
                        return child;
                    }
                    frontier.add(child);
                }
            }
        }
    }
}



enum Position {RIGHT, LEFT}

class State {

    private int cannibalLeft;
    private int missionaryLeft;
    private int cannibalRight;
    private int missionaryRight;
    private Position boat;

    private State parentState;

    public State(int cannibalLeft, int missionaryLeft, Position boat,
                 int cannibalRight, int missionaryRight) {
        this.cannibalLeft = cannibalLeft;
        this.missionaryLeft = missionaryLeft;
        this.boat = boat;
        this.cannibalRight = cannibalRight;
        this.missionaryRight = missionaryRight;
    }

    public boolean isGoal() {
        return cannibalLeft == 0 && missionaryLeft == 0;
    }

    public boolean isValid() {
        if (missionaryLeft >= 0 && missionaryRight >= 0 && cannibalLeft >= 0 && cannibalRight >= 0
                && (missionaryLeft == 0 || missionaryLeft >= cannibalLeft)
                && (missionaryRight == 0 || missionaryRight >= cannibalRight)) {
            return true;
        }
        return false;
    }

    public List<State> generateSuccessors() {
        List<State> successors = new ArrayList<State>();
        if (boat == Position.LEFT) {
            testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 2, Position.RIGHT,
                    cannibalRight, missionaryRight + 2)); // Two missionaries cross left to right.
            testAndAdd(successors, new State(cannibalLeft - 2, missionaryLeft, Position.RIGHT,
                    cannibalRight + 2, missionaryRight)); // Two cannibals cross left to right.
            testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft - 1, Position.RIGHT,
                    cannibalRight + 1, missionaryRight + 1)); // One missionary and one cannibal cross left to right.
            testAndAdd(successors, new State(cannibalLeft, missionaryLeft - 1, Position.RIGHT,
                    cannibalRight, missionaryRight + 1)); // One missionary crosses left to right.
            testAndAdd(successors, new State(cannibalLeft - 1, missionaryLeft, Position.RIGHT,
                    cannibalRight + 1, missionaryRight)); // One cannibal crosses left to right.
        } else {
            testAndAdd(successors, new State(cannibalLeft, missionaryLeft + 2, Position.LEFT,
                    cannibalRight, missionaryRight - 2)); // Two missionaries cross right to left.
            testAndAdd(successors, new State(cannibalLeft + 2, missionaryLeft, Position.LEFT,
                    cannibalRight - 2, missionaryRight)); // Two cannibals cross right to left.
            testAndAdd(successors, new State(cannibalLeft + 1, missionaryLeft + 1, Position.LEFT,
                    cannibalRight - 1, missionaryRight - 1)); // One missionary and one cannibal cross right to left.
            testAndAdd(successors, new State(cannibalLeft, missionaryLeft + 1, Position.LEFT,
                    cannibalRight, missionaryRight - 1)); // One missionary crosses right to left.
            testAndAdd(successors, new State(cannibalLeft + 1, missionaryLeft, Position.LEFT,
                    cannibalRight - 1, missionaryRight)); // One cannibal crosses right to left.
        }
        return successors;
    }

    private void testAndAdd(List<State> successors, State newState) {
        if (newState.isValid()) {
            newState.setParentState(this);
            successors.add(newState);
        }
    }

    public int getCannibalLeft() {
        return cannibalLeft;
    }

    public void setCannibalLeft(int cannibalLeft) {
        this.cannibalLeft = cannibalLeft;
    }

    public int getMissionaryLeft() {
        return missionaryLeft;
    }

    public void setMissionaryLeft(int missionaryLeft) {
        this.missionaryLeft = missionaryLeft;
    }

    public int getCannibalRight() {
        return cannibalRight;
    }

    public void setCannibalRight(int cannibalRight) {
        this.cannibalRight = cannibalRight;
    }

    public int getMissionaryRight() {
        return missionaryRight;
    }

    public void setMissionaryRight(int missionaryRight) {
        this.missionaryRight = missionaryRight;
    }

    public void goToLeft() {
        boat = Position.LEFT;
    }

    public void goToRight() {
        boat = Position.RIGHT;
    }

    public boolean isOnLeft() {
        return boat == Position.LEFT;
    }

    public boolean isOnRigth() {
        return boat == Position.RIGHT;
    }

    public State getParentState() {
        return parentState;
    }

    public void setParentState(State parentState) {
        this.parentState = parentState;
    }

    @Override
    public String toString() {
        if (boat == Position.LEFT) {
            return "(" + cannibalLeft + "," + missionaryLeft + ",L,"
                    + cannibalRight + "," + missionaryRight + ")";
        } else {
            return "(" + cannibalLeft + "," + missionaryLeft + ",R,"
                    + cannibalRight + "," + missionaryRight + ")";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof State)) {
            return false;
        }
        State s = (State) obj;
        return (s.cannibalLeft == cannibalLeft && s.missionaryLeft == missionaryLeft
                && s.boat == boat && s.cannibalRight == cannibalRight
                && s.missionaryRight == missionaryRight);
    }
}