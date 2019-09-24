package testdoubles;

import org.junit.Test;

import static testdoubles.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {
        launchMissile(new DummyMissile(), expiredLaunchCode);
    }

    class DummyMissile implements Missile {

        @Override
        public void launch() {
            throw new RuntimeException();
        }
    }

}