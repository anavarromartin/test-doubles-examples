package testdoubles;

class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code) {
        try {
            missile.launch();
        } catch (Exception e) {}
    }

    interface Missile {
        void launch();
    }

    interface LaunchCode {
        boolean isExpired();
    }
}


