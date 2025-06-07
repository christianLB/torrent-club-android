# TorrentClub Android

This repository contains the initial setup for a **native Android** client of [Torrent VideoClub](https://github.com/christianLB/torrent-videoclub). The goal is to mirror the web interface while consuming the same REST API.

## Prerequisites

- Android Studio Hedgehog or later
- JDK 17+
- Android SDK installed (set `ANDROID_HOME` or use `local.properties`)

## Getting Started

1. Clone the project:
   ```bash
   git clone <this-repo> torrent-club-android
   cd torrent-club-android
   ```
2. Open the folder in Android Studio. The IDE will generate the Gradle wrapper JAR and download the toolchain.
3. Ensure the Torrent VideoClub backend is running and reachable.
4. Update `ApiClient.kt` with your backend server URL.
5. Run the **app** configuration to build and deploy the APK on a device or emulator.
   If using the command line, run `gradle wrapper` once to generate `gradle/wrapper/gradle-wrapper.jar` before executing `./gradlew`.
6. With the SDK configured locally you can trigger a build from the terminal:
   ```bash
   ./gradlew assembleDebug
   ```
7. Alternatively run the helper script to download the Android SDK and build in
   one step:
   ```bash
   ./build_startup.sh
   ```

The current build includes a featured home screen with a central carousel and Netflix-style category rows. Ensure your backend exposes `/api/featured` and `/api/featured/carousel-content` so the screen can load data.

See `docs/android-project-guide.md` for more details.
