package testdoubles;

import org.junit.Test;
import testdoubles.MissileLauncher.LaunchCode;
import testdoubles.MissileLauncher.Missile;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static testdoubles.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {
        MissileSpy missileSpy = new MissileSpy();
        launchMissile(missileSpy, expiredLaunchCode);

        assertFalse(missileSpy.launchWasCalled());
        assertTrue(missileSpy.disableWasCalled());

    }

    class MissileSpy implements Missile {

        private boolean launchWasCalled = false;
        private boolean disableWasCalled = false;

        @Override
        public void launch() {
            launchWasCalled = true;
        }

        @Override
        public void disable() {
            disableWasCalled = true;
        }

        boolean launchWasCalled() {
            return launchWasCalled;
        }

        boolean disableWasCalled() {
            return disableWasCalled;
        }
    }

    class DummyMissile implements Missile {

        @Override
        public void launch() {
            throw new RuntimeException();
        }

        @Override
        public void disable() {

        }
    }

    class ExpiredLaunchCode implements LaunchCode {
        @Override
        public boolean isExpired() {
            return true;
        }
    }

}