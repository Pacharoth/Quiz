import java.util.ArrayList;
import java.util.Scanner;

public class Quiz {
    Scanner sc = new Scanner(System.in);
    ArrayList<Question> questions = new ArrayList<>();

    public Quiz() {

    }

    public void addQuestion() {
        System.out.print("Please input question");
        String question = sc.nextLine();
        System.out.print("Please input how many answer in this question:");
        int numberofAnswer = Integer.parseInt(sc.nextLine());
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i < numberofAnswer; i++) {
            System.out.println("Enter answer" + i + ":");
            String answer = sc.nextLine();
            answers.add(answer);
        }
        System.out.println("Index of answer that correct:");
        int correct = Integer.parseInt(sc.nextLine());
        Question aquestion = new Question(answers, question);
        questions.add(aquestion);
    }

    public void displayQuestion() {
        System.out.println("Question");
        int i = 0;
        for (Question q : questions) {
            System.out.println("index = " + i + "\t" + q.getQuestion() + "\t" + q.getAnswer());
        }
        if (questions.isEmpty()) {
            System.out.println("There is no question");
        }
    }

    public void updateQuestionAndAnswerByIndex() {
        displayQuestion();
        System.out.println("Enter index:");
        int index = Integer.parseInt(sc.nextLine());
        Question questionUpdate = findByIndex(index);
        if (questionUpdate != null) {
            System.out.println("New update question");
            System.out.print("Enter question:");
            String question = sc.nextLine();
            System.out.print("Please input how many answer in this question:");
            int numberofAnswer = Integer.parseInt(sc.nextLine());
            ArrayList<String> answers = new ArrayList<>();
            for (int i = 0; i < numberofAnswer; i++) {
                System.out.println("Enter answer" + i + ":");
                String answer = sc.nextLine();
                answers.add(answer);
            }
            System.out.println("Index of answer that correct:");
            int correct = Integer.parseInt(sc.nextLine());
            questionUpdate.setAnswer(answers);
            questionUpdate.setQuestion(question);
        } else {
            System.out.println("There is no that question at " + index);
        }
    }

    public void deleteQuestionAndAnswer() {
        displayQuestion();
        System.out.println("Enter index to delete:");
        int index = Integer.parseInt(sc.nextLine());
        Question q = findByIndex(index);
        if (q != null) {
            System.out.println("The question at index " + index + " is deleted");
            questions.remove(q);
        } else {
            System.out.println("there is no index at" + index);
        }
    }

    public Question findByIndex(int i) {
        int p = 0;
        for (Question q : questions) {
            if (i == p) {
                return q;
            }
        }
        return null;
    }

    public void readMenu() {
        System.out.println("-------------Welcome Quiz--------------");
        System.out.println("1. Add question and answer");
        System.out.println("2. Update question and answers");
        System.out.println("3. Delete question and answers");
        System.out.println("5. Quit");
        System.out.print("Enter choice:");
    }

    public static void main(String[] args) {
        int choice;
        Quiz quiz = new Quiz();
        Scanner sc = new Scanner(System.in);
        while (true) {
            quiz.readMenu();
            choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                quiz.addQuestion();
            } else if (choice == 2) {
                quiz.updateQuestionAndAnswerByIndex();
            } else if (choice == 3) {
                quiz.deleteQuestionAndAnswer();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Wrong operation");
                break;
            }
        }
    }
}

class Question {
    String question;
    int correct;
    ArrayList<String> answers = new ArrayList<>();

    public Question() {

    }

    public void setQuestion(String s) {
        this.question = s;
    }

    public void setAnswer(ArrayList<String> answer) {
        this.answers = answer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswer() {
        return answers;
    }

    public Question(ArrayList<String> answer, String question) {
        if (answer.size() >= 2 && answer.size() <= 4) {
            this.answers = answer;
        } else {
            System.out.println("exceed range amount (2-4)");
            this.answers = null;
        }
        this.question = question;
    }

}
