package testdouble;

import org.junit.Before;
import org.junit.Test;

import static testdouble.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    private LaunchCode expiredLaunchCode = new ExpiredLaunchCode();

    @Before
    public void setUp() {

    }

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