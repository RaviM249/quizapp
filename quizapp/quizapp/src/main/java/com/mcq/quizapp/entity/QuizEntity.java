package com.mcq.quizapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class QuizEntity {
    @Id
    int id;
    String question;
    List<String> options= new ArrayList<>();
    String answer;
}

