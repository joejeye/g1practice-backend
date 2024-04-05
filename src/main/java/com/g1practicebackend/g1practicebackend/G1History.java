package com.g1practicebackend.g1practicebackend;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="test_history")
@Builder
public class G1History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="question_no")
    private Integer questionNo;

    @Column(name="selection")
    private String selection;

    @Column(name="is_correct")
    private Boolean isCorrect;

    @Column(name="submit_time")
    @CreationTimestamp
    private LocalDateTime submitTime;
}
