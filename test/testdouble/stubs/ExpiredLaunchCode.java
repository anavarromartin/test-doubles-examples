package testdouble.stubs;

public class ExpiredLaunchCode extends ValidLaunchCode {
    @Override
    public boolean isExpired() {
        return true;
    }
}
