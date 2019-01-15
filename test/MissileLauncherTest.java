import org.junit.Test;

import static org.junit.Assert.*;

public class MissileLauncherTest {

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {

    }

    class DummyMissile implements MissileLauncher.Missile {

        @Override
        public void launch() {
            throw new RuntimeException();
        }
    }

    class ExpiredLaunchCode implements MissileLauncher.LaunchCode {
        @Override
        public boolean isExpired() {
            return true;
        }
    }

}