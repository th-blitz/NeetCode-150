# NeetCode-150

All NeetCode 150 Problems + Algos.

### Docker Image setup.

Instructions to setup the docker image. 

1. Make sure to run all the commands from the project root directory.

        The root directory is : $/NeetCode-150

2. Build the docker image 'leetcode' from the docker file leetcode.Dockerfile.

        docker build -t leetcode -f Envs/leetcode.Dockerfile Envs

3. Building the image may take 5 - 10 mins. This is done only for the first time.

4. Run leetcode:latest docker image.

        # For windows cmd
        docker run --rm -d -t --name=leetcode -v %cd%:/home/mount leetcode 

        # For Mac terminal 
        # Or 
        # windows powershell
        docker run --rm -d -t --name=leetcode -v ${PWD}:/home/mount leetcode

        # For linux terminal
        docker run --rm -d -t --name=leetcode -v $(pwd):/home/mount leetcode

5. Open a interactive Shell from the running leetcode container.

        docker exec -ti leetcode bash

6. Run any files from within the shell.

        ls
        cd Arrays
        cd two_sum
        node two_sum.js

7. To stop and remove the running container.

        docker stop leetcode

8. To re-run the leetcode image.

        follow the same steps from step 4 above.