$(document).ready(function() {

    var questions = [
                     {question: "Which film won best picture for 2000?", choices: ["Chocolat","Crouching Tiger, Hidden Dragon","Gladiator","Erin Brokovich"], correctAnswer: 2},
                     {question: "Which film won best picture for 2001?", choices: ["Gosford Park", "A Beautiful Mind", "In the Bedroom","Moulin Rouge!"], correctAnswer: 1},
                     {question: "Which film won best picture for 2002?", choices: ["Chicago", "Gangs of New York", "The Pianist","The Hours"], correctAnswer: 0},
                     {question: "Which film won best picture for 2003?", choices: ["Lord of the Rings: Return of the King", "Lost in Translation", "Mystic River","Seabiscuit"], correctAnswer: 0},
                     {question: "Which film won best picture for 2004?", choices: ["Ray", "The Aviator", "Finding Neverland","Million Dollar Baby"], correctAnswer: 3},
                     {question: "Which film won best picture for 2005?", choices: ["Brokeback Mountain", "Crash", "Capote","Munich"], correctAnswer: 1},
                     {question: "Which film won best picture for 2006?", choices: ["Babel", "Letters from Iwo Jima", "The Departed","Little Miss Sunshine"], correctAnswer: 2},
                     {question: "Which film won best picture for 2007?", choices: ["No Country for Old Men", "There Will Be Blood", "Juno","Michael Clayton"], correctAnswer: 0},
                     {question: "Which film won best picture for 2008?", choices: ["Milk", "Slumdog Millionaire", "Frost/Nixon","The Curious Case of Benjamin Button"], correctAnswer: 1},
                     {question: "Which film won best picture for 2009?", choices: ["Up in the Air", "The Hurt Locker", "The Blind Side","Precious"], correctAnswer: 1},
                     {question: "Which film won best picture for 2010?", choices: ["Black Swan", "True Grit", "The King's Speech","The Social Network"], correctAnswer: 2},
                     {question: "Which film won best picture for 2011?", choices: ["Extremely Loud and Incredibly Close", "War Horse", "The Artist","Hugo"], correctAnswer: 2},
                     {question: "Which film won best picture for 2012?", choices: ["Argo", "Lincoln", "Zero Dark Thirty","Amour"], correctAnswer: 0}
                     ];

    var current_index = 0;
    var num_correct = 0;
    var correct_answer;
    
    var $question_body = $("#question_body");
    var $question_number = $("#question_number");
    var $question_text = $("#question_text");
    var $results = $("#results");
    var $results_text = $("#results_text");
    var $next_question = $("#next_question");
    var $question1 = $("#question1");
    var $question2 = $("#question2");
    var $question3 = $("#question3");
    var $question4 = $("#question4");
    var $radios = $("input:radio[name=question]");
    var $submit_guess = $("#submit_guess");
    
    var finishQuiz = function() {
        $question_body.hide();
        $results_text.text("You got " + num_correct + " / " + questions.length + " correct.");
        $results.fadeIn();
    };
    
    var renderQuestion = function() {
        if (current_index >= questions.length) {
            finishQuiz();
            return;
        }
        
        var question_number = current_index + 1;
        var current_question = questions[current_index];
        
        $question_body.hide();
        $question_number.text("Question " + question_number);
        $question_text.text(current_question.question);
        $question1.text(current_question.choices[0]);
        $question2.text(current_question.choices[1]);
        $question3.text(current_question.choices[2]);
        $question4.text(current_question.choices[3]);
        $submit_guess.show();
        $question_body.show();
        
        correct_answer = current_question.correctAnswer + 1; //Switching from 0-based index to 1-based
        
    };
    
    var nextQuestion = function() {
        $next_question.hide();
        current_index++;
        $radios.each(function(i) {
           this.checked = false; 
        });
        $("#questions span").removeClass("correct").removeClass("incorrect");
        renderQuestion();
    }
    
    var checkGuess = function() {
        var this_guess = $("input:radio[name=question]:checked").val();
        if (typeof this_guess === 'undefined') {
            alert("You must choose a value!");
            return;
        }
        
        $submit_guess.hide();
        
        if (this_guess == correct_answer) {
            num_correct++;
            $("#question" + correct_answer).addClass("correct");
        } else {
            $("#question" + correct_answer).addClass("correct");
            $("#question" + this_guess).addClass("incorrect");
        }
      
        $next_question.show();  
    };
    
    var resetQuiz = function() {
        current_index = 0;
        num_correct = 0;
        $results.hide();
        renderQuestion();
    }
    
    $submit_guess.on("click",checkGuess);
    $next_question.on("click",nextQuestion);
    $("#question_form").on("submit",function(e) {
       e.preventDefault(); 
    });
    $("#play_again").on("click",resetQuiz);
    
    renderQuestion();
    
});
