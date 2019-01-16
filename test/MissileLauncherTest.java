import org.junit.Test;

public class MissileLauncherTest {

    @Test
    public void givenExpiredLaunchCodes_missileIsNotLaunched() {

    }

    class DummyMissile implements Missile {

        @Override
        public void launch() {
            throw new RuntimeException();
        }
    }

    class ExpiredLaunchCode implements LaunchCode {
        @Override
        public boolean isExpired() {
            return true;
        }
    }

}