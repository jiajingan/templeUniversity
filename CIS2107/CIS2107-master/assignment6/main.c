#include <stdio.h>
#include "string6.h"

int main() {
    char s[] = "asd";// 3

    char p[] = "  jack";
    char s1[] = "jack  -    ";
    char s2[] = "    jack   ";
    char diffA[] = "alex";
    char diffB[] = "alec";

    printf("String length: %i\n", str_len(s));

    printf("All Letters: %i\n", all_letters(s));

    char a[] = "alexandar";// 9
    printf("Num in range: %i\n", num_in_range(a,'l','x' ));

    printf("Diff: %i\n", diff(diffA, diffB));

    shorten(s, 2);
    printf("Shorten word: %s\n", s);

    printf("Length diff: %i\n", len_diff(a, s));

    rm_left_space(p);
    printf("Remove left space: %s\n", p);

    rm_right_space(s1);
    printf("Remove right space: %s\n", s1);

    rm_space(s2);
    printf("remove space: %s\n", s2);

    printf("find: %i\n", find(diffA, "e"));

    printf("pointer to: %p\n",ptr_to(diffA, "e") );

    char f[] = "";
    printf("is empty: %i\n", is_empty(f));

    printf("string zip: %s\n", str_zip(diffA, diffB));//comeback to string zip

    capitalize(diffB);
    printf("capitalize: %s\n", diffB);

    printf("string ignore case: %i\n", strcmp_ign_case(diffA,diffB));

    take_last(a, 2);
    printf("take last: %s\n",a );

    printf("dedup: %s\n", dedup("There's always money in the banana stand."));

    printf("pad: %s\n", pad("sophia123456", 7));

    printf("ends with ignore case: %i\n", ends_with_ignore_case("jumbo","Bo"));

    printf("repeat: %s\n",repeat("yes",3, ','));

    printf("replace: %s\n",replace("chicken X", "X", "nugget"));

    char *r[] = {"Washington", "Adams", "Jefferson"};
    printf("string connect: %s\n", str_connect(r,3,'+'));

    char *w[6] = {"Hello", "", "", "World", "jack", NULL};
    rm_empties(w);
    printf("remove empties: ");
    for (int i = 0; i < 3; ++i) {
        printf("%s, ", w[i]);
    }
    printf("\n");

    char *z = "I am ready for a nice vacation";
    char **chop = str_chop_all(z, ' ');
    printf("Chop: ");
    while (*(chop + 1) != NULL){
        printf("%s, ", *chop);//comma to check they are actually separated
        chop++;
    }
    printf("%s ", *chop);
    printf("\n");

    return 0;
}