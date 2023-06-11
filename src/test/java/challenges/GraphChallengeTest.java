package challenges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphChallengeTest {

    @Test
    void findNetworkEndpointSimpleTest() {
        int[] fromIds = {1,7,3,4,2,6,9};
        int[] toIds = {3,3,4,6,6,9,5};
        assertEquals(5, GraphChallenge.findNetworkEndpoint(3, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworkEndpoint(1, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworkEndpoint(7, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworkEndpoint(6, fromIds, toIds));
    }

    @Test
    void findNetworkEndpointLoopTest() {
        int[] fromIds = {1,7,3,4,2,6,9,5};
        int[] toIds = {3,3,4,6,6,9,5,1};
        assertEquals(1, GraphChallenge.findNetworkEndpoint(3, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworkEndpoint(1, fromIds, toIds));
        assertEquals(1, GraphChallenge.findNetworkEndpoint(7, fromIds, toIds));
        assertEquals(4, GraphChallenge.findNetworkEndpoint(6, fromIds, toIds));
    }

    @Test
    void findNetworkEndpointPrimitivesSimpleTest() {
        int[] fromIds = {1,7,3,4,2,6,9};
        int[] toIds = {3,3,4,6,6,9,5};
        assertEquals(5, GraphChallenge.findNetworLastNodePrimitives(3, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworLastNodePrimitives(1, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworLastNodePrimitives(7, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworLastNodePrimitives(6, fromIds, toIds));
    }

    @Test
    void findNetworkEndpointPrimitivesLoopTest() {
        int[] fromIds = {1,7,3,4,2,6,9,5};
        int[] toIds = {3,3,4,6,6,9,5,1};
        assertEquals(1, GraphChallenge.findNetworLastNodePrimitives(3, fromIds, toIds));
        assertEquals(5, GraphChallenge.findNetworLastNodePrimitives(1, fromIds, toIds));
        assertEquals(1, GraphChallenge.findNetworLastNodePrimitives(7, fromIds, toIds));
        assertEquals(4, GraphChallenge.findNetworLastNodePrimitives(6, fromIds, toIds));
    }

    @Test
    void findNodeIdIndexTest() {
        int[] fromIds = {1,7,3,4,2,6,9,5};
        assertEquals(0, GraphChallenge.findNodeIdIndex(1, fromIds));
        assertEquals(1, GraphChallenge.findNodeIdIndex(7, fromIds));
        assertEquals(2, GraphChallenge.findNodeIdIndex(3, fromIds));
        assertEquals(3, GraphChallenge.findNodeIdIndex(4, fromIds));
        assertEquals(4, GraphChallenge.findNodeIdIndex(2, fromIds));
        assertEquals(5, GraphChallenge.findNodeIdIndex(6, fromIds));
        assertEquals(6, GraphChallenge.findNodeIdIndex(9, fromIds));
        assertEquals(-1, GraphChallenge.findNodeIdIndex(8, fromIds));
        assertEquals(7, GraphChallenge.findNodeIdIndex(5, fromIds));
    }

    @Test
    void containsInNodeArray() {
        int[] fromIds = {1,7,3,4,2,6,9,5};
        assertTrue(GraphChallenge.containsInNodeArray(1, fromIds));
        assertFalse(GraphChallenge.containsInNodeArray(8, fromIds));
    }
}