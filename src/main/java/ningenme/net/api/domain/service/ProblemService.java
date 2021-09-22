package ningenme.net.api.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.entity.Problem;
import ningenme.net.api.infrastructure.sqs.ProblemSqsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProblemService {

    private final ProblemSqsRepository problemSqsRepository;

    public void putProblem(@NonNull final Problem problem) {
        problemSqsRepository.sendProblem(problem);
    }
}
