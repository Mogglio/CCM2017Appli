package mathieu.com.ccm2017appli;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.mathieu.api.MyInterface;

public class BroadcastService extends Service {
    public BroadcastService() {
    }

    private MyInterface.Stub mBinder = new MyInterface.Stub() {
        @Override
        public int get_sms(String smsMessageStr, String[] smsList) throws RemoteException {
            return 0;
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
