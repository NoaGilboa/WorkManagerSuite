# Work Tracker (Employee App)

This application is designed for employees to track their working hours and generate summaries including total monthly hours and PDF exports.

## Features

- Splash screen with animated logo
- Main screen: RecyclerView showing work entries (date, day, start/end time, total)
- Add work entry via dialog
- Monthly summary: total hours, average per workday, PDF export

## Tech Stack

- Kotlin
- Android SDK
- Shared `common` module for reusable logic

## Getting Started

```bash
./gradlew :worktracker:installDebug
