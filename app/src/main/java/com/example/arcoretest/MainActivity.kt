package com.example.arcoretest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.arcoretest.ui.theme.ARcoreTestTheme
import com.google.ar.core.Frame
import io.github.sceneview.ar.ARScene
import io.github.sceneview.math.Position
import io.github.sceneview.math.Scale
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNodes

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
    val context = LocalContext.current
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)
    var frame by remember { mutableStateOf<Frame?>(null) }
    val childNodes = rememberNodes()
//    ARScene(
//        modifier = Modifier.fillMaxSize(),
//        engine = engine,
//        modelLoader = modelLoader,
//        onSessionUpdated = { session, updatedFrame ->
//            frame = updatedFrame
//        },
//        onGestureListener = rememberOnGestureListener(
//            onSingleTapConfirmed = { motionEvent, node ->
//                val hitResults = frame?.hitTest(motionEvent.x, motionEvent.y)
//                val anchor = hitResults?.firstOrNull {
//                    it.isValid(depthPoint = false, point = false)
//                }?.createAnchorOrNull()
//
//                if (anchor != null) {
//                    val anchorNode = AnchorNode(engine = engine, anchor = anchor)
//                    anchorNode.addChildNode(
//                        ModelNode(modelInstance = modelLoader.createInstance(model)!!)
//                    )
//                    childNodes += anchorNode
//                }
//            }
//        )
//    )
    ARScene(
        modifier = Modifier.fillMaxSize(),
        engine = engine,
        modelLoader = modelLoader,
        childNodes = rememberNodes {
                add(ModelNode(modelLoader.createModelInstance(R.raw.cute_demon)).apply {
                    scale = Scale(0.1f)
//                    position = Position(x = it.toFloat() * -1)
                })
        },
//        environment = environmentLoader.createHDREnvironment("environment.hdr")!!
    )

}