package testdoubles;

class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code) {
        if (code.isExpired() || code.isUnsigned()) {
            missile.disable();
        } else {
            missile.launch();
        }
    }

    interface Missile {
        void launch();

        void disable();
    }

    static class LaunchCode {
        public boolean isExpired() {
            return false;
        }

        public boolean isUnsigned() {
            return false;
        }
    }
}


