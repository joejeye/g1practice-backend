package com.g1practicebackend.g1practicebackend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QStatistics {
    private Integer numAttempts;
    private Integer numCorrect;
}
