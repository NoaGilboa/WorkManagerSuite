# Common Module

This module contains shared logic, UI components, and models used by both the employee and employer applications.

## Features

- Abstract base activities (`MainBaseActivity`, `SummaryBaseActivity`, `SplashBaseActivity`)
- Dialog templates (`BaseAddItemDialog`)
- Data models:
    - `Employee`
    - `Worker`
- PDF export utility (`PdfExporter.kt`)
- Shared layouts and styles

## Usage

Both apps (`worktracker`, `employertracker`) depend on this module.
Make sure to declare:
```kotlin
implementation(project(":common"))
