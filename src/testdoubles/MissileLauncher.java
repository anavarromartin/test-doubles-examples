package testdoubles;

class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code) {
        if (code.isExpired() || code.isUnsigned()) {
            missile.disable();
        } else {
            missile.launch();
        }
    }

}


