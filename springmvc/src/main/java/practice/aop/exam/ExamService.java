package practice.aop.exam;

import org.springframework.stereotype.Service;

import practice.aop.exam.annotation.Trace;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    @Trace
    public void request(String itemId) {
        examRepository.save(itemId);
    }
}
