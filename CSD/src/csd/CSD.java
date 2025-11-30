/*
    link List 
 void addLast(String xSource, int xPrice, int xType) {
        //You should write here appropriate statements to complete this function.
        if (xSource.charAt(0) == 'D') {
            return;
        }
        Node q = new Node(new Watermelon(xSource, xPrice, xType));
        if (this.isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
void insert(Node x, int k) {
        if (this.isEmpty()) {
            head = tail = x;
            return;
        }
        if (k < 1) {
            return;
        }
        if (k == 1) {
            x.next = head;
            head = x;
            return;
        }
        int count = 1;
        Node p = head;
        while (p != null && count < k - 1) {
            p = p.next;
            count++;
        }
        if (p == null) {
            return;
        }
        x.next = p.next;
        p.next = x;

    }
      Node y = new Node(h);
      insert(y, 2);
 void deleteLastNode() {
        if (this.isEmpty()) {
            head = tail = null;
            return;
        }

        if (head == tail) {
            head = null;
            return;
        }
        Node p = head;

        while (p.next != tail) {
            p = p.next;

        }
        p.next = null;
        tail = p;
    }
void deleteNode(int k) {
        if (this.isEmpty() || k < 1) {
            head = tail = null;
            return;
        }

        if (k == 1) {
            head = head.next;
            return;
        }
        int count = 1;
        Node p = head;
        while (count < k - 1 && p != null && p.next != null) {
            p = p.next;
            count++;
        }
        if (p == null && p.next == null) {
            return;
        }
        p.next = p.next.next;

    }
     // Exit if < 4 element
    if (head == null || head.next == null || head.next.next == null || head.next.next.next == null) {
        f.close();
        return;
    }

    // lay 4 phan tu de xap xep
    Node[] arr = new Node[4];
    Node current = head;
    for (int i = 0; i < 4; i++) {
        arr[i] = current;
        current = current.next;
    }

    // 
    for (int i = 0; i < 4 - 1; i++) {
        for (int j = 0; j < 4 - i - 1; j++) {
            if (arr[j].info.type > arr[j + 1].info.type) {
                // hoan doi gia tri cua cac node
                Watermelon temp = arr[j].info;
                arr[j].info = arr[j + 1].info;
                arr[j + 1].info = temp;
            }
        }
    }
-------------------------------------------------------------------------
 // tim node t3 va t6 va cac node truoc chung de swap
        Node prevThird = null, thirdNode = head;
        Node prevSixth = null, sixthNode = head;

        // node 3
        for (int i = 1; i < 3; i++) { 
            prevThird = thirdNode;
            thirdNode = thirdNode.next;
        }

        // node 6
        for (int i = 1; i < 6; i++) { 
            prevSixth = sixthNode;
            sixthNode = sixthNode.next;
        }

        // hoan doi
        if (thirdNode == null || sixthNode == null) {
            return; 
        }

        if (prevThird != null) {
            prevThird.next = sixthNode; 
        } 

        if (prevSixth != null) {
            prevSixth.next = thirdNode; 
        } 

        
        Node temp = thirdNode.next;
        thirdNode.next = sixthNode.next;
        sixthNode.next = temp;

*/
