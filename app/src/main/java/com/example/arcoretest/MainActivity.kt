package com.example.arcoretest

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.arcoretest.ui.theme.ARcoreTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ARcoreTestTheme {
                ARView()
            }
        }
    }
}

//@Composable
//fun ARView() {
//    val context = LocalContext.current
//
//    AndroidView(
//        modifier = Modifier.fillMaxSize(),
//        factory = { ctx ->
//            ARSceneView(ctx).apply {
//                // 3Dモデルのノードを作成して追加
//                val modelNode = ArModelNode(ctx).apply {
//                    loadModelGlbAsync(
//                        context = context,
//                        glbFileLocation = "models/model.glb",
//                        autoAnimate = true,
//                        scaleToUnits = 1.0f
//                    ) { success ->
//                        if (success) {
//                            Toast.makeText(context, "Model loaded successfully", Toast.LENGTH_SHORT).show()
//                        } else {
//                            Toast.makeText(context, "Failed to load model", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//
//                // ノードをシーンに追加
//                scene.addChild(modelNode)
//            }
//        }
//    )
//}

@Composable
fun ARView(){
    Text(text = "Hello, ARCore!")
}