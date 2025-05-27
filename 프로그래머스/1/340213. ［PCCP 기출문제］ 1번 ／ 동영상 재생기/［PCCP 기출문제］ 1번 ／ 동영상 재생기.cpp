#include <string>
#include <vector>
#include <iostream>
#include <sstream>
using namespace std;

int timeSerialize(const string &pos) {
    stringstream ss;
    ss << pos;
    
    string s_m, s_s;
    getline(ss, s_m, ':');
    getline(ss, s_s);
    return stoi(s_m) * 60 + stoi(s_s);
}

string timeDeserialize(const int &pos) {
    int m = pos / 60;
    int s = pos % 60;
    char buffer[20];
    
    sprintf(buffer, "%02d:%02d", m, s);
    return buffer;
}


string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    
    int sPos = timeSerialize(pos);
    int sStart = timeSerialize(op_start);
    int sEnd = timeSerialize(op_end);
    int sVidLen = timeSerialize(video_len);
    
    if (sPos >= sStart && sPos <= sEnd) sPos = sEnd;
    for (string command : commands) {
        if (command == "next") {
            sPos += 10;
            if (sPos > sVidLen) sPos = sVidLen;
        }
        else if (command == "prev") {
            sPos -= 10;
            if (sPos < 0) sPos = 0;
        }
        if (sPos >= sStart && sPos <= sEnd) sPos = sEnd;
    }
    
    if (sPos >= sStart && sPos <= sEnd) sPos = sEnd;
    return timeDeserialize(sPos);
}