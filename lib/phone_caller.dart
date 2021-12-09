import 'dart:async';

import 'package:flutter/services.dart';

class PhoneCaller {
  static const MethodChannel _channel = MethodChannel('phone_caller');

  /// Start a phone call to the number
  ///
  /// sim can be set as an optional parameter:
  ///
  ///     0 = SIM1
  ///
  ///     1 = SIM2
  static Future<void> callNumber(String number, {sim = 0}) async {
    await _channel.invokeMethod('call', <String, dynamic>{
      'number': number,
      'sim': sim,
    });
  }
}
