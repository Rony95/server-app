package com.jrl.ll;

public final class DSNode {

    private String data;
    private DSNode next;

    public DSNode(final String value){
        this.data = value;
        this.next = null;
    }

    public DSNode(final String value, final DSNode nextNode){
        this.data = value;
        this.next = nextNode;
    }

    public void addFirst(final String value){
        final String temp = this.data;
        final DSNode tmpNext = this.next;
        this.data = value;
        this.next = new DSNode(temp, tmpNext);
    }

    private boolean doesNodeExist(final DSNode node){
        DSNode listNode = new DSNode(this.data, this.next);
        while(!listNode.equals(node)){
            listNode = listNode.next;
            if(listNode == null){
                break;
            }
        }

        return listNode != null;
    }
    public void addAfter(final String val, final DSNode node) throws IllegalArgumentException{
        // check if node exists
        if(!doesNodeExist(node)){
            throw new IllegalArgumentException("Node does not exist");
        }

        DSNode nextNode = new DSNode(val);
        DSNode tmpNode = node.next;
        node.next = nextNode;
        nextNode.next = tmpNode;
    }

    public void addLast(final String val){
        DSNode prev;
        DSNode current = this;
        while(current.next != null){
            prev = current;
            current = current.next;
        }

        prev = current;
        prev.next = new DSNode(val);
    }

    public boolean equals(final Object node){

        if(!(node instanceof DSNode))
            return false;

        DSNode dsNode = (DSNode) node;

        return this.data == dsNode.data && this.next == dsNode.next;
    }

    public String getData(){
        return this.data;
    }

    public DSNode getNext(){
        return this.next;
    }
}
