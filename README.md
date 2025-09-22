
# 💰 PocketPilot – Your Personal Finance Co-Pilot  

[![Build](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/rishu8090/PocketPilot/actions)  
[![Android](https://img.shields.io/badge/platform-Android-blue)](https://developer.android.com/)  
[![Kotlin](https://img.shields.io/badge/language-Kotlin-purple)](https://kotlinlang.org/)  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)  

PocketPilot is an **expense and income tracking app** that helps you monitor your **daily** and **monthly** finances with ease.  

---

## ✨ Features  

- 📌 Add **income** and **expenses** with categories  
- 📊 View **daily** and **monthly** summaries  
- 📈 Visualize spending trends with **interactive graphs**  
- 🎨 Clean and minimal **UI**  
- 💾 Offline support with **Room/SQLite database**  

---

## 📱 Screenshots  

| Add Expense | Home Dashboard | Statistics |
|-------------|----------------|------------|
| ![Add Expense](https://github.com/user-attachments/assets/3d1957e0-9854-4f09-85bc-3510b4b5dabd)
 | ![Home Screen](https://github.com/user-attachments/assets/510318de-0126-4866-8a95-6ada54c9dec1)
 | ![Statistics](https://github.com/user-attachments/assets/d7ae0fa1-c330-47cf-88d9-7dc7242e3141)
 |

---
## 🚀 Getting Started  

### Prerequisites  
- [Android Studio](https://developer.android.com/studio) (latest version)  
- JDK 11+  
- Android SDK  

### Installation  

```bash
# Clone the repository
git clone https://github.com/rishu8090/PocketPilot.git
cd PocketPilot

# Build the project
./gradlew build

# Install on connected device/emulator
./gradlew installDebug
```
---

## 📂 Project Structure (High Level)

PocketPilot/
│── app/                 # Main application code
│   ├── src/main/java    # Kotlin source code
│   ├── res/             # XML layouts, drawables, etc.
│── gradle/              # Gradle wrapper
│── build.gradle.kts     # Project-level Gradle config
│── settings.gradle.kts  # Module linking


---
## 🛠 Tech Stack  

- **Language:** Kotlin
- **Architecture:** MVVM (Model-View-ViewModel)
- **Frameworks:** Android Jetpack (ViewModel, StateFlow, Room, etc.)  
- **Database:**  Room  
- **UI Components:** Material Design, XML Layouts  
- **Charts/Graphs:** MPAndroidChart (for statistics visualization)  
- **Build System:** Gradle (Kotlin DSL)  

---

## 🔮 Future Enhancements  

- ☁️ Cloud sync & backup (Google Drive / Firebase)  
- 🌙 Dark mode support  
- 📤 Export data to **CSV/PDF**  
- 🔔 Notifications & reminders for bill payments  
- 📊 More advanced insights (spending patterns, budget alerts)  
- 🌍 Multi-language support  

---

## 🤝 Contributing  

Contributions are welcome!  

1. Fork the project  
2. Create a feature branch (`git checkout -b feature/myFeature`)  
3. Commit changes (`git commit -m "Add new feature"`)  
4. Push (`git push origin feature/myFeature`)  
5. Open a Pull Request  

---

## 📜 License  

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.  

---

👉 Repo: [PocketPilot](https://github.com/rishu8090/PocketPilot)  
