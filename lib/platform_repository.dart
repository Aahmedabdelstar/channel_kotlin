import 'package:flutter/services.dart';

class PlatformRepository {
  static const platform = MethodChannel('flutter.native/helper');

  Future<String> changeColor(String color) async {
    try {
      final String result = await platform.invokeMethod("changeColor", {
        "color": color,
      });
      print('RESULT -> $result');
      color = result;
    } on PlatformException catch (e) {
      print(e);
    }
    return color;
  }

   printText(String title) async {
     print('RESULT2222 -> $title');
    try {
       await platform.invokeMethod("printText", {
        "text": title,
      });

    } on PlatformException catch (e) {
      print(e);
    }

  }

}