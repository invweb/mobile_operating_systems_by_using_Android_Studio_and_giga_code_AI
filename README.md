# Мобильные операционные системы / Mobile Operating Systems / Mobile Systeme

## Описание / Description / Beschreibung

### Русский
Это приложение показывает список актуальных мобильных операционных систем с их версиями и ссылками на официальные сайты. В приложении реализована архитектура MVI (Model-View-Intent) с использованием Jetpack Compose и Kotlin.

### English
This application shows a list of current mobile operating systems with their versions and links to official websites. The app implements MVI (Model-View-Intent) architecture using Jetpack Compose and Kotlin.

### German
Diese Anwendung zeigt eine Liste aktueller mobiler Betriebssysteme mit ihren Versionen und Links zu den offiziellen Websites. Die App implementiert die MVI-Architektur (Model-View-Intent) mit Jetpack Compose und Kotlin.

## Технологии / Technologies / Technologien

### Русский
- Jetpack Compose — современный UI-фреймворк для Android
- Kotlin — основной язык программирования
- MVI архитектура — разделение ответственности между слоями
- ViewModel — управление состоянием UI
- StateFlow — реактивное обновление данных
- Coroutines — асинхронные операции

### English
- Jetpack Compose — modern UI framework for Android
- Kotlin — primary programming language
- MVI architecture — separation of concerns between layers
- ViewModel — UI state management
- StateFlow — reactive data updates
- Coroutines — asynchronous operations

### German
- Jetpack Compose — modernes UI-Framework für Android
- Kotlin — primäre Programmiersprache
- MVI-Architektur — Trennung der Verantwortlichkeiten zwischen Schichten
- ViewModel — UI-Zustandsverwaltung
- StateFlow — reaktive Datenaktualisierung
- Coroutines — asynchrone Operationen

## Список операционных систем / List of operating systems / Liste der Betriebssysteme

| ОС / OS / Betriebssystem | Версия / Version / Version | Ссылка / Link / Link |
|--------------------------|----------------------------|---------------------|
| Android 15 | https://www.android.com/ |
| iOS 18 | https://www.apple.com/ios/ |
| HarmonyOS 5.0 | https://www.harmonyos.com/ |
| Windows Mobile 10 | https://www.microsoft.com/mobile/ |
| KaiOS 3.0 | https://www.kaiostech.com/ |
| BlackBerry OS 10 | https://www.blackberry.com/ |
| Sailfish OS 4.5 | https://sailfishos.org/ |
| Tizen 7.0 | https://www.tizen.org/ |

## Установка / Installation / Installation

1. Склонируйте репозиторий / Clone the repository / Repository klonen:
```bash
git clone https://github.com/invweb/mobile-operating-systems.git
```

2. Откройте проект в Android Studio / Open the project in Android Studio / Öffnen Sie das Projekt in Android Studio

3. Синхронизируйте Gradle / Sync Gradle / Gradle synchronisieren

4. Запустите приложение / Run the app / App ausführen

## Архитектура / Architecture / Architektur

### Модуль MVI / MVI Module / MVI Modul

**MobileSystemsIntent.kt** — действия пользователя (например, загрузка данных)
**MobileSystemsState.kt** — состояние UI (загрузка, данные, ошибка)
**MobileSystemsViewModel.kt** — обрабатывает интенты и управляет состоянием
**MobileSystemsConfig.kt** — конфигурация систем с ID ресурсов и URL

## Лицензия / License / Lizenz

Этот проект создан в образовательных целях.

## Ссылки / Links / Links

- GitHub: https://github.com/invweb/mobile-operating-systems
- Android: https://www.android.com/
- iOS: https://www.apple.com/ios/
- HarmonyOS: https://www.harmonyos.com/
