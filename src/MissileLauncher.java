class MissileLauncher {

    static void launchMissile(Missile missile, LaunchCode code) {
        missile.launch();
    }

    interface Missile {

        void launch();

    }

    interface LaunchCode {

        boolean isExpired();
    }
}


