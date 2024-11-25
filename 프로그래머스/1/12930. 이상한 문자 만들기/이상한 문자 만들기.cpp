#include <string>
#include <vector>
#include <sstream>
using namespace std;

string solution(string s) {
    stringstream ss;
    string answer = "";
    
    int idx = 0;
    for (char c : s) {
        if (c == ' ') {
            idx = 0;
            ss << ' ';
        }
        else {
            ss << (char) (idx % 2 == 0 ? toupper(c) : tolower(c));
            idx++;
        }
        
    }
    
    getline(ss, answer);
    return answer;
}