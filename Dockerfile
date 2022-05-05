FROM gradle

RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt update && apt upgrade -y
RUN apt install -y ./google-chrome-stable_current_amd64.deb

WORKDIR /usr/app

ADD build.gradle ./build.gradle
ADD src/ ./src/

RUN gradle dependencies

ENTRYPOINT [ "gradle" ]
CMD [ "test" ]