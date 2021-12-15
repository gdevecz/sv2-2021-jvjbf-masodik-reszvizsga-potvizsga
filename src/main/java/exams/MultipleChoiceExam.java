package exams;

public class MultipleChoiceExam extends Exam {

    private ExamResult result;

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        if (isPassed(actualPoints)) {
            setExamResult(ExamResult.PASSED);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
