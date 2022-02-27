package com.example.flutter_import_module_example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant

class MainActivity: FlutterActivity() {
    private val channel = "com.startFlutterActivity"


    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine)

        MethodChannel(flutterEngine.dartExecutor, channel).setMethodCallHandler{ call, result ->
            if(call.method == "launchNewFlutter"){
                val intent = FlutterActivity
                    .withCachedEngine(ENGINE_ID)
                    .build(this)
                startActivity(intent)
            }
            else{
                result.notImplemented()
            }
        }
    }

    override fun onResume(){
        super.onResume()
        val app = application as MyApplication
    }
}
