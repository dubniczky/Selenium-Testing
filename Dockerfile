FROM gradle

# Install chrome
RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt update && apt upgrade -y
RUN apt install -y ./google-chrome-stable_current_amd64.deb

# Copy project
WORKDIR /usr/app
ADD build.gradle ./build.gradle
ADD src/ ./src/

# Install gradle dependencies
RUN gradle dependencies

# Assign entry
ENTRYPOINT [ "gradle" ]
CMD [ "test" ]