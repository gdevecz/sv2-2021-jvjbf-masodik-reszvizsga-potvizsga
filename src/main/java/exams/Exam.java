package exams;

public abstract class Exam {

    private long studentId;

    private String topic;

    private int maxPoints;

    private ExamResult examResult;

    public Exam(long studentId, String topic, int maxPoints) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = maxPoints;
    }

    public Exam(long studentId, String topic) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = 100;
    }

    public abstract void calculateExamResult(int actualPoints);

    protected boolean isPointsValid(int actualPoints) {
        return actualPoints >= 0 && actualPoints <= maxPoints;
    }

    protected void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public ExamResult getExamResult() {
        return examResult;
    }

    protected boolean isPassed(int actualPoints) {
        if(!isPointsValid(actualPoints)){
            throw new IllegalArgumentException("The points is invlaid.");
        }
        if (actualPoints >= (double) getMaxPoints() * 0.51) {
            return true;
        } else {
            return false;

        }
    }
}
