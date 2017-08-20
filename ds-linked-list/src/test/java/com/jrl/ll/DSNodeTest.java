package com.jrl.ll;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DSNodeTest {

    private static DSNode listNodes;
    private static DSNode stackNodes;

    @BeforeClass
    public static void createListOfNodes(){

        listNodes = new DSNode("1");
        listNodes.addLast("2");
        listNodes.addLast("3");
        listNodes.addLast("4");
    }


    @BeforeClass
    public static void createStackOfNodes(){

        stackNodes = new DSNode("1");
        stackNodes.addFirst("2");
        stackNodes.addFirst("3");
        stackNodes.addFirst("4");
    }


    @Test
    public void testCreateNode(){
        final DSNode node = new DSNode("1");
        Assert.assertEquals("1", node.getData());
        Assert.assertNull(node.getNext());
    }

    @Test
    public void testLinkedList(){
        Assert.assertEquals("1", listNodes.getData());
        final DSNode secondNode = listNodes.getNext();

        Assert.assertEquals("2", secondNode.getData());
        final DSNode thirddNode = secondNode.getNext();

        Assert.assertEquals("3", thirddNode.getData());
        final DSNode fourthNode = thirddNode.getNext();

        Assert.assertEquals("4", fourthNode.getData());
        Assert.assertNull(fourthNode.getNext());
    }

    @Test
    public void testNodeStack(){

        Assert.assertEquals("4", stackNodes.getData());
        final DSNode secondNode = stackNodes.getNext();

        Assert.assertEquals("3", secondNode.getData());
        final DSNode thirdNode = secondNode.getNext();

        Assert.assertEquals("2", thirdNode.getData());
        final DSNode fourthNode = thirdNode.getNext();

        Assert.assertEquals("1", fourthNode.getData());
        Assert.assertNull(fourthNode.getNext());
    }

    @Test
    public void testAddAfter() throws IllegalArgumentException{

        DSNode thirdNode = stackNodes.getNext().getNext();

        stackNodes.addAfter("5", thirdNode);

        Assert.assertEquals("4", stackNodes.getData());
        final DSNode secondNode = stackNodes.getNext();

        Assert.assertEquals("3", secondNode.getData());
        thirdNode = secondNode.getNext();

        Assert.assertEquals("2", thirdNode.getData());
        final DSNode fourthNode = thirdNode.getNext();

        Assert.assertEquals("5", fourthNode.getData());
        final DSNode fifthNode = fourthNode.getNext();

        Assert.assertEquals("1", fifthNode.getData());
        Assert.assertNull(fifthNode.getNext());

    }
}
