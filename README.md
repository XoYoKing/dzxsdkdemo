# 大珍象SDK Demo Android版
调用大珍象SDK进行监控设备操作的Demo

## 接口
- DZXSDK.openUI_CheckYSSDK : 检查萤石SDK的初始化状态，如果未初始化则执行初始化操作
    - 输入参数
        - iFrom : 跟踪用的
        - theContext : 当前的上下文实例
        - theApplication : 应用的Application
- DZXSDK.openUI_setStrWaterMark : 设置自定义水印文本
    - 输入参数
        - iFrom : 跟踪用的
        - strWaterMarkValue : 自定义水印文本
- DZXSDK.openUI_CameraList : 根据用户打开对应的设备列表界面
    - 输入参数
        - theContext : 当前的上下文实例
        - strUserID : 对应用户的微信openid
- DZXSDK.openUI_CameraRealPlay : 根据指定的摄像头打开其直播界面
    - 输入参数
        - theContext : 当前的上下文实例
        - strDeviceSerial : 对应设备的序列号，摄像头的序列号或者NVR的序列号
        - iCameraIndex : 使用NVR的序列号时iCameraIndex就是通道号，否则iCameraIndex=0；注意：此处的iCameraIndex是真实的通道号，如果从服务器获取的通道号不是真实的，比如从1开始，也就是加了1，这里需要对应减1，否则会出现395451错误
- DZXSDK.openUI_CameraPlayBack : 根据指定的摄像头打开其回播界面
    - 输入参数
        - theContext : 当前的上下文实例
        - strDeviceSerial : 对应设备的序列号，摄像头的序列号或者NVR的序列号
        - iCameraIndex : 使用NVR的序列号时iCameraIndex就是通道号，否则iCameraIndex=0；注意：此处的iCameraIndex是真实的通道号，如果从服务器获取的通道号不是真实的，比如从1开始，也就是加了1，这里需要对应减1，否则会出现395451错误

## 简单使用
建议使用之前先把demo跑一下，我对已开放的接口的使用都进行了演示。

- 拷贝 dzxsdkYYYY.MM.DD.aar及so库 到目录 app/libs
    - 见Demo的目录 app/libs
- 修改 build.gradle 增加对aar库的引用
```
dependencies {
    ...
    implementation fileTree(dir: 'libs', include: ['*.jar','*.aar'])
    ...
}
```
- 修改引用SDK的Activity的theme为@style/Theme.AppCompat.Light
```
        <activity
            android:name=".FullscreenActivity"
            android:configChanges="orientation|keyboardHidden|screenSize"
            android:label="@string/app_name"
            android:screenOrientation="portrait"
            android:theme="@style/Theme.AppCompat.Light">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```
- 调用SDK接口
    - DZXSDK.openUI_CameraList
```
        String strUserID="oJ0qB1utZD9wm8c4rxl7eoBgmUkc";
        DZXSDK.openUI_CameraList(this,strUserID);
```
    - DZXSDK.openUI_CameraRealPlay
```
        String strDeviceSerial="C32940646";
        int iCameraIndex=4;
        DZXSDK.openUI_CameraRealPlay(this,strDeviceSerial,iCameraIndex);
```
    - DZXSDK.openUI_CameraPlayBack
```
        String strDeviceSerial="C32940646";
        int iCameraIndex=4;
        DZXSDK.openUI_CameraPlayBack(this,strDeviceSerial,iCameraIndex);
```
   
## 联系我
- 邮箱：59186618@qq.com

## License
```
Copyright (c) 2019~2020 YBX

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

# 参考： [大珍象APP](http://tuyun.ybxin.net/apk/dzxapp.apk)

