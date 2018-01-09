# Intent用法演示
本教程将演示使用隐式Intent调用第三方应用。具体而言，第一个应用输入URL地址，然后调用我们自己创建的Browser进行访问。本教程包括2个应用：ImplicitIntentDemo和MyBrowser。

## ImplicitIntentDemo
该应用很简单，输入一个网址，点击按钮开始浏览网页。

![应用界面](https://github.com/llfjfz/AndroidTutorials/blob/master/IntentTutorials/screenshots/1.png)  

当点击“浏览该网页”按钮之后，模拟器会弹出如下画面：

![选择界面](https://github.com/llfjfz/AndroidTutorials/blob/master/IntentTutorials/screenshots/2.png) 

由于我们创建了一个新的简易浏览器（下文阐述），系统会提供选择框让我们选择将要启动的应用。 这里选择“MyBrowser”应用打开。最后显示效果为：

![显示网页](https://github.com/llfjfz/AndroidTutorials/blob/master/IntentTutorials/screenshots/3.png) 

按钮的单击事件很简单:

    String url = editUrl.getText().toString();
    Intent intent = new Intent();
    intent.setAction(Intent.ACTION_VIEW);
    intent.setData(Uri.parse(url));
    startActivity(intent);

创建一个Intent，将EditText中获取的文本转换成Uri，设置Intent的动作为Intent.ACTION_VIEW，然后利用该Intent启动Activity。这里Intent的Action设置为VIEW，而Intent的数据传递一个http协议的URI，因此系统会去寻找相关能够浏览网页的应用。 
## MyBrowser
该应用利用WebView来加载网页。  
先来看看AndroidManifest.xml，注意其中的intent-filter：

    <intent-filter>
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <data android:scheme="http" />
    </intent-filter>

这里表明该Activity将能够响应action为VIEW，并且协议是http的Intent。  
MyBrowserActivity的功能就是获取Intent的数据，使用URL类获取数据中http协议的内容，并使用WebView进行加载。这里有个小细节，就是重写WebView的setWebViewClient方法，这样可以避免当有浏览网页请求时直接跳转到系统默认浏览器。  
由于MyBrowser没有指定默认启动的Activity，所以当直接运行时会提示找不到默认Activity的错误，修改方式：

![设置选项1](https://github.com/llfjfz/AndroidTutorials/blob/master/IntentTutorials/screenshots/4.png) 

![设置选项2](https://github.com/llfjfz/AndroidTutorials/blob/master/IntentTutorials/screenshots/5.png) 