package testdoubles;

class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code) {
        if (code.isExpired()) {
            missile.disable();
        } else {
            missile.launch();
        }
    }

    interface Missile {
        void launch();

        void disable();
    }

    interface LaunchCode {
        boolean isExpired();
    }
}


