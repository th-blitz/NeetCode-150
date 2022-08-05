# NeetCode-150

My NeetCode 150 Practice Problems. <br /><br />
Neetcode 150 is a curated list of 150 LeetCode problems designed to cover all possible patterns & topics in data structures. <br />
Mainly practicing in ``` C++ ``` , ``` Rust ``` , ``` Python ``` & ``` JAVA ```.<br /> 
The list was created by Neetcode-gh - https://github.com/neetcode-gh, originally based on another list called blind 75 with 75 problems.<br />
List @ https://neetcode.io/ <br />

# Docker Image setup

- Setup the docker image ``` leetcode.Dockerfile ``` (2.63 GB) at ./NeetCode/Envs/ . <br /> 
- The iamge used here is ``` Ubuntu:kinetic ```.
- The Image includes; 
- ``` Python 3.8.13 ```, ``` node v16.15.1 ```, ``` rust 1.62.1 ``` and ``` OpenJDK 18.0.2 ```.
- Prerequisites - ``` Docker ``` for desktop/mac/linux. <br /> 

# Instructions to setup the docker image.

### 1. **Make sure to run all the commands from the project root directory.**

```sh
cd /home/projects/NeetCode-150
```

### 2. **Build the docker image 'leetcode' from the docker file leetcode.Dockerfile.**

```sh
docker build -t leetcode -f Envs/leetcode.Dockerfile Envs
```        
*```Building the image may take 5 to 15 mins. This is done only for the first time.```*

### 3. **Run a container called leetcode from the built image.**

*```  For windows cmd  ```*
```sh      
docker run --rm -d -t --name=leetcode -v %cd%:/home/mount leetcode 
```        

*```For Mac terminal OR windows powershell```*
```sh
docker run --rm -d -t --name=leetcode -v ${PWD}:/home/mount leetcode
```

*``` For linux terminal ```*
```sh
docker run --rm -d -t --name=leetcode -v $(pwd):/home/mount leetcode
```

### 4. **Open a interactive terminal from the running leetcode container.**

```sh
docker exec -ti leetcode bash
```

### 5. **Run any files from within the shell.**
        
```sh
ls
cd Arrays
cd two_sum
node two_sum.js
```
### 6. **To stop and remove the running container.**

```sh
docker stop leetcode
```

### 7. **To re-run the leetcode image.**
```sh
follow the same steps from step 3 above.
```
