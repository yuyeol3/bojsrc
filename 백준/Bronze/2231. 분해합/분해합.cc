#include <iostream>
#include <string>

using namespace std;

int main()
{
    int num;
    cin >> num;

    for (int i = 1; i < num; i++)
    {
        string tgNum = to_string(i);
        int res = stoi(tgNum);
        for (int i = 0; i < tgNum.length(); i++)
        {
            res += tgNum[i] - '0';
        }

        if (res == num)
        {
            cout << i << endl;
            return 0;
        }
    }
    
    cout << 0 << endl;

    return 0;
}