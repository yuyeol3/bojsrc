#include <iostream>
using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int cards[20];
    for (int i = 0; i < 20; i++)
        cards[i] = i + 1;

    int st, ed;
    for (int i = 0; i < 10; i++) {
        cin >> st >> ed;
        int *section = cards + (st - 1);
        int length = ed - st + 1;

        for (int j = 0; j < length / 2; j++) {
            swap(section[j], section[length - 1 - j]);
        }
    }

    for (int i = 0; i < 20; i++)
        cout << cards[i] << ' ';
    cout << '\n';
    
    return 0;
}