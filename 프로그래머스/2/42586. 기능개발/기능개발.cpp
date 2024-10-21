#include <string>
#include <vector>

using namespace std;

class Queue {
public:
    Queue(vector<int> &v) {
        maxSize = v.size() + 1;
        front = maxSize - 1;
        rear = maxSize - 1;
        info = new int[maxSize];
        
        for (int e : v) {
            Enqueue(e);
        }
    }
    
    
    void Enqueue(int item) {
        rear = (rear + 1) % maxSize;
        info[rear] = item;
    }
    
    int Dequeue() {
        front = (front + 1) % maxSize;
        return info[front];
    }
    
    bool IsFull() {
        return ((rear + 1) % maxSize == front);
    }
    
    bool IsEmpty() {
        return rear == front;
    }
    
    ~Queue() {
        delete []info;
    }
    
private:
    int *info;
    int front, rear;
    int maxSize;
};

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer(progresses.size(), 0);
    Queue workQueue(progresses);
    
    int location = -1;
    int workPeriod = 0;    
    for (int i = 0; i < progresses.size(); ++i) {
        
        int targetWorkProgress = workQueue.Dequeue();
        
        if (targetWorkProgress + workPeriod*speeds[i] >= 100) {
            answer[location]++;
        }
        else {
            workPeriod = (100 - targetWorkProgress)/speeds[i];
            workPeriod += ((100 - progresses[i])%speeds[i] > 0 ? 1 : 0);
            answer[++location]++;
        }
    }
    
    answer.resize(location+1);
    return answer;
}