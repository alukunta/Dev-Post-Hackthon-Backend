package Rctech.solutions;

import com.google.cloud.aiplatform.v1.*;
import com.google.protobuf.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class PredictionService {

    private static final String PROJECT_ID = "your-project-id";
    private static final String MODEL_ID = "your-model-id";
    private static final String ENDPOINT = "us-central1-aiplatform.googleapis.com";

    public String predictOutcome(List<Value> inputs) throws IOException {
        try (PredictionServiceClient predictionServiceClient = PredictionServiceClient.create()) {
            EndpointName endpoint = EndpointName.of(PROJECT_ID, "us-central1", MODEL_ID);
            PredictRequest request = PredictRequest.newBuilder()
                    .setEndpoint(endpoint.toString())
                    .addAllInstances(inputs)
                    .build();
            PredictResponse response = predictionServiceClient.predict(request);
            return response.toString();
        }
    }
}
