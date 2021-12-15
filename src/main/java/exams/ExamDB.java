package exams;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {

    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoint) {
        exam.calculateExamResult(actualPoint);
        exams.add(exam);
    }

    public List<Exam> getExams() {
        return new ArrayList<>(exams);
    }

    public int countPassedExams() {
        int sum = 0;
        for (Exam exam : exams) {
            if (!(ExamResult.NOT_PASSED == exam.getExamResult())) {
                sum++;
            }
        }
        return sum;
    }

    public List<Exam> findById(long iD) {
        List<Exam> result = new ArrayList<>();
        for (Exam exam : exams) {
            if (iD == exam.getStudentId()) {
                result.add(exam);
            }
        }
        return result;
    }

    public List<String> findTopicByPrefix(String prefixOfTopic) {
        List<String> result = new ArrayList<>();
        for (Exam exam : exams) {
            if (!result.contains(exam.getTopic())
                    && exam.getTopic().startsWith(prefixOfTopic)) {
                result.add(exam.getTopic());
            }
        }
        return result;
    }
}
