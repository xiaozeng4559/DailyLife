package bigzeng.com.dailylife.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by admin on 2018/7/23.
 */

public class PhoneStateReceiver extends BroadcastReceiver {
    String tag="PhoneStateReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.d(tag, "PhoneStateReceiver action: 1=" + action);

        String resultData = this.getResultData();
        Log.d(tag, "PhoneStateReceiver getResultData: 2=" + resultData);

        if (action.equals(Intent.ACTION_NEW_OUTGOING_CALL)) {
            // 去电，可以用定时挂断
            // 双卡的手机可能不走这个Action
            String phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.d(tag, "PhoneStateReceiver EXTRA_PHONE_NUMBER: 3=" + phoneNumber);
        } else {
            // 来电去电都会走
            // 获取当前电话状态
            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
            Log.d(tag, "PhoneStateReceiver onReceive state: 4=" + state);

            // 获取电话号码
            String extraIncomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Log.d(tag, "PhoneStateReceiver onReceive extraIncomingNumber: 5=" + extraIncomingNumber);

            if (state.equalsIgnoreCase(TelephonyManager.EXTRA_STATE_RINGING)) {
                Log.d(tag, "PhoneStateReceiver onReceive endCall6=");
            }
        }
    }
}
