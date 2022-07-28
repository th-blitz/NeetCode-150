FROM ubuntu:kinetic

LABEL MAINTAINER="https://github.com/ThBlitz"
LABEL VERSION="0.0.0"
LABEL DESCRIPTION="ubuntu:kinetic||python-3.8||node.js-16.15"

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

RUN wget https://www.python.org/ftp/python/3.8.13/Python-3.8.13.tgz
RUN tar -xvf Python-3.8.13.tgz
RUN rm Python-3.8.13.tgz
WORKDIR /home/python/Python-3.8.13
RUN ./configure --enable-optimizations
RUN make install 
RUN pip3 install virtualenv --no-cache-dir
RUN pip3 install requests --no-cache-dir

WORKDIR /home
RUN mkdir -p mount
WORKDIR /home/mount

COPY fox /usr/local/bin




