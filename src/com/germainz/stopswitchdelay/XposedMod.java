package com.germainz.stopswitchdelay;

import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XC_MethodReplacement;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class XposedMod implements IXposedHookZygoteInit {

    @Override
    public void initZygote(StartupParam startupParam) throws Throwable {
        findAndHookMethod("com.android.server.am.ActivityManagerService", null, "stopAppSwitches",
                XC_MethodReplacement.returnConstant(null));
    }

}
