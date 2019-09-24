package testdouble.stubs;

import testdouble.LaunchCode;

public class ValidLaunchCode extends LaunchCode {

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean isUnsigned() {
        return false;
    }
}
