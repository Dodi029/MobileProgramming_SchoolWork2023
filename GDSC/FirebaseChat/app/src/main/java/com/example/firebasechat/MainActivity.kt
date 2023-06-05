package com.example.firebasechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firebasechat.ui.theme.FirebasechatTheme
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirebasechatTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ChatApp()


                }
            }
        }
    }
}
data class Message(val text: String, val userId: String)

@Composable
fun ChatApp() {
    val messages = remember { mutableStateListOf<Message>() }
    val newMessageText = remember { mutableStateOf("") }

    val messagesRef = FirebaseDatabase.getInstance().getReference("messages")

    val valueEventListener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            messages.clear()
            for (messageSnapshot in snapshot.children) {
                val message = messageSnapshot.getValue(Message::class.java)
                message?.let {
                    messages.add(it)
                }
            }
        }

        override fun onCancelled(error: DatabaseError) {
            // 오류 처리
        }
    }

    DisposableEffect(Unit) {
        messagesRef.addValueEventListener(valueEventListener)
        onDispose {
            messagesRef.removeEventListener(valueEventListener)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // 채팅 메시지 표시
        MessageList(messages)

        // 메시지 입력란과 전송 버튼
        MessageInput(newMessageText.value, onMessageSent = {
            val newMessageRef = messagesRef.push()
            val newMessage = Message(text = it, userId = "user1")
            newMessageRef.setValue(newMessage)
            newMessageText.value = it
        })
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            Text(message.text)
        }
    }
}

@Composable
fun MessageInput(text: String, onMessageSent: (String) -> Unit) {
    val context = LocalContext.current

    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = text,
            onValueChange = { onMessageSent(it) },
            modifier = Modifier.weight(1f),
            label = { Text("메시지 입력") }
        )
        IconButton(
            onClick = { onMessageSent(text) },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send"
            )
        }
    }
}