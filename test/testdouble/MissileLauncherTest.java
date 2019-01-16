package testdouble;

import org.junit.Test;

import static testdouble.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {

    }

    class ExpiredLaunchCode extends LaunchCode {
        @Override
        boolean isExpired() {
            return true;
        }
    }
}