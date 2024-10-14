#include <iostream>
using namespace std;

void preset()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}


struct Node {
    int info;
    Node *next;
};

class Stack {
public:
    Stack(): top(NULL), length(0) {

    }

    void Push(int item) {
        Node *newNode = new Node;
        newNode->info = item;
        newNode->next = top;
        top = newNode;
        length++;
    } 

    int Top()
    {
        return top->info;
    }

    void Pop()
    {
        Node *tempPtr;
        tempPtr = top;
        top = top->next;
        delete tempPtr;
        length--;
    }

    bool IsEmpty() const
    {
        return length == 0;
    }

    int GetLength() const 
    {
        return length;
    }

private:
    Node *top;
    int length;
};


int main()
{
    preset();
    Stack st;

    int N;
    cin >> N;
    for (int i = 0; i < N; ++i)
    {
        int input, val;
        cin >> input;
        switch (input)
        {
            case 1:
                cin >> input;
                st.Push(input);
                break;
            case 2:
                if (st.IsEmpty()) {
                    cout << -1 << '\n';
                    break;
                }

                val = st.Top();
                st.Pop();
                cout << val << '\n';
                break;
            case 3:
                cout << st.GetLength() << '\n';
                break;
            case 4:
                cout << st.IsEmpty() << '\n';
                break;
            case 5:
                if (st.IsEmpty()) {
                    cout << -1 << '\n';
                    break;
                }
                
                val = st.Top();
                cout << val << '\n';
                break;
        }
    }

    return 0;
}