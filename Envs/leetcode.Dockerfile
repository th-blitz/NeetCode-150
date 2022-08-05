FROM ubuntu:kinetic

LABEL MAINTAINER="https://github.com/ThBlitz | PreethamRakshith11@gmail.com"
LABEL VERSION="0.1.0"
LABEL DESCRIPTION="ubuntu:kinetic | python-3.9.13 | node.js-16.15 | Java Openjdk-18.0.2 | Rust 1.62.1 (latest)"

RUN apt-get update
RUN apt-get upgrade -y

RUN apt install build-essential -y
RUN apt install zlib1g-dev
RUN apt install libncurses5-dev -y
RUN apt install libgdbm-dev
RUN apt install libnss3-dev -y
RUN apt install libssl-dev
RUN apt install libreadline-dev
RUN apt install libffi-dev
RUN apt install wget -y
RUN apt install curl -y

SHELL ["/bin/bash", "--login", "-i", "-c"]
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.38.0/install.sh | bash
RUN source /root/.bashrc && nvm install 16.15.1
SHELL ["/bin/bash", "--login", "-c"]

WORKDIR /home
RUN mkdir -p python
WORKDIR /home/python

RUN wget https://www.python.org/ftp/python/3.9.13/Python-3.9.13.tgz
RUN tar -xvf Python-3.9.13.tgz
RUN rm Python-3.9.13.tgz
WORKDIR /home/python/Python-3.9.13
RUN ./configure --enable-optimizations
RUN make install 
RUN pip3 install virtualenv --no-cache-dir
RUN pip3 install requests --no-cache-dir

RUN curl https://sh.rustup.rs -sSf | bash -s -- -y
ENV ENV PATH="/root/.cargo/bin:${PATH}"

RUN mkdir /home/jvm
WORKDIR /home/jvm
RUN wget https://download.java.net/java/GA/jdk18.0.2/f6ad4b4450fd4d298113270ec84f30ee/9/GPL/openjdk-18.0.2_linux-x64_bin.tar.gz
RUN tar -xvzf openjdk-18.0.2_linux-x64_bin.tar.gz
RUN rm openjdk-18.0.2_linux-x64_bin.tar.gz
WORKDIR /home/jvm/jdk-18.0.2
RUN update-alternatives --install "/usr/bin/java" "java" "/home/jvm/jdk-18.0.2/bin/java" 0
RUN update-alternatives --install "/usr/bin/javac" "javac" "/home/jvm/jdk-18.0.2/bin/javac" 0
RUN update-alternatives --set java /home/jvm/jdk-18.0.2/bin/java 
RUN update-alternatives --set javac /home/jvm/jdk-18.0.2/bin/javac

WORKDIR /home
RUN mkdir -p mount
WORKDIR /home/mount

COPY fox /usr/local/bin




