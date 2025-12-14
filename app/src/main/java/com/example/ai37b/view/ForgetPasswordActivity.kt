package com.example.ai37b.view

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ai37b.repository.UserRepoImpl
import com.example.ai37b.ui.theme.Blue
import com.example.ai37b.ui.theme.PurpleGrey80
import com.example.ai37b.viewmodel.UserViewModel

class ForgetPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForgetPasswordBody()
        }
    }
}

@Composable
fun ForgetPasswordBody() {
    var email by remember { mutableStateOf("") }

    var userViewModel = remember { UserViewModel(UserRepoImpl()) }

    val context = LocalContext.current
    val activity = context as? Activity

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {


                Spacer(modifier = Modifier.height(50.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { data ->
                        email = data
                    },
                    shape = RoundedCornerShape(15.dp),
                    placeholder = {
                        Text("abc@gmail.com")
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 15.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = PurpleGrey80,
                        unfocusedContainerColor = PurpleGrey80,
                        focusedIndicatorColor = Blue,
                        unfocusedIndicatorColor = Color.Transparent
                    )

                )

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        userViewModel.forgetPassword(email){
                            success,message->
                            if (success){
                                Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
                                activity?.finish()
                            }else{
                                Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
                            }
                        }

                    },
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 15.dp),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text("Send Reset lin")
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgetPasswordBodyPreview() {
    ForgetPasswordBody()
}