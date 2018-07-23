package bigzeng.com.dailylife;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by admin on 2018/7/23.
 */

public class CustomPhoneStateListener extends PhoneStateListener {
    String tag="CustomPhoneStateListener";
    private Context mContext;

    public CustomPhoneStateListener(Context context) {
        mContext = context;
    }

    @Override
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        Log.d(tag, "CustomPhoneStateListener onServiceStateChanged: " + serviceState);
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        Log.d(tag, "CustomPhoneStateListener state: "
                + state + " incomingNumber: " + incomingNumber);
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:      // 电话挂断
                Log.d(tag, "电话挂断");
                break;
            case TelephonyManager.CALL_STATE_RINGING:   // 电话响铃
                Log.d(tag, "电话响铃");
                //HangUpTelephonyUtil.endCall(mContext);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:   // 来电接通 或者 去电，去电接通  但是没法区分
                Log.d(tag, "来电接通 或者 去电，去电接通  但是没法区分");
                break;
        }
    }
}