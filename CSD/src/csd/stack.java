/*
class Stack {
    Node top;

    Stack() {
        top = null;
    }

    void push(String code, int status, int size, int price) {
        (size > 0 && price > 0)
        if (size <= 0 || price <= 0) {
            return;
        }
        Node newNode = new Node(new Room(code, status, size, price));
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    Room pop() {
        if (top == null) {
            return null; // 
        }
        Room tmp = top.info;
        top = top.next; // 
        return tmp;
    }
}
------------------------------------------------------------------------------------
void sort() {


    Node current = top, index = null;
    while (current != null) {
        Node minNode = current;
        index = current.next;

        while (index != null) {
            if (index.info.getPrice() < minNode.info.getPrice()) {
                minNode = index;
            }
            index = index.next;
        }

        // Hoán đổi thông tin nếu cần
        if (minNode != current) {
            Room temp = current.info;
            current.info = minNode.info;
            minNode.info = temp;
        }

        current = current.next;
    }
}
----------------------------------------------------------------------------
boolean borrowBook(Book request) {
    Stack<Book> tempStack = new Stack<>();

  
    boolean isBorrowed = false;
    while (!borrowRequests.isEmpty()) {
        Book currentRequest = borrowRequests.pop();
        if (currentRequest.getTitle().equals(request.getTitle())) {
            Node node = bookCatalog.search(bookCatalog.root, request.getTitle());
            if (node != null && node.info.getCopies() >= request.getCopies()) {
                node.info.setCopies(node.info.getCopies() - request.getCopies());
                isBorrowed = true;
            }
        }
        tempStack.push(currentRequest);
    }

    while (!tempStack.isEmpty()) {
        borrowRequests.push(tempStack.pop().getTitle(), tempStack.pop().getCopies());
    }

    return isBorrowed;
}
-----------------------------------------------------------------------------
double totalValue = 0.0;

    
    while (!borrowRequests.isEmpty()) {
        Book request = borrowRequests.pop();
        if (request != null) {
            Node node = bookCatalog.search(bookCatalog.root, request.getTitle());
            if (node != null && node.info.getCopies() >= request.getCopies()) {
                node.info.setCopies(node.info.getCopies() - request.getCopies());
                totalValue += request.getCopies() * (double) node.info.getPrice();
            }
        }
    }



*/