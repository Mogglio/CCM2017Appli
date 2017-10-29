package mathieu.com.ccm2017appli;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Mog on 19/10/2017.
 */

public class SMSBroadcastReceiver extends BroadcastReceiver{

    private String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(SMS_RECEIVED)) {
            Toast.makeText(context, "Recieved", Toast.LENGTH_LONG).show();

            Bundle intentExtras = intent.getExtras();
            if (intentExtras != null) {
                Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
                String smsMessageStr = "";
                for (int i = 0; i < sms.length; ++i) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                    String smsBody = smsMessage.getMessageBody().toString();
                    String address = smsMessage.getOriginatingAddress();

                    smsMessageStr += "SMS From: " + address + "\n";
                    smsMessageStr += smsBody + "\n";
                    Intent monintent = new Intent("SmsMessage.intent.MAIN").putExtra("get_msg", address+":"+smsBody);
                    context.sendBroadcast(monintent);
                }
                Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
