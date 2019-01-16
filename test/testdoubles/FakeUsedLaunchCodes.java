package testdoubles;

public class FakeUsedLaunchCodes implements UsedLaunchCodes {
    @Override
    public boolean contains(LaunchCode launchCode) {
        return false;
    }

    @Override
    public void add(LaunchCode launchCode) {

    }
}
