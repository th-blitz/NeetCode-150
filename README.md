# NeetCode-150

All NeetCode 150 Problem solutions + Other Algos.

## Docker Image setup

Instructions to setup the docker image.

- Make sure to run all commands from the project root directory.
- build and setup the leetcode docker image. (Envs/leetcode.Dockerfile)
- run a docker container from the leetcode image.
- Open a interactive terminal from the running container.
- Run any files from the terminal.
- follow the same steps from 3 to re-run containers.

1. Make sure to run all the commands from the project root directory.

        i.e The root directory is : ./home/projects/NeetCode-150

2. Build the docker image 'leetcode' from the docker file leetcode.Dockerfile.

        docker build -t leetcode -f Envs/leetcode.Dockerfile Envs
    
    Building the image may take 5 - 10 mins. This is done only for the first time.

3. Run a container called leetcode from the built image.

    For windows cmd

        docker run --rm -d -t --name=leetcode -v %cd%:/home/mount leetcode 

    For Mac terminal OR windows powershell

        docker run --rm -d -t --name=leetcode -v ${PWD}:/home/mount leetcode

    For linux terminal

        docker run --rm -d -t --name=leetcode -v $(pwd):/home/mount leetcode

4. Open a interactive terminal from the running leetcode container.

        docker exec -ti leetcode bash

5. Run any files from within the shell.

        ls
        cd Arrays
        cd two_sum
        node two_sum.js

6. To stop and remove the running container.

        docker stop leetcode

7. To re-run the leetcode image.

        follow the same steps from step 3 above.