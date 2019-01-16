package testdoubles;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class UsedLaunchCodesContractTest {
    private UsedLaunchCodes usedLaunchCodes;
    protected abstract UsedLaunchCodes createUsedLaunchCodes();

    @Before
    public void setUp() throws Exception {
        usedLaunchCodes = createUsedLaunchCodes();
    }


    @Test
    public void contains() {
        LaunchCode launchCode = new LaunchCode();

        assertFalse(usedLaunchCodes.contains(launchCode));

        usedLaunchCodes.add(launchCode);

        assertTrue(usedLaunchCodes.contains(launchCode));
    }
}