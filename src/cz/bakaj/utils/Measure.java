package cz.bakaj.utils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created by Vojtěch Bakaj.
 */
public class Measure {

    private static long time;

    private Measure() {
        //private constructor
    }

    public static void start() {
        time = getCpuTime();
    }

    public static double stop() {
        return (getCpuTime() - time) * 0.000000001;
    }

    /** Get CPU time in nanoseconds. */
    private static long getCpuTime() {
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        return bean.isCurrentThreadCpuTimeSupported() ?
                bean.getCurrentThreadCpuTime() : 0L;
    }
}
