package ningenme.net.api.infrastructure.sqs;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ningenme.net.api.common.config.NetApiSqsConfig;
import ningenme.net.api.domain.entity.Problem;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProblemSqsRepository {

    private final NetApiSqsConfig netApiSqsConfig;

    public void sendProblem(@NonNull final Problem problem) {
        final AWSCredentials awsCredentials = new BasicAWSCredentials(netApiSqsConfig.getUserAccessKeyId(),netApiSqsConfig.getUserSecretAccessKey());
        final AmazonSQS amazonSQS = AmazonSQSClientBuilder.standard()
                                                          .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                                                          .build();
        amazonSQS.sendMessage(new SendMessageRequest().withQueueUrl(netApiSqsConfig.getUrlProblemSqs())
                                                      .withMessageBody(problem.getJson()));
    }
}
