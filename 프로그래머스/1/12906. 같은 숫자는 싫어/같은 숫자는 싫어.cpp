#include <vector>
#include <iostream>

using namespace std;

class Stack {
public:
    Stack(int max): top(-1) {
        arr = new int[max];
    }

    void Pop() {
        top--;
    }
    
    int Top() {
        return arr[top];
    }
    
    void Push(int item) {
        arr[++top] = item;
    }
    
    ~Stack() {
        delete []arr;
    }
    
private:
    int *arr;
    int top;
};


vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    Stack st(arr.size());
    
    st.Push(arr[0]);
    answer.push_back(arr[0]);
    for (int i = 1; i < arr.size(); ++i) {
        if (st.Top() != arr[i])
            answer.push_back(arr[i]);
        
        st.Push(arr[i]);
    }
    
    return answer;
}