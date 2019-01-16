package testdoubles;

import org.junit.Test;

import static testdoubles.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {
        launchMissile(new DummyMissile(), expiredLaunchCode);
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