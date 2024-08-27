#include <cstdio>

struct Node {
    int data;
    int order;
    Node *next;
    Node *prev;
};

class LinkedList {
private:
    int length;
    Node *head;
    Node *tail;
public:
    typedef Node * iterator;
    LinkedList() {
        length = 0;
        head = NULL;
        tail = NULL;
    }
    void Add(int data, int order) {
        Node *newNode = new Node;
        
        newNode->data = data;
        newNode->order = order;
        newNode->prev = NULL;
        newNode->next = NULL;

        if (head == NULL) {
            head = newNode;
            tail = newNode;
        }

        if (tail != NULL) {
            newNode->prev = tail;
            tail->next = newNode;

            newNode->next = head;
            head->prev = newNode;

            tail = newNode;
        }
        length++;
    }
    void Remove(iterator i) {
        if (length >= 2) {
            if (i == head)
                head = i->next;

            if (i == tail)
                tail = i->prev;

            i->prev->next = i->next;
            i->next->prev = i->prev;
        }
        else if (length == 1) {
            head = tail = NULL;
        }
        else {
            return;
        }

        delete i;
        length--;
    }
    
    iterator begin() const {
        return head;
    }

    iterator end() const {
        return tail;
    }

    int GetLength() const {
        return length;
    }
    
    ~LinkedList() {
        iterator toDelete = head;
        for (int i = 0; i <length; ++i) {
            iterator temp = toDelete;
            toDelete = toDelete->next;
            delete temp;
        }
    }
};


int main() {
    int N;
    scanf("%d", &N);
    LinkedList lk;
    
    int tmp;
    for (int i = 0; i < N; ++i) {
        scanf("%d", &tmp);
        lk.Add(tmp, i+1);
    }

    LinkedList::iterator iter = lk.begin();
    for (int i = 0; i < N; ++i) {
        printf("%d ", iter->order);
        LinkedList::iterator todel = iter;

        int moveNum = iter->data;
        if (moveNum < 0) {
            for (int j = 0; j < -moveNum; ++j) {
                if (iter->prev == todel)
                    iter = iter->prev->prev;
                else
                    iter = iter->prev;
            }
        }
        else {
            for (int j = 0; j < moveNum; ++j) {
                if (iter->next == todel)
                    iter = iter->next->next;
                else
                    iter = iter->next;
            }
        }
        lk.Remove(todel);
    }
    printf("\n");

    return 0;
}