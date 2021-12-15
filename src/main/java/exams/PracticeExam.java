package exams;

import java.util.List;

public class PracticeExam extends Exam {

    public PracticeExam(long studentId, String topic, List<Integer> maxPoints) {
        super(studentId, topic);
        setMaxPoints(calculateMaxPoints(maxPoints));
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        if (isPassed(actualPoints)) {
            if (actualPoints <= getMaxPoints() * 0.76) {
                setExamResult(ExamResult.OK);
            } else {
                setExamResult(ExamResult.PERFECT);
            }
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }

    private int calculateMaxPoints(List<Integer> maxPoints) {
        int sum = 0;
        for (int maxPoint : maxPoints) {
            sum += maxPoint;
        }
        if (sum < 10 || sum > 150) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! Actual:" + sum);
        }
        return sum;
    }
}
