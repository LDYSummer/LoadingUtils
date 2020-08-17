# LoadingUtils
[![](https://jitpack.io/v/LDYSummer/LoadingUtils.svg)](https://jitpack.io/#LDYSummer/LoadingUtils)

-加载动画工具类

### 添加项目依赖
#### build.gradle
```javascript
allprojects {
	 repositories {
	  ...
		 maven { url 'https://jitpack.io' }
	 }
 }
```

#### dependency
```javascript
dependencies {
	        implementation 'com.github.LDYSummer:LoadingUtils:1.0.1'
	}
```

### 使用 
```javascript
final LoadingUtils utils = LoadingUtils.init(this);
utils.startLoading();
...
utils.finishLoading();
```

#### 自定义方法
| 方法 | 方法说明 | 参数说明 |
|------|---------|---------|
| setBackGroundRes(int backGroundRes) | 设置加载框背景 | resource id <br> default #333333 with corner radius 6dp |
| showText(boolean showText) | 是否显示加载文字 | default true |
| setText(String text) | 设置加载文字 | default "加载中..." |
| setTextColorRes(int colorRes) | 设置文字颜色 | default #ffffff |
| setTextSize(int textSize) | 设置字号 | default 15 |
