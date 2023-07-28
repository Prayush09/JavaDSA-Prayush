package com.Data_Structures_byprayush.Algorithms.AI;

import java.util.*;

class StudyPlan {
    String subject;
    int studyHours;

    StudyPlan(String subject, int studyHours) {
        this.subject = subject;
        this.studyHours = studyHours;
    }
}

class StudyPlanner {
    List<StudyPlan> generateStudyPlan(String[] subjects, int[] difficultyLevel, int totalStudyHours) {
        List<StudyPlan> studyPlan = new ArrayList<>();
        int totalSubjects = subjects.length;

        // Calculate total difficulty score to distribute study hours proportionately
        int totalDifficultyScore = 0;
        for (int i = 0; i < totalSubjects; i++) {
            totalDifficultyScore += difficultyLevel[i];
        }

        // Generate study plan based on difficulty level
        for (int i = 0; i < totalSubjects; i++) {
            double difficultyRatio = (double) difficultyLevel[i] / totalDifficultyScore;
            int hoursForSubject = (int) (totalStudyHours * difficultyRatio);
            studyPlan.add(new StudyPlan(subjects[i], hoursForSubject));
        }

        return studyPlan;
    }
}

public class PersonalizedStudyPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] subjects = { "Math", "Science", "History", "English" };
        int[] difficultyLevel = { 3, 2, 2, 1 };


        StudyPlanner studyPlanner = new StudyPlanner();

        System.out.println("Enter your learning goal (improve grades, deepen understanding, etc.):");
        String learningGoal = scanner.nextLine();

        System.out.println("Enter your preferred study hours (Note, only more than 8 hours of \nstudy will get you the best results!):");
        int totalStudyHours = scanner.nextInt();

        // Generate study plan based on user input and difficulty levels
        List<StudyPlan> studyPlan = studyPlanner.generateStudyPlan(subjects, difficultyLevel, totalStudyHours);

        System.out.println("\nTo achieve "+learningGoal+" we have created your Personalized Study Plan:");
        for (StudyPlan plan : studyPlan) {
            System.out.println(plan.subject + ": " + plan.studyHours + " hours");
        }
        scanner.nextLine();
        System.out.println("\nPlease provide feedback on the study plan (helpful, not helpful, etc.):");
        String feedback = scanner.nextLine();

        if (feedback.equals("not helpful")) {
            askForImprovementAreas(scanner);
        }

        scanner.close();
    }

    public static void askForImprovementAreas(Scanner scanner) {
        System.out.println("Please provide specific areas of improvement:");
        String improvementAreas = scanner.nextLine();

        // In a real implementation, you would store the improvement areas and use them to improve future recommendations.

        scanner.close(); // Close the scanner before printing the improvement confirmation
        System.out.println("Thank you for the feedback. We will improve upon it!");
    }
}
