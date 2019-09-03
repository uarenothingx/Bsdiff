cmake_minimum_required(VERSION 3.4.1)

set(BZIP_SOURCES)
set(BS_PATCH_SOURCES)

file(GLOB_RECURSE BZIP_SOURCES ${CMAKE_SOURCE_DIR}/bzip/*.cpp ${CMAKE_SOURCE_DIR}/bzip/*.c)
file(GLOB_RECURSE BS_PATCH_SOURCES ${CMAKE_SOURCE_DIR}/bspatch/*.cpp ${CMAKE_SOURCE_DIR}/bspatch/*.c)

add_library(
        bspatch-lib
        SHARED
        ${BZIP_SOURCES}
        ${BS_PATCH_SOURCES})

find_library(
        log-lib
        log)

target_link_libraries(
        bspatch-lib
        ${log-lib})