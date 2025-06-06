# Android Implementation Guide

This guide explains how to build the native Torrent VideoClub Android application.

## 1. Prerequisites

- **JDK** 17 or later
- **Android Studio** with platform tools
- Access to a running Torrent VideoClub backend

## 2. Open the Project

1. Clone this repository and open it in Android Studio.
2. Allow the IDE to download the Gradle toolchain and generate the wrapper JAR.

## 3. Configure the Backend

Edit `app/src/main/java/com/torrentclub/app/ApiClient.kt` and set `BASE_URL` to the address of your backend server.

## 4. Build the APK

From Android Studio you can run or build the app directly. If building from the command line, first run `gradle wrapper` to generate `gradle/wrapper/gradle-wrapper.jar` and then execute:
```bash
./gradlew assembleDebug
```
The APK will be located at `app/build/outputs/apk/debug/app-debug.apk`.

For a release build configure signing and run `assembleRelease`.

## 5. Install on Fire TV / Android TV

1. Enable developer options and ADB debugging on your device.
2. Connect via ADB from your computer:
   ```bash
   adb connect <FIRE_TV_IP_ADDRESS>
   ```
3. Install the APK:
   ```bash
   adb install app-debug.apk
   ```

## 6. Remote Navigation Tips

- Provide clear focus states for buttons and cards.
- Use the D‑pad to navigate carousel items and lists.
- Test on actual hardware to verify TV compatibility.
