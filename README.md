# Work Manager Suite

This repository contains two Android applications with a shared module:
- **Work Tracker** (for employees)
- **Employer Tracker** (for employers)

Both apps share common logic, UI, and models via the `common` module, promoting reuse and consistency.

---

## 📱 Work Tracker (Employee App)
Tracks daily work hours, calculates monthly totals and averages, and allows PDF export.

### Features
- Splash screen with animated logo
- Main screen: RecyclerView of work entries (date, day, start/end, total)
- Add work entry via dialog
- Monthly summary: total hours, average per workday
- PDF export and sharing

### Getting Started
```bash
./gradlew :worktracker:installDebug
```

---

## 🧑‍💼 Employer Tracker (Employer App)
Manages employee data including hours, wages, and generates monthly payroll summaries.

### Features
- Splash screen with branded logo
- Main screen: RecyclerView with employee info
- Add employee via dialog
- Monthly summary: total employees, hours, salaries
- PDF export and sharing

### Getting Started
```bash
./gradlew :employertracker:installDebug
```

---

## 🧩 Shared Module - `common`
The `common` module contains:
- Abstract base activities for splash, main, and summary screens
- Models (`Employee`, `Worker`)
- Reusable dialogs and UI components
- PDF export utility

---

## 🎥 Demo
[Click to view demo video](Screen%20Recording%202025-04-22%20at%202.42.21.mov)

---

## 🧑‍💻 Author
**Noa Gilboa**
