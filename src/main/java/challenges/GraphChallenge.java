package challenges;

import java.util.List;
import java.util.stream.IntStream;

/**
 * Implement method 'findNetworkEndPoint(startNodeId, fromIds, toIds)' which should return the last
 * node id of the network found when starting from the node with id 'startNodeId' and following the links
 * of the network.
 * In case you run int a loop when traversing the network, the method should return the last node in the network
 * before it restarts.
 *
 */
public class GraphChallenge {

    private GraphChallenge() {}


    /**
     * From the given start node id return the last node id of the network.
     * O(n)
     *
     * @param startNodeId the id of starting node
     * @param fromIds the node ids indicating where to go
     * @param toIds the node ids destinations
     * @return the last node id of the network
     */
    public static int findNetworkEndpoint(int startNodeId, int[] fromIds, int[] toIds) {
        int lastNode;
        int previousNode;
        List<Integer> fromIdsList = IntStream.of(fromIds).boxed().toList();
        List<Integer> toIdsList = IntStream.of(toIds).boxed().toList();
        int startNodeIdIndex;

        if(!toIdsList.contains(startNodeId)) {
            lastNode = toIdsList.get(fromIdsList.indexOf(startNodeId));
            startNodeId = lastNode;
        } else {
            lastNode = startNodeId;
        }

        while (true) {
            startNodeIdIndex = fromIdsList.indexOf(lastNode);
            if (startNodeIdIndex == -1) {
                break;
            }

            previousNode = lastNode;
            lastNode = toIdsList.get(startNodeIdIndex);

            if(lastNode == startNodeId) {
                lastNode = previousNode;
                break;
            }
        }

        return lastNode;
    }

    /**
     * From the given start node id return the last node id of the network.
     * using only primitive types.
     * O(n)
     *
     * @param startNodeId the id of starting node
     * @param fromIds the node ids indicating where to go
     * @param toIds the node ids destinations
     * @return the last node id of the network
     */
    public static int findNetworLastNodePrimitives(int startNodeId, int[] fromIds, int[] toIds) {
        int lastNode;
        int previousNode;
        int startNodeIdIndex;

        if(containsInNodeArray(startNodeId, toIds)) {
            lastNode = toIds[findNodeIdIndex(startNodeId, fromIds)];
            startNodeId = lastNode;
        } else {
            lastNode = startNodeId;
        }

        while (true) {
            startNodeIdIndex = findNodeIdIndex(lastNode, fromIds);

            if (startNodeIdIndex == -1) {
                break;
            }

            previousNode = lastNode;
            lastNode = toIds[startNodeIdIndex];

            if(lastNode == startNodeId) {
                lastNode = previousNode;
                break;
            }
        }
        return lastNode;
    }


    /**
     * Auxiliary method to find the index of an element on the nodeId array.
     * O(n)
     *
     * @param nodeId the nodeId to search
     * @param nodeIdArray the nodeId array
     * @return the index of the nodeId or 1 if it doesn't exist.
     */
    public static int findNodeIdIndex(int nodeId, int[] nodeIdArray) {
        for(int i = 0; i < nodeIdArray.length; i++) {
            if(nodeIdArray[i] == nodeId)
                return i;
        }
        return -1;
    }

    /**
     * Auxiliary method to check if the node array contains the nodeId or not.
     * O(n)
     *
     * @param nodeId the nodeId to search
     * @param nodeIdArray the nodeId array
     * @return true if the array contains the element or false if not.
     */
    public static boolean containsInNodeArray(int nodeId, int[] nodeIdArray) {
        return findNodeIdIndex(nodeId, nodeIdArray) != -1;
    }

}
