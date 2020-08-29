FROM openjdk:8-jdk

# Just matched `app/build.gradle`
ENV ANDROID_COMPILE_SDK "29"
# Just matched `app/build.gradle`
ENV ANDROID_BUILD_TOOLS "29.0.3"
# Version from https://developer.android.com/studio/releases/sdk-tools
ENV ANDROID_SDK_TOOLS "6609375"
# Version from https://services.gradle.org/distributions/
ENV GRADLE_VERSION "6.1.1"

ENV ANDROID_HOME /android-sdk-linux
ENV PATH="${PATH}:/android-sdk-linux/tools/bin"
ENV PATH="$PATH:/opt/gradle/gradle-${GRADLE_VERSION}/bin"

# install OS packages
RUN apt-get --quiet update --yes
RUN apt-get --quiet install --yes wget tar unzip lib32stdc++6 lib32z1 build-essential ruby ruby-dev
# We use this for xxd hex->binary
RUN apt-get --quiet install --yes vim-common
# install Android SDK
RUN wget --quiet --output-document=android-sdk.zip https://dl.google.com/android/repository/commandlinetools-linux-${ANDROID_SDK_TOOLS}_latest.zip
RUN unzip -d ${ANDROID_HOME} android-sdk.zip
RUN yes | sdkmanager --sdk_root=${ANDROID_HOME} --licenses
RUN echo y | sdkmanager --sdk_root=${ANDROID_HOME} --install "platforms;android-${ANDROID_COMPILE_SDK}"
RUN echo y | sdkmanager --sdk_root=${ANDROID_HOME} --install platform-tools
RUN echo y | sdkmanager --sdk_root=${ANDROID_HOME} --install "build-tools;${ANDROID_BUILD_TOOLS}"
RUN echo y | sdkmanager --sdk_root=${ANDROID_HOME} --install "extras;android;m2repository"
RUN echo y | sdkmanager --sdk_root=${ANDROID_HOME} --install "extras;google;google_play_services"
RUN wget "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
RUN mkdir /opt/gradle
RUN unzip -d /opt/gradle gradle-${GRADLE_VERSION}-bin.zip

# install Fastlane
# COPY Gemfile.lock . --> Always use newest version
COPY Gemfile .
RUN gem install bundle
RUN bundle install