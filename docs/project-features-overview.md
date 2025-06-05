# Project Features Overview

This summary outlines the main features of Torrent VideoClub as described in the upstream README. It helps understand what functionality should be supported when porting the app to Android.

- **Movie & TV Series Discovery** – Search and browse media from trackers connected via Prowlarr.
- **Advanced Filtering** – Filter by genre, year, rating and quality.
- **TMDb Integration** – Metadata from TMDb enriches torrent data.
- **Seamless Integration** – One‑click addition of items to Radarr or Sonarr.
- **Modern UI** – Responsive design using Tailwind CSS and Shadcn UI.
- **Dark/Light Mode** – Switch themes according to preference.
- **Mobile Friendly** – Layout adapts to phones and tablets.

## Environment Variables

A `.env.local` file is required with keys and URLs for Prowlarr, Radarr, Sonarr and TMDb. Copy `env.template` from the upstream project and fill in values such as `PROWLARR_URL`, `RADARR_API_KEY`, `SONARR_API_KEY`, and `TMDB_API_KEY`.

Refer to these variables when configuring the Android build so the app can communicate with your backend services.
