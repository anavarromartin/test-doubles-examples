package testdoubles;

public class FakeUsedLaunchCodesTest extends UsedLaunchCodesContractTest {
    @Override
    protected UsedLaunchCodes createUsedLaunchCodes() {
        return new FakeUsedLaunchCodes();
    }
}
