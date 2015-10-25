package com.germainz.stopswitchdelay;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class XposedMod implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("android"))
            return;

        findAndHookMethod("com.android.server.am.ActivityManagerService", lpparam.classLoader,
                "stopAppSwitches", XC_MethodReplacement.returnConstant(null));
    }
}
