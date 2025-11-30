/*
void addLast(String code, int status, int size, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (price <= 0 || size <= 0) {
            return;
        }
        Node p = new Node(new Room(code, status, size, price));
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }

        //---------------------------------------------------------
    }
void enQueue(int size, int price) {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (size <= 0 || price <= 0) {
            return;
        }
        Node n = new Node(new Room("", 0, size, price));
        if (rear == null) {
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
        //---------------------------------------------------------
    }
 Room deQueue() {
        Room tmp = new Room();
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (front == null) {
            return null;
        }
        tmp = front.info;
        front = front.next;
        if (front == null) {
            rear = null;
        }

        //---------------------------------------------------------
        return tmp;
    }
 void rent(Room t) throws Exception {
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        if (t == null) {
            return;
        }
        Node bestRoom = null;
        Node current = dList.head;
        while (current != null) {
            Room room = current.info;

            if (room.getStatus() == 0
                    && room.getSize() >= t.getSize()
                    && room.getPrice() <= t.getPrice()) {

                if (bestRoom == null
                        || room.getPrice() < bestRoom.info.getPrice()
                        || (room.getPrice() == bestRoom.info.getPrice() && current != bestRoom)) {
                    bestRoom = current;
                }
            }
            current = current.next;
        }
        if(bestRoom != null){
            bestRoom.info.setStatus(1);
        }

            while(!RQueue.isEmpty()){
            Room request = RQueue.deQueue();
            this.rent(request);
        }
        Node current = dList.head;
        while(current != null){
            if(current.info.getStatus() == 0){
                count++;}
            current = current.next;
            
        }
int purchase(Fruit r) {
        if (r == null) {
            return 0;
        }
        
        Node current = FList.head;
        while (current != null) {
            if (current.info.getType().equals(r.getType())) {
                if (current.info.getAmount() >= r.getAmount()) {
                    current.info.setAmount(current.info.getAmount() - r.getAmount());
                    return current.info.getPrice() * r.getAmount();
                }
                return 0;

            }
            current = current.next;
        }
        return 0;

    }
----------------------------------------------------------------------------------------
void sortByPrice() {

        Node current = FList.head;
        while (current != null) {
            Node minNode = current;
            Node index = current.next;

            while (index != null) {
                if (index.info.getPrice() < minNode.info.getPrice()) {
                    minNode = index;
                }
                index = index.next;
            }

            if (minNode != current) {
                Fruit temp = current.info;
                current.info = minNode.info;
                minNode.info = temp;
            }

            current = current.next;
        }
    }
*/