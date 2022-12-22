package com.Data_Structures_byprayush.problems;
/*

Walktober (4pts, 6pts)

Submissions
You have not attempted this problem.
Last updated: Oct 15 2022, 19:03

Problem
John participates in an annual walking competition called Walktober.
The competition runs for a total of N days and tracks the daily steps of the participants for all the N days.
 Each participant will be assigned a unique ID ranging from 1 to M where M is the total number of registered participants.
  A global scoreboard is maintained tracking the daily steps of each participant.

John is determined to win Walktober this year and his goal is to score the maximum daily steps on each of the N days among all the participants.
 Having participated in Walktober last year as well,
he wanted to know how many steps he fell short of in achieving his goal.
 Given the previous year scoreboard,
calculate the minimum additional steps he needed over his last year score in order to achieve his goal of scoring the maximum daily steps every day.

Input
The first line of the input gives the number of test cases, T. T test cases follow.
The first line of each test case contains three integers M, N, and P denoting the total number of participants, the total number of days the competition runs, and the last year participant ID of John.
The next M lines describe the scoreboard of the previous year and contains N integers each. The j-th integer of the i-th line denotes the step count Si,j of the participant with ID i on the j-th day of the competition.

Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the minimum total additional steps needed by John to achieve his goal.

Limits
Memory limit: 1 GB.
1≤T≤100.
1≤N≤31.
1≤Si,j≤60000 for all i and j.
1≤P≤M.
Test Set 1
Time limit: 20 seconds.
M=2.
Test Set 2
Time limit: 40 seconds.
2≤M≤1000.
Sample
Note: there are additional samples that are not run on submissions down below.
Sample Input
save_alt
content_copy
1
2 3 1
1000 2000 3000
1500 1500 3000
Sample Output
save_alt
content_copy
Case #1: 500
In the Sample Case, the competition ran for 3 days and the participant ID of John was 1. On day 1, as the other participant has more steps, John needs 500 additional steps. On the rest of the days, as John already has the maximum steps, he needs no additional steps. So, he needs a total of 500 additional steps to achieve his goal.


Additional Sample - Test Set 2
The following additional sample fits the limits of Test Set 2. It will not be run against your submitted solutions.
Sample Input
save_alt
content_copy
2
3 2 3
1000 2000
1500 4000
500 4000
3 3 2
1000 2000 1000
1500 2000 1000
500 4000 1500
Sample Output
save_alt
content_copy
Case #1: 1000
Case #2: 2500
In the Sample Case #1, the competition ran for 2 days and the participant ID of John was 3. He needs an additional 1000 steps on day 1 and 0 steps on day 2 to achieve his goal. So, he needs a total of 1000 additional steps to achieve his goal.

In the Sample Case #2, the competition ran for 3 days and the participant ID of John was 2. He needs an additional 0 steps on day 1, 2000 steps on day 2, and 500 steps on day 3 to achieve his goal. So, he needs a total of 2500 additional steps to achieve his goal.
 */

import java.util.Scanner;
public class Walktober_Kickstart {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int M = scan.nextInt();
            int N = scan.nextInt();
            int P = scan.nextInt();
        }
    }
}
