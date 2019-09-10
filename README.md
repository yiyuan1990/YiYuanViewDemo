# YiYuanViewDemo
一些自定义控件

引入方式：

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency
  
  	dependencies {
	        implementation 'com.github.yiyuan1990:YiYuanViewDemo:1.0.0'
	}
  
  使用教程：
  
  xml引入属性如下：
  
	
        <com.yiyuan.imageviewcircular.YiYuanTextView
        android:id="@+id/yiYuanView"
        android:layout_width="300dp"
        android:layout_height="100dp"
        app:text="测试一波跑马灯效果"
        app:textColor="@color/colorAccent"
        app:textSize="16"
        app:textStyle="3" />

        

        
 API方法调用如下：
 
   开始跑马灯：
  
   yiYuanView.startRun();
  
   暂停：
  
   yiYuanView.stopRun();
   
   重新开始：
   
   yiYuanView.reStartRun();
  
  提示：
  
  暂时功能API较少，后面会增加一些炫酷效果
