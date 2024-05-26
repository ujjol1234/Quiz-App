package com.example.quizapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import kotlinx.coroutines.launch

@Composable
fun Quizscreen() {
    val scaffoldstate: ScaffoldState = rememberScaffoldState()
    val imageLoadingError = remember { mutableStateOf(false) }
    val vm: QuizViewModel = viewModel()
    val (selectedOption, setSelectedOption) = remember { mutableStateOf<String?>(null) }
    Scaffold (topBar = {TopAppBar {
        Text(text = "QUIZ APP", color = Color.White)
    }},scaffoldState = scaffoldstate){
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)) {
            val Question: MutableState<String> = mutableStateOf(vm.current_q.value.question)
            Text(text = "Question ${vm.progress_bar.value}/10",Modifier.padding(8.dp),style = TextStyle(fontWeight = FontWeight.Bold),fontSize = 20.sp)
            Text(text = Question.value, Modifier.padding(8.dp), fontSize = 25.sp,style = TextStyle(fontWeight = FontWeight.Bold))
            Column {
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(vm.current_q.value.image)
                        .build(),
                    onSuccess = {
                        imageLoadingError.value = false
                    },
                    onError = {
                        imageLoadingError.value = true
                    }
                )
                if (imageLoadingError.value) {
                    Text(
                        text = "Image failed to load.Please check your internet connection",
                        modifier = Modifier.padding(36.dp),
                        textAlign = TextAlign.Center
                    )
                } else {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.padding(36.dp).size(250.dp),
                        contentScale = ContentScale.Crop,

                        )
                }
            }

            vm.current_q.value.options.forEach {
                Row(Modifier.padding(8.dp)) {
                    RadioButton(
                        selected = selectedOption == it,
                        onClick = {
                            setSelectedOption(it)
                            if (it == vm.current_q.value.Answer) {
                                vm.correct()
                            } else {
                                vm.Incorrect()
                            }
                        },
                        colors = RadioButtonDefaults.colors(selectedColor = androidx.compose.ui.graphics.Color.Blue)
                    )
                    Text(text = it, Modifier.padding(vertical = 15.dp),style = TextStyle(fontWeight = FontWeight.Bold))
                }
            }
            Text(text = "Result:  ${vm.Result.value}")
            Spacer(modifier = Modifier.size(10.dp))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Button(onClick = { vm.Prev_Screen() }, Modifier.padding(4.dp)) {
                    Text(text = "PREVIOUS")
                }
                Button(onClick = { vm.Next_Screen() }, Modifier.padding(4.dp)) {
                    Text(text = "NEXT")
                }
            }
        }
    }
}