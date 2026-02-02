#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int set = 0;

int main(void) {
    int n;
    scanf("%d", &n);

    int bufSize = 0;
    bool buf[n + 1];
    char cmd[10];
    int x;
    while (n-->0) {
        scanf("%s", cmd);

        if (!strcmp(cmd, "add")) {
            scanf("%d", &x);
            set = (set | (1 << x));
        }
        else if (!strcmp(cmd, "remove")) {
            scanf("%d", &x);
            set = (set & ~(1 << x));
        }
        else if (!strcmp(cmd, "check")) {
            scanf("%d", &x);
            buf[bufSize++] = (set >> x) & 1;
        }
        else if (!strcmp(cmd, "toggle")) {
            scanf("%d", &x);
            set = set ^ (1 << x);
        }
        else if (!strcmp(cmd, "all")) {
            set = ~0;
        }
        else if (!strcmp(cmd, "empty")) {
            set = 0;
        }
    }

    for (int i = 0; i < bufSize; i++)
        printf("%d\n", buf[i]);
    return 0;
}