#!/usr/bin/env bash
set -euo pipefail

# Directory for the Android SDK
ANDROID_SDK_ROOT="$HOME/android-sdk"
CMDLINE_TOOLS_VERSION="10406996"
TOOLS_ZIP="commandlinetools-linux-${CMDLINE_TOOLS_VERSION}_latest.zip"
TOOLS_URL="https://dl.google.com/android/repository/${TOOLS_ZIP}"

if [ ! -d "$ANDROID_SDK_ROOT" ]; then
  mkdir -p "$ANDROID_SDK_ROOT/cmdline-tools"
  echo "Downloading Android command line tools..."
  curl -L "$TOOLS_URL" -o "$TOOLS_ZIP"
  unzip -q "$TOOLS_ZIP" -d "$ANDROID_SDK_ROOT/cmdline-tools"
  mv "$ANDROID_SDK_ROOT/cmdline-tools/cmdline-tools" "$ANDROID_SDK_ROOT/cmdline-tools/latest"
  rm "$TOOLS_ZIP"
fi

export ANDROID_HOME="$ANDROID_SDK_ROOT"
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$ANDROID_HOME/platform-tools:$PATH"

# Install required SDK components
yes | sdkmanager --licenses >/dev/null
sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0" >/dev/null

# Generate Gradle wrapper JAR if missing
if [ ! -f gradle/wrapper/gradle-wrapper.jar ]; then
  gradle wrapper
fi

# Run the build
./gradlew assembleDebug
