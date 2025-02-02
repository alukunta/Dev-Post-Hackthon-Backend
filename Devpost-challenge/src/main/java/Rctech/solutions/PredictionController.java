package Rctech.solutions;

import com.google.protobuf.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    @PostMapping
    public String predict(@RequestBody List<Value> inputs) throws IOException {
        return predictionService.predictOutcome(inputs);
    }
}
