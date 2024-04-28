package com.mcq.quizapp.configuration;

import com.mcq.quizapp.entity.QuizEntity;
import com.mcq.quizapp.repository.QuizRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class QuizInitialization {

    @Autowired
    private QuizRepository quizRepository;

    @PostConstruct
    public void init(){
        QuizEntity quiz1 = new QuizEntity();
        quiz1.setId(1);
        quiz1.setQuestion("What is the capital of France?");
        quiz1.getOptions().add("Paris");
        quiz1.getOptions().add("London");
        quiz1.getOptions().add("Berlin");
        quiz1.setAnswer("Paris");

        QuizEntity quiz2 = new QuizEntity();
        quiz2.setId(2);
        quiz2.setQuestion("Which planet is known as the Red Planet?");
        quiz2.getOptions().add("Mars");
        quiz2.getOptions().add("Venus");
        quiz2.getOptions().add("Jupiter");
        quiz2.setAnswer("Mars");

        QuizEntity quiz3 = new QuizEntity();
        quiz3.setId(3);
        quiz3.setQuestion("What is the capital of Japan?");
        quiz3.getOptions().add("Tokyo");
        quiz3.getOptions().add("Beijing");
        quiz3.getOptions().add("Seoul");
        quiz3.setAnswer("Tokyo");

        QuizEntity quiz4 = new QuizEntity();
        quiz4.setId(4);
        quiz4.setQuestion("Which of the following is a famous landmark in India?");
        quiz4.getOptions().add("Eiffel Tower");
        quiz4.getOptions().add("Taj Mahal");
        quiz4.getOptions().add("Great Wall of China");
        quiz4.setAnswer("Taj Mahal");

        QuizEntity quiz5 = new QuizEntity();
        quiz5.setId(5);
        quiz5.setQuestion("Who discovered the theory of relativity?");
        quiz5.getOptions().add("Isaac Newton");
        quiz5.getOptions().add("Albert Einstein");
        quiz5.getOptions().add("Stephen Hawking");
        quiz5.setAnswer("Albert Einstein");




        // Save initialized entities using the repository
        quizRepository.save(quiz1);
        quizRepository.save(quiz2);
        quizRepository.save(quiz3);
        quizRepository.save(quiz4);
        quizRepository.save(quiz5);

    }
}
