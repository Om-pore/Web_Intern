import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter total no. of subjects :");
        int totalSubj = sc.nextInt();
        
        int[] marks = new int[totalSubj];

        for(int i=0; i<totalSubj; i++){
            System.out.println("Enter the marks obtained out of 100 in subject "+(i+1)+" :");
            marks[i] = sc.nextInt();
        }

        int TotalMarks = 0;

        for(int mark : marks) {
            
            TotalMarks = TotalMarks + mark;
        }

        float AverageMarks = TotalMarks / totalSubj;

        String grade;

        if(AverageMarks >= 90)
            grade = "A+";
        else if (AverageMarks >= 85)
            grade = "A";
        else if (AverageMarks >= 75)
            grade = "B";
        else if (AverageMarks >= 65)
            grade = "C";
        else if (AverageMarks >= 55)
            grade = "D";
        else
            grade = "F";



        System.out.println("Total marks :"+TotalMarks);
        System.out.println("Average Percentage :"+AverageMarks);
        System.out.println("Grade :"+grade);

        sc.close();
    }
}
