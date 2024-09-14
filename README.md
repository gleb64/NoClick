
# NoClick

This is a workaround for a [bug](https://issuetracker.google.com/issues/246928482?pli=1) in Wear OS that plays a click sound when the screen goes off with any accessibility service enabled.

## Installation

1. Install [APK](https://github.com/gleb64/NoClick/releases) in your watch using any convenient method e.g [ADB AppControl](https://adbappcontrol.com/)
2. Activate NoClick in watch accessibility settings

## How it works

My log investigation showed that the click sound is playing between the intents DREAMING_STARTED and SCREEN_OFF. Both of these events occur when the screen turns off, with an interval of about 1 second. This sound is played through the Media channel. Therefore, this service mutes that channel between these events.

## License

NoClick is licensed under the [GPL-3.0 License](./LICENSE)