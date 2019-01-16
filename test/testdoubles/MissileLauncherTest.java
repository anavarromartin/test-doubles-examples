package testdoubles;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static testdoubles.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {
        MissileSpy missileSpy = new MissileSpy();
        launchMissile(missileSpy, expiredLaunchCode);

        assertFalse(missileSpy.launchWasCalled());

    }

    class MissileSpy implements Missile {

        private boolean launchWasCalled = false;

        @Override
        public void launch() {
            launchWasCalled = true;
        }

        boolean launchWasCalled() {
            return launchWasCalled;
        }
    }

    class DummyMissile implements Missile {

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