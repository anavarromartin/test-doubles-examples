package testdoubles;

import org.junit.Test;
import testdoubles.MissileLauncher.LaunchCode;

import static testdoubles.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {
        launchMissile(new DummyMissile(), expiredLaunchCode);
    }

    class DummyMissile implements MissileLauncher.Missile {

        @Override
        public void launch() {
            throw new RuntimeException();
        }
    }

    class ExpiredLaunchCode implements LaunchCode {
        @Override
        public boolean isExpired() {
            return true;
        }
    }

}