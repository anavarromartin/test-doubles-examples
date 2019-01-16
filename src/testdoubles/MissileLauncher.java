package testdoubles;

class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code, UsedLaunchCodes usedLaunchCodes) {
        if (code.isExpired() || code.isUnsigned() || usedLaunchCodes.contains(code)) {
            missile.disable();
        } else {
            missile.launch();
            usedLaunchCodes.add(code);
        }
    }

}


