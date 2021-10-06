package quiz

import java.io.File

class QuizController {
    val fileName="question.txt"
    val questions = arrayListOf<Question>()

    init{
        val questionAndAnswer = File(fileName).readLines()
        for(i in 0..questionAndAnswer.size-1 step 5){
            val text = questionAndAnswer[i]
            val answers = listOf<String>(questionAndAnswer[i+1],questionAndAnswer[i+2],questionAndAnswer[i+3],questionAndAnswer[i+4])
            val question = Question(text,answers)
            questions.add(question)
        }
    }
    fun doQuiz(numberOfQuestions: Int){
        randomizeQuestions()
        var helyesValasz = 0
        for(i in 0..numberOfQuestions){
            println("Question ${i+1}:")
            println(questions[i].text)
            var answers = questions[i].answers
            var helyesValaszStr =answers[0]
            answers = answers.shuffled()
            var j=0
            for (ch in 'a'..'d'){
                println("$ch. ${answers[j]}")
                j++
            }
            val ans = readLine()
            when(ans){
                "a"->if(answers[0]==helyesValaszStr) ++helyesValasz
                "b"->if(answers[1]==helyesValaszStr) ++helyesValasz
                "c"->if(answers[2]==helyesValaszStr) ++helyesValasz
                "d"->if(answers[3]==helyesValaszStr) ++helyesValasz
                else -> println("Nincs ilyen lehetoseg")
            }
        }
        println("$helyesValasz/$numberOfQuestions")
    }
    fun randomizeQuestions(){
        questions.shuffle()
    }
}