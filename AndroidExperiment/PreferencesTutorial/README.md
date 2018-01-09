# Android Preferences的演示
本教程将演示Preferences的用法，也就是平时用的设置项。  
## 系统效果图如下：
整体效果
  
![效果图1](https://github.com/llfjfz/AndroidTutorials/blob/master/PreferencesTutorial/screenshots/1.png)

ListPreference  

![ListPreference](https://github.com/llfjfz/AndroidTutorials/blob/master/PreferencesTutorial/screenshots/2.png)

父子CheckBoxPreference

![CheckBoxPreference](https://github.com/llfjfz/AndroidTutorials/blob/master/PreferencesTutorial/screenshots/3.png)

## Activity相关代码
onCreate中代码：

    FragmentManager mFragmentManager = getFragmentManager();
    FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
    PrefsFragment mPrefsFragment = new PrefsFragment();
    mFragmentTransaction.replace(android.R.id.content, mPrefsFragment);
    mFragmentTransaction.commit();

这里使用PreferenceFragment的方式来加载Preference，同时使用Fragment事务类FragmentTransaction来执行Fragment的相关操作，这样可以确保这些操作的完整性。具体可以参考Android文档[Fragment](https://developer.android.com/guide/components/fragments.html)。

## Preference文件
preference文件应位于res->xml文件夹下，命名可以任意，只要符合xml文件的命名规则。

在preference的xml文件中，PreferenceScreen为根元素，可以嵌套。PreferenceCategory定义一组设置项。可以有多种形式的Preference，如CheckBoxPreference, EditTextPreference, ListPreference等。

截图效果图中父子CheckBoxPreference的实现主要依赖于其dependency属性，如下所示：
    
    <CheckBoxPreference
    android:key="child_checkbox_preference"
    android:dependency="parent_checkbox_preference"
    android:layout="?android:attr/preferenceLayoutChild"
    android:title="@string/title_child_preference"
    android:summary="@string/summary_child_preference" />