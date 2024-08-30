#include <stdio.h>
#include <string.h>
int main() {
    char s[21];
    int N;
    scanf("%d", &N);

    for (int i = 0; i < N; ++i) {
        int repeat;
        scanf("%d", &repeat);
        scanf("%s", s);

        for (int j = 0; j < strlen(s); ++j) {
            for (int k = 0; k < repeat; ++k)
                printf("%c", s[j]);
        }
        printf("\n");
    }

    return 0;
}