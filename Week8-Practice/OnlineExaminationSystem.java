import java.util.*;

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Student student = new Student("Student 1");

        Examination exam = new Examination("Exam A");
        exam.addQuestion(new MCQ("Question 1", "C", "C", 5));
        exam.addQuestion(new TrueFalse("Question 2", "False", "True", 5));

        Attempt attempt = new Attempt(student, exam);

        attempt.answer(0, "C");
        attempt.answer(1, "True");
        attempt.submit();
        attempt.answer(0, "A");
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

abstract class Question {
    String name, correctAnswer;
    int points;

    Question(String name, String correctAnswer, int points) {
        this.name = name;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    abstract boolean evaluate(String answer);
}

class MCQ extends Question {
    MCQ(String name, String answer, String correct, int points) {
        super(name, correct, points);
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class TrueFalse extends Question {
    TrueFalse(String name, String answer, String correct, int points) {
        super(name, correct, points);
    }

    boolean evaluate(String answer) {
        return correctAnswer.equalsIgnoreCase(answer);
    }
}

class Examination {
    String name;
    ArrayList<Question> questions = new ArrayList<>();

    Examination(String name) {
        this.name = name;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }
}

class Attempt {
    Student student;
    Examination exam;
    Map<Integer, String> answers = new HashMap<>();
    boolean submitted = false;

    Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
        System.out.println(exam.name + " started by " + student.name + ".");
    }

    void answer(int index, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }

        if (index < 0 || index >= exam.questions.size()) {
            System.out.println("Invalid question.");
            return;
        }

        answers.put(index, answer);
        System.out.println("Answer recorded for " +
                exam.questions.get(index).name + ".");
    }

    void submit() {
        if (submitted) {
            System.out.println("Examination already submitted.");
            return;
        }

        submitted = true;
        System.out.println(exam.name + " submitted by " + student.name + ".");

        int score = 0, total = 0;

        for (int i = 0; i < exam.questions.size(); i++) {
            Question q = exam.questions.get(i);
            total += q.points;

            boolean correct = q.evaluate(answers.getOrDefault(i, ""));
            int earned = correct ? q.points : 0;
            score += earned;

            System.out.println(q.name + ": " +
                    (correct ? "Correct" : "Incorrect") +
                    " (" + earned + " points)");
        }

        System.out.println("Total score: " + score + "/" + total + ".");
    }
}