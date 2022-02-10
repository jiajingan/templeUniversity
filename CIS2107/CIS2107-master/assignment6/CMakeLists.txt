cmake_minimum_required(VERSION 3.17)
project(assignment6 C)

set(CMAKE_C_STANDARD 99)

add_executable(assignment6 main.c
        str_len.c
        all_letters.c
        capitalize.c
        str_connect.c
        dedup.c
        diff.c
        ends_with_ignore_case.c
        find.c
        is_empty.c
        len_diff.c
        num_in_range.c
        pad.c
        ptr_to.c
        repeat.c
        replace.c
        rm_empties.c
        rm_left_space.c
        rm_right_space.c
        rm_space.c
        shorten.c
        str_chop_all.c
        str_zip.c
        strcmp_ign_case.c
        take_last.c)