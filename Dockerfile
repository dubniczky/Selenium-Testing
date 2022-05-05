FROM gradle

WORKDIR /usr/app

ADD build.gradle ./build.gradle
ADD src/ ./src/

RUN gradle dependencies

ENTRYPOINT [ "gradle" ]
CMD [ "test" ]