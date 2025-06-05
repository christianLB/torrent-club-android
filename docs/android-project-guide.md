# Android Implementation Guide

This document summarizes the steps required to package the Torrent VideoClub frontend as an Android/Fire TV application using Capacitor.

## 1. Prerequisites

- **Node.js** 18 or later and npm
- **JDK** 17 or later
- **Android Studio** with platform tools
- **Capacitor CLI** (`npm install -g @capacitor/cli`)
- A `.env.local` file configured with the required API keys (see the upstream repository)

## 2. Build the Web Application

1. Install dependencies:
   ```bash
   npm install
   ```
2. Build production assets:
   ```bash
   npm run build
   ```
3. Export the site as static files (Capacitor expects an `out/` directory):
   ```bash
   npx next export
   ```

## 3. Initialize and Sync the Android Project

1. If the `android/` folder does not exist, add the platform:
   ```bash
   npx cap add android
   ```
2. Copy the latest web build into the native project:
   ```bash
   npx cap copy android
   ```

## 4. Connect the App to the Backend

Ensure the Node.js backend is running and reachable from your device. Update `capacitor.config.ts` with the server URL:

```ts
server: {
  url: 'http://<YOUR_SERVER_IP>:3000',
  cleartext: true
}
```

After editing the configuration, resynchronize:
```bash
npx cap copy android
```

## 5. Build the APK

1. Inside the `android` directory run:
   ```bash
   ./gradlew assembleDebug
   ```
   The APK will be located at `android/app/build/outputs/apk/debug/app-debug.apk`.
2. For a release build configure signing and run `./gradlew assembleRelease`.

## 6. Install on Fire TV / Android TV

1. Enable developer options and ADB debugging on your device.
2. Connect via ADB from your computer:
   ```bash
   adb connect <FIRE_TV_IP_ADDRESS>
   ```
3. Install the APK:
   ```bash
   adb install app-debug.apk
   ```

## 7. Remote Navigation Tips

- Provide clear focus states for buttons and cards.
- Use the D‑pad to navigate carousel items and lists.
- Test on actual hardware to verify Fire TV compatibility.

This guide is adapted from the [christianLB/torrent-videoclub](https://github.com/christianLB/torrent-videoclub) documentation.
