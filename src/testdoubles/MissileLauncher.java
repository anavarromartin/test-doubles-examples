package testdoubles;

class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code) {
        try {
            missile.launch();
        } catch (Exception e) {}
    }

}


