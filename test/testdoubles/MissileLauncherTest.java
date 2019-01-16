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

    private UsedLaunchCodes usedLaunchCodes;

    @Mock
    private Missile missileSpy;

    @Before
    public void setUp() {
        usedLaunchCodes = new FakeUsedLaunchCodes();
    }

    @Test
    public void givenExpiredLaunchCodes_codeRedAbort() {
        LaunchCode expiredLaunchCode = mock(LaunchCode.class);
        when(expiredLaunchCode.isExpired()).thenReturn(true);

        launchMissile(missileSpy, expiredLaunchCode, usedLaunchCodes);

        verifyCodeRedAbort();
    }

    @Test
    public void givenUnsignedLaunchCodes_codeRedAbort() {
        LaunchCode unsignedLaunchCode = mock(LaunchCode.class);
        when(unsignedLaunchCode.isUnsigned()).thenReturn(true);

        launchMissile(missileSpy, unsignedLaunchCode, usedLaunchCodes);

        verifyCodeRedAbort();
    }

    @Test
    public void givenValidLaunchCodes_missileIsLaunched() {
        LaunchCode validLaunchCode = getValidLaunchCode();

        launchMissile(missileSpy, validLaunchCode, usedLaunchCodes);

        verify(missileSpy).launch();
    }

    @Test
    public void givenReusedLaunchCodes_codeRedAbort() {
        LaunchCode validLaunchCode = getValidLaunchCode();
        Missile missile = mock(Missile.class);

        launchMissile(missile, validLaunchCode, usedLaunchCodes);
        launchMissile(missileSpy, validLaunchCode, usedLaunchCodes);

        verifyCodeRedAbort();
    }

    private LaunchCode getValidLaunchCode() {
        LaunchCode validLaunchCode = mock(LaunchCode.class);
        when(validLaunchCode.isExpired()).thenReturn(false);
        when(validLaunchCode.isUnsigned()).thenReturn(false);
        return validLaunchCode;
    }

    private void verifyCodeRedAbort() {
        verify(missileSpy, times(0)).launch();
        verify(missileSpy).disable();
    }
}