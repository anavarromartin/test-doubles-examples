package testdoubles;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;
import static testdoubles.MissileLauncher.launchMissile;

@RunWith(MockitoJUnitRunner.class)
public class MissileLauncherTest {

    final LaunchCode expiredLaunchCode = new ExpiredLaunchCode();
    final LaunchCode unsignedLaunchCode = new UnsignedLaunchCode();
    final LaunchCode validLaunchCode = new ValidLaunchCode();

    private UsedLaunchCodes usedLaunchCodes;

    @Mock
    private Missile missileSpy;

    @Before
    public void setUp() {
        usedLaunchCodes = new FakeUsedLaunchCodes();
    }

    @Test
    public void givenExpiredLaunchCodes_codeRedAbort() {
        launchMissile(missileSpy, expiredLaunchCode, usedLaunchCodes);

        verifyCodeRedAbort();
    }

    @Test
    public void givenUnsignedLaunchCodes_codeRedAbort() {
        launchMissile(missileSpy, unsignedLaunchCode, usedLaunchCodes);

        verifyCodeRedAbort();
    }

    @Test
    public void givenValidLaunchCodes_missileIsLaunched() {
        launchMissile(missileSpy, validLaunchCode, usedLaunchCodes);

        verify(missileSpy).launch();
    }

    @Test
    public void givenReusedLaunchCodes_codeRedAbort() {
        Missile missile = new MissileMock();

        launchMissile(missile, validLaunchCode, usedLaunchCodes);
        launchMissile(missileSpy, validLaunchCode, usedLaunchCodes);

        verifyCodeRedAbort();
    }

    private void verifyCodeRedAbort() {
        verify(missileSpy, times(0)).launch();
        verify(missileSpy).disable();
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