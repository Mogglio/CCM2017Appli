package mathieu.com.ccm2017appli;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Mog on 20/10/2017.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("startuptest", "StartUpBootReceiver " + intent.getAction());

        Intent myIntent = new Intent(context, SMSBroadcastReceiver.class);
        context.startService(myIntent);
    }
}
