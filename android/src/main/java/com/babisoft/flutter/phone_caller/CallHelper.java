package com.babisoft.flutter.phone_caller;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import java.util.List;

import android.content.Context;

public class CallHelper {
    // Code taken from
    // https://github.com/romellfudi/VoIpUSSD --> USSDController (https://www.programcreek.com/java-api-examples/?code=romellfudi%2FVoIpUSSD%2FVoIpUSSD-master%2Fussd-library%2Fsrc%2Fmain%2Fjava%2Fcom%2Fromellfudi%2Fussdlibrary%2FUSSDController.java)
    // https://stackoverflow.com/questions/25524476/make-call-using-a-specified-sim-in-a-dual-sim-device
    private final static String simSlotName[] = {
            "extra_asus_dial_use_dualsim",
            "com.android.phone.extra.slot",
            "slot",
            "simslot",
            "sim_slot",
            "subscription",
            "Subscription",
            "phone",
            "com.android.phone.DialingMode",
            "simSlot",
            "slot_id",
            "simId",
            "simnum",
            "phone_type",
            "slotId",
            "slotIdx"
    };

    static final String[] perms = {"android.permission.CALL_PHONE", "android.permission.READ_PHONE_STATE"};

    static final int permsRequestCode = 200;



    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void callNumber(android.app.Activity activity, String number, int simSlotIndex) {
        try {
            final Context context = activity.getBaseContext();
            // Verifica se ci sono i permessi per gestire le chiamate
            if (context.checkSelfPermission(perms[0])!= PackageManager.PERMISSION_GRANTED ||
                    context.checkSelfPermission(perms[1])!= PackageManager.PERMISSION_GRANTED){
                // Request permissions...
                ActivityCompat.requestPermissions(activity, perms, permsRequestCode);
            }


            final Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
            intent.putExtra("com.android.phone.force.slot", true);
            intent.putExtra("Cdma_Supp", true);
            for (String s : simSlotName)
                intent.putExtra(s, simSlotIndex);
            //works only for API >= 21
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
                if (telecomManager != null) {
                    List<PhoneAccountHandle> phoneAccountHandleList = telecomManager.getCallCapablePhoneAccounts();
                    if (phoneAccountHandleList != null && phoneAccountHandleList.size() > simSlotIndex)
                        intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandleList.get(simSlotIndex));
                }
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
