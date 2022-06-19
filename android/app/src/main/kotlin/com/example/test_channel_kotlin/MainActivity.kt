package com.example.test_channel_kotlin


import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import android.util.Log


class MainActivity: FlutterActivity() {
    private val CHANNEL = "flutter.native/helper"

    @ExperimentalStdlibApi
    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler{
            call, result ->
//            methodResult = result ;

            if (call.method == "changeColor" ){
                changeColor(call, result);
            }
            else if (call.method == "printText" ){

                    printText(call, result);

            }

        }
    }
    private fun changeColor(call: MethodCall, result: MethodChannel.Result) {
        var color = call.argument<String>("color");
        result.success(color);
    }

    private fun printText(call: MethodCall, result: MethodChannel.Result) {
//        var color = call.argument<String>("color");
//        result.success(color);
        Log.d("TAG", "your log message44");
        var title = call.argument<String>("text");
        Log.d("TAG", "your log message44 $title");
    }
}