package executiontime;

import challenges.GraphChallenge;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ExecutionTime {

    private static final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public static void main(String[] args) {
        findNetworkEndpointExecutionTime();
        findNetworLastNodePrimitivesExecutionTime();
        customFindIndexExecutionTime();
        builtInIndexOfExecutionTime();
    }

    private static void findNetworkEndpointExecutionTime() {
        System.out.println("Find network last node with java built in functions implementations");
        int[] fromIds = {1,7,3,4,2,6,9};
        int[] toIds = {3,3,4,6,6,9,5};

        System.out.println("Execution with no loop on network");

        var startTime = threadMXBean.getCurrentThreadCpuTime();

        GraphChallenge.findNetworkEndpoint(6, fromIds, toIds);

        var endTime = threadMXBean.getCurrentThreadCpuTime();
        var cpuTime = endTime - startTime;

        printTimeExecutionValues(cpuTime);

        System.out.println("Execution with loop on network");

        fromIds = new int[]{1,7,3,4,2,6,9,5};
        toIds = new int[]{3,3,4,6,6,9,5,1};

        startTime = threadMXBean.getCurrentThreadCpuTime();

        GraphChallenge.findNetworkEndpoint(6, fromIds, toIds);

        endTime = threadMXBean.getCurrentThreadCpuTime();
        cpuTime = endTime - startTime;

        printTimeExecutionValues(cpuTime);
    }

    private static void findNetworLastNodePrimitivesExecutionTime() {
        System.out.println("Find network last node without java built in functions implementations");
        int[] fromIds = {1,7,3,4,2,6,9};
        int[] toIds = {3,3,4,6,6,9,5};

        var startTime = threadMXBean.getCurrentThreadCpuTime();

        GraphChallenge.findNetworLastNodePrimitives(6, fromIds, toIds);

        var endTime = threadMXBean.getCurrentThreadCpuTime();
        var cpuTime = endTime - startTime;

        printTimeExecutionValues(cpuTime);

        System.out.println("Execution with loop on network");

        fromIds = new int[]{1,7,3,4,2,6,9,5};
        toIds = new int[]{3,3,4,6,6,9,5,1};

        startTime = threadMXBean.getCurrentThreadCpuTime();

        GraphChallenge.findNetworLastNodePrimitives(6, fromIds, toIds);

        endTime = threadMXBean.getCurrentThreadCpuTime();
        cpuTime = endTime - startTime;

        printTimeExecutionValues(cpuTime);
    }

    private static void customFindIndexExecutionTime() {
        System.out.println("Custom get index implementation");

        int[] fromIds = {1,7,3,4,2,6,9,5};
        var startTime = threadMXBean.getCurrentThreadCpuTime();

        GraphChallenge.findNodeIdIndex(6, fromIds);

        var endTime = threadMXBean.getCurrentThreadCpuTime();
        var cpuTime = endTime - startTime;

        printTimeExecutionValues(cpuTime);
    }

    private static void builtInIndexOfExecutionTime() {
        System.out.println("Built in get index implementation");
        var idsList = IntStream.of(1,7,3,4,2,6,9,5).boxed().toList();

        var startTime = threadMXBean.getCurrentThreadCpuTime();
        idsList.indexOf(6);
        var endTime = threadMXBean.getCurrentThreadCpuTime();
        var cpuTime = endTime - startTime;

        printTimeExecutionValues(cpuTime);
    }

    private static void printTimeExecutionValues(long cpuTime) {
        System.out.println("CPU time: " + cpuTime +" nanoseconds");
        System.out.println("CPU time: " + formattedToSeconds(cpuTime));
    }

    private static String formattedToSeconds(long cpuTime) {
        double seconds = cpuTime / 1_000_000_000.0;
        DecimalFormat df = new DecimalFormat("#0.0000000");
        return df.format(seconds).concat(" seconds\n");
    }
}
