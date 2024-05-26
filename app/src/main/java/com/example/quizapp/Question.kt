package com.example.quizapp

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource

sealed class Question (val question:String,val image:String,val options:List<String>,val Answer:String){
    object Question1:Question("Identify the animal",
        "https://cdn.britannica.com/06/181806-131-173E2BDD/capuchin-monkey-baby.jpg",
        listOf("Monkey","Squirrel","Ape","Elephant"),"Monkey")
    object Question2:Question("Identify the location of this monument",
        "https://cdn.britannica.com/54/235954-131-FAB4D96E/Towers-of-the-Notre-Dame-de-Paris-Paris-France.jpg",
        listOf("Moscow","Delhi","Paris","Rome"),"Paris")
    object Question3:Question("Identify the Mammals",
        "https://cdn.britannica.com/97/2297-131-BDDF9F06/manatees.jpg",
        listOf("porpoise","manatee","whale","seal"),"manatee")
    object Question4:Question("Identify the artist of this painting",
        "https://cdn.britannica.com/78/43678-131-84DFF99B/Starry-Night-canvas-Vincent-van-Gogh-New-1889.jpg",
        listOf("Salvador Dali","Vincent Van Gogh","Kara Walker","James McNeill Whistler"),"Vincent Van Gogh")
    object Question5:Question("Identify this famous politician",
        "https://cdn.britannica.com/47/96747-131-ACE0ABB6/Nelson-Mandela-school-Johannesburg-South-Africa.jpg",
        listOf("Thabo Mbeki","Desmound Tutu","F.W. de Clerk","Nelson Mandela"),"Nelson Mandela")
    object Question6:Question("Which country does this flag represent",
        "https://jetpunk.b-cdn.net/img/user-photo-library/4f/4f8eea950d-450.png",
        listOf("Denmark","Sweden","Iceland","Palau"),"Iceland")
    object Question7:Question("Identify the company from the logo",
        "https://jetpunk.b-cdn.net/img/user-photo-library/fc/fcf0dd86d7-450.jpg",
        listOf("Starbucks","Keventers","CCD","Burger King"),"Starbucks")
    object Question8:Question("Identify this color",
        "https://cdn.britannica.com/73/235573-131-E7F78C6C/color-vermilion-Red-orange.jpg",
        listOf("vermilion","cyan","mauve","indigo"),"vermilion")
    object Question9:Question("Identify this famous politician",
        "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcRpQteg8Q5RDgOqht_RgfA_bprlXvLf9LCplGsjV6PGiFODVdwVyB-bO6gJvMKrJ_PO43rgBMG2JxuUMKY",
        listOf("George Washington","Fredrick Douglas","Crispus Attucks","Thomas Jefferson"),"George Washington")
    object Question10:Question("Where is this place located",
        "https://cdn.britannica.com/51/235951-131-8EEFB51F/White-churches-blue-domes-the-coastline-Santorini-Greece.jpg",
        listOf("Greece","Mexico","Sri lanka","South Africa"),"Greece")
}


val Questions = listOf(Question.Question1,
    Question.Question2,
    Question.Question3,
    Question.Question4,
    Question.Question5,
    Question.Question6,
    Question.Question7,
    Question.Question8,
    Question.Question9,
    Question.Question10)
