package practice.aop.exam;

import org.springframework.stereotype.Repository;

import practice.aop.exam.annotation.Retry;
import practice.aop.exam.annotation.Trace;

@Repository
public class ExamRepository {

    private static int seq = 0;

    @Trace
    @Retry(value = 2)
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외발생");
        }
        return "ok";
    }
}
