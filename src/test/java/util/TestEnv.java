package util;

public final class TestEnv {
    private TestEnv() {}
    public static boolean isCi() {
        String ci = System.getenv("CI");
        return ci != null && ci.equalsIgnoreCase("true");
    }
}
