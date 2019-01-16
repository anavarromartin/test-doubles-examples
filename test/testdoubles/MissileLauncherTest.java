package testdoubles;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static testdoubles.MissileLauncher.launchMissile;

public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();
    final LaunchCode unsignedLaunchCode = new UnsignedLaunchCode();
    final LaunchCode validLaunchCode = new ValidLaunchCode();

    MissileSpy missileSpy;
    MissileMock missileMock;

    @Before
    public void setUp() {
        missileSpy = new MissileSpy();
        missileMock = new MissileMock();
    }

    @Test
    public void givenExpiredLaunchCodes_codeRedAbort() {
        launchMissile(missileMock, expiredLaunchCode);

        missileMock.verifyRedCodeAbort();
    }

    @Test
    public void givenUnsignedLaunchCodes_codeRedAbort() {
        launchMissile(missileMock, unsignedLaunchCode);

        missileMock.verifyRedCodeAbort();
    }

    @Test
    public void givenValidLaunchCodes_missileIsLaunched() {
        launchMissile(missileSpy, validLaunchCode);

        assertTrue(missileSpy.launchWasCalled());
    }

    class MissileMock implements Missile {
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

        public void verifyRedCodeAbort() {
            assertFalse(launchWasCalled);
            assertTrue(disableWasCalled);
        }
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

    class ExpiredLaunchCode extends LaunchCode {
        @Override
        public boolean isExpired() {
            return true;
        }
    }

    class UnsignedLaunchCode extends LaunchCode {
        @Override
        public boolean isUnsigned() {
            return true;
        }
    }

    class ValidLaunchCode extends LaunchCode {
        @Override
        public boolean isExpired() {
            return false;
        }

        @Override
        public boolean isUnsigned() {
            return false;
        }
    }
}