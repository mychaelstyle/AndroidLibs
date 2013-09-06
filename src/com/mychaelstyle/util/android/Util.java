package com.mychaelstyle.util.android;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;

/**
 * Android Utility methods
 * @author masanori nakashima
 */
public class Util {
	/**
	 * is active
	 * @param context
	 * @param cls
	 * @return
	 */
	public static boolean isServiceRunning(Context context, Class<?> cls) {
	    ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
	    List<RunningServiceInfo> runningService = manager.getRunningServices(Integer.MAX_VALUE);
	    for (RunningServiceInfo info : runningService) {
	        if (cls.getName().equals(info.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}
}
