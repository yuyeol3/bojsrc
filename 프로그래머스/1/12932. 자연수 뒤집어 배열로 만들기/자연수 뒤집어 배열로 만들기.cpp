#include <string>
#include <vector>
#include <sstream>
#include <cstdio>
#include <iostream>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    
    stringstream ss;
    ss << n;
    string buff;
    ss >> buff;
    
    for (int i = buff.length() - 1; i >= 0; i--) {
        answer.push_back(buff[i] - '0');
    }

    return answer;
}