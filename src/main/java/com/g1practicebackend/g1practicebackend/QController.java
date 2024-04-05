package com.g1practicebackend.g1practicebackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
public class QController {
    @Autowired
    private QRepository qRepository;

    @Autowired
    private HRepository hRepository;

    @Autowired
    private StatisticsQuery statisticsQuery;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path="/getans")
    public @ResponseBody G1Question getAnswerById(
        @RequestParam Integer Id,
        @RequestParam String Ans
    ) {
        /* Query the correct answer */
        Optional<G1Question> result = qRepository.findById(Id);
        if (result.isEmpty()) {
            return G1Question.builder().build();
        }

        /* Save to history */
        boolean isCorrect = result.get().getAnswer().equalsIgnoreCase(Ans);
        G1History newAttempt = G1History.builder()
                                        .questionNo(Id)
                                        .selection(Ans)
                                        .isCorrect(isCorrect)
                                        .build();
        hRepository.save(newAttempt);
        
        /* Respond to the request with the correct answer */
        return result.get();
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping(path="/reqstat")
    public @ResponseBody QStatistics getStatById(@RequestParam Integer Id) {
        var numAttempts = statisticsQuery.countAttempts(Id);
        var numCorrect = statisticsQuery.countCorrectAttempts(Id);
        return QStatistics.builder()
                          .numAttempts(numAttempts)
                          .numCorrect(numCorrect)
                          .build();
    }
}
