@echo off

rem env build genesis
rem env run genesis container
rem env shell container
rem env stop container

set arg2=%1
set arg3=%2
set arg4=%3

if not defined arg2 (
    set arg2=none
)

if defined arg3 (
    if not defined arg4 (
        set containerName=%arg3%
    ) else (
        set containerName=%arg4%
    )
)


if "%arg2%"=="build" (
    if defined arg3 (
        docker build -t %arg3% -f Envs/%arg3%.Dockerfile Envs
    )
)

if "%arg2%"=="run" (
        
    echo image name     : %arg3%
    echo container name : %containerName%
    echo pwd            : %cd%

    docker run --rm -d -t --name=%containerName% ^
    -p 8888:8888 -p 3000:3000 ^
    -v %cd%:/home/mount ^
    %arg3%
)

if "%arg2%"=="shell" (
    if defined arg3 (
        set containerName=%arg3%
    )
    docker exec -ti %containerName% bash
)

if "%arg2%"=="stop" (
    if defined arg3 (
        set containerName=%arg3%
    )
    docker stop %containerName%
)



set arg2=
set arg3=
set arg4=






