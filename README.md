# phone_caller

Flutter Android plugin usable to directly make phone calls.

The code has been tested on Samsung and Xiaomi dual sim phones.

## Usage

Import the plugin

>    import 'package:phone_caller/phone_caller.dart';

Use it by calling its static method call like this:

> await PhoneCaller.callNumber("+39011123456", sim: 1);

where sim 0 is the mail phone SIM, while sim: 1 is the secondary SIM.

If you omit the sim parameter or if the secondary sim is disabled the main sim is used.

## Thanks
Thank you to all the people that, on StackOverflow and elsewhere, have shared their knowledge about starting a call using a secondary sim on an Android phone.

 * https://stackoverflow.com/questions/25524476/make-call-using-a-specified-sim-in-a-dual-sim-device

 * https://github.com/romellfudi/VoIpUSSD
 
 * USSDController (https://www.programcreek.com/java-api-examples/?code=romellfudi%2FVoIpUSSD%2FVoIpUSSD-master%2Fussd-library%2Fsrc%2Fmain%2Fjava%2Fcom%2Fromellfudi%2Fussdlibrary%2FUSSDController.java)
    

## MIT License
Copyright (c) 2021 Stefano Falda

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the 'Software'), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
