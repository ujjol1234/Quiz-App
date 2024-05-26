package com.example.quizapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class QuizViewModel:ViewModel(){

    val index :MutableState<Int> = mutableStateOf(0)
    val current_q:MutableState<Question> = mutableStateOf(Questions[index.value])
    val Result:MutableState<String> = mutableStateOf("")
    val progress_bar :MutableState<Int> = mutableStateOf(1)

    fun Next_Screen(){
        if(index.value<9) {
            index.value = index.value + 1
            current_q.value = Questions[index.value]
            progress_bar.value=progress_bar.value+1
            Result.value=""
        }
    }

    fun Prev_Screen(){
        if(index.value>0){
            index.value = index.value - 1
            current_q.value = Questions[index.value]
            progress_bar.value=progress_bar.value-1
            Result.value=""
        }
    }
    fun correct(){
        Result.value = "CORRECT"
    }
    fun Incorrect(){
        Result.value = "INCORRECT"
    }

}