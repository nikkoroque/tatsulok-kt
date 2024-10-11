package com.example.tatsulokpos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tatsulokpos.layout.POSLayout
import com.example.tatsulokpos.ui.theme.TatsulokPOSTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TatsulokPOSTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    POSLayout()

                }
            }
        }
    }


    @Preview(showBackground = true, widthDp = 1024, heightDp = 768)
    @Composable
    fun DefaultPreview() {
        TatsulokPOSTheme {
            POSLayout()
        }
    }
}