package testdoubles;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsedLaunchCodesTest {

    private LaunchCode launchCode = new LaunchCode();

    @Test
    public void contains() {
        UsedLaunchCodes usedLaunchCodes = new FakeUsedLaunchCodes();

        assertFalse(usedLaunchCodes.contains(launchCode));

        usedLaunchCodes.add(launchCode);

        assertTrue(usedLaunchCodes.contains(launchCode));
    }
}