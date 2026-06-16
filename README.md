# WC26-adr

**WC26 Android** — PWA 包装为 Android App（Trusted Web Activity）

基于 worldcup.jtcao.space 的 PWA，使用 Google 的 Android Browser Helper 打包为原生 Android 应用。

## 构建

### 前置条件

- Android Studio (Hedgehog 2023.1+) 或命令行
- JDK 17+
- Android SDK 34+

### 构建 APK

```bash
# 生成发布版 APK
./gradlew assembleRelease

# 或使用 Android Studio → Build → Generate Signed Bundle / APK
```

APK 位置: `app/build/outputs/apk/release/app-release.apk`

### 签名

项目已包含签名密钥（`android.keystore`），密码在 `app/build.gradle.kts` 中。

## 技术栈

- **框架**: Trusted Web Activity (TWA)
- **目标 URL**: https://worldcup.jtcao.space
- **最小 SDK**: 24 (Android 7.0)
- **目标 SDK**: 34 (Android 14)

## 发布

1. 构建签名的 `app-release.apk`
2. 上传到 Google Play Console
3. 设置 Digital Asset Links 验证（已配置）

## 项目结构

```
WC26-adr/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       └── res/            # 图标、主题、字符串
├── build.gradle.kts         # 顶级构建
├── settings.gradle.kts
├── gradle.properties
├── gradlew / gradlew.bat    # Gradle Wrapper
├── android.keystore         # 签名密钥
└── README.md
```
