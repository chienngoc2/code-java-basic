/*
 void insert(String xSource, int xPrice, int xType) {
        if (xSource.charAt(0) == 'B') {
            return;
        }
        Node x = new Node(new Watermelon(xSource, xPrice, xType));
        if (root == null) {
            root = x;
            return;
        }
        Node p = root;
        Node f = null;
        while (p != null) {
            if (x.info.price == p.info.price) {
                System.out.println("The key" + x.info.price + "already exits");
                return;
            }
            f = p;
            if (p.info.price > x.info.price) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.info.price < f.info.price) {
            f.left = x;
        } else {
            f.right = x;
        }

    }

----------------------------------------------------------------------------------
void postOrder2(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        postOrder2(p.left, f);
        postOrder2(p.right, f);
        if (p.info.type < 4) {
            fvisit(p, f);
        }
    }
------------------------------------------------------------------------------------
void getPreOrderList(Node p, List<Node> list) {
        if (p == null) {
            return;
        }
        list.add(p);
        getPreOrderList(p.left, list);
        getPreOrderList(p.right, list);
    }

    Node deleteNode(Node root, int num) {
        if (root == null) {
            return null;
        }
        // tim node de xoa
        if (num < root.info.price) {
            root.left = deleteNode(root.left, num);
        } else if (num > root.info.price) {
            root.right = deleteNode(root.right, num);
        } else {
            // 
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //
            Node predes = findMaxLeft(root.left);
            root.info = predes.info;
            root.left = deleteNode(root.left, predes.info.price);
        }
        return root;
    }

    Node findMaxLeft(Node p) {
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

     List<Node> preOrderNode = new ArrayList();
        getPreOrderList(root, preOrderNode);
        if (preOrderNode.size() >= 3) {
            Node nodeToDelete = preOrderNode.get(2);
            root = deleteNode(root, nodeToDelete.info.price);
        }
----------------------------------------------------------------
la tan cung ben phai
Node p = root;
        if (p == null) {
            return;
        } else {
            while (p.right != null) {
                p = p.right;
            }
        }  
        fvisit(p, f);
---------------------------------------------------------------
tim la
public void findLeaf(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.right == null && p.left == null) {
            fvisit(p, f);
        }
        findLeaf(p.left, f);
        findLeaf(p.right, f);

    }
--------------------------------------------------------------
public void internalLeaf(Node p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.left != null || p.right != null) {
           fvisit(p, f);
        }
        internalLeaf(p.left, f);
        internalLeaf(p.right, f);
----------------------------------------------------------------
int getHeight(Node p) {
        if (p == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(p.left), getHeight(p.right));
    }
----------------------------------------------------------------
tim nut la, cong type voi chieu cao cua cay
 void updateLeaf(Node p, int height, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        if (p.left == null && p.right == null) {
            p.info.type += height;
            fvisit(p, f);
        }
        updateLeaf(p.left, height, f);
        updateLeaf(p.right, height, f);
    }
        
        int height = getHeight(root);
        updateLeaf(root, height, f);
----------------------------------------------------------------
void rotateRight(Node p) throws Exception {
        if (p == null || p.left == null) {
            return; 
        }

        Node moveNode = new Node(p.info); // 

        
        moveNode.right = p.right; 
        moveNode.left = p.left.right; 

        
        p.info = p.left.info;
        p.right = moveNode;
        p.left = p.left.left;
    }
List<Node> preOrderNode = new ArrayList();
        getPreOrderList(root, preOrderNode);
        if (preOrderNode.size() >= 3) {
            Node n = preOrderNode.get(2);
            if (n.left != null) { 
                rotateRight(n);  
            }
        }
void getPreOrderList(Node p, List<Node> list) {
        if (p == null) {
            return;
        }
        list.add(p);
        getPreOrderList(p.left, list);
        getPreOrderList(p.right, list);
    }
--------------------------------------------------------
Node findMaxType(Node p) {
        if (p == null) {
            return null;
        }
        Node tleft = findMaxType(p.left);
        Node tright = findMaxType(p.right);

        Node tmax = p;
        if (tleft != null && tleft.info.type > tmax.info.type) {
            tmax = tleft;
        }
        if (tright != null && tright.info.type > tmax.info.type) {
            tmax = tright;
        }
        return tmax;
    }
----------------------------------------------------------------
void insert(String title, int copies, int price) {
        Node newNode = new Node(new Book(title, copies, price));

        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = null;
        Node current = root;

        while (current != null) {
            if (current.info.getTitle().equals(title)) {
                
                current.info.setCopies(current.info.getCopies() + copies);
                return;
            }

            parent = current;
            if (title.compareTo(current.info.getTitle()) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        
        if (title.compareTo(parent.info.getTitle()) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }
----------------------------------------------------------------------------------
 void enQueue(String title, int copies) {
        // Implement this function - add a book borrow request to queue
        // --------------------------------------------------------
        QueueNode newNode = new QueueNode(new Book(title, copies));
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        // --------------------------------------------------------
    }
------------------------------------------------------------------------------------
boolean borrowBook(Book request) {
        // Search for the book in the catalog
        Node node = bookCatalog.search(bookCatalog.root, request.getTitle());

        // If book found and has enough copies, process the borrow
        if (node != null && node.info.getCopies() >= request.getCopies()) {
            node.info.setCopies(node.info.getCopies() - request.getCopies());
            return true;
        }
        return false;
    }
----------------------------------------------------------------------------------------
 while (!borrowRequests.isEmpty()) {
            Book r = borrowRequests.deQueue();
            borrowBook(r);
        }
-----------------------------------------------------------------------------------------
double totalValue = 0.0; 

        while (!borrowRequests.isEmpty()) {
            Book request = borrowRequests.deQueue();
            if (request != null) {
                Node node = bookCatalog.search(bookCatalog.root, request.getTitle());
                if (node != null && node.info.getCopies() >= request.getCopies()) {
                    node.info.setCopies(node.info.getCopies() - request.getCopies());

             
                    totalValue += request.getCopies() * (double) node.info.getPrice();
                }
            }
        }
*/