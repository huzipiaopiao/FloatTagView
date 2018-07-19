# FloatTagView
[ ![Download](https://api.bintray.com/packages/teadoglibrary/FloatTagView/FloatTagView/images/download.svg) ](https://bintray.com/teadoglibrary/FloatTagView/FloatTagView/_latestVersion)

###类似最美App的底部Tag

![演示](https://github.com/huzipiaopiao/FloatTagView/blob/master/img/ezgif.com-optimize.gif)

# 使用方法：
## 1、依赖配置
- 在项目最外面的build.gradle文件中，allprojects节点下的repositories中添加：

        maven { url  "https://dl.bintray.com/teadoglibrary/FloatTagView"  }

- 再在app的build.gradle文件中，dependencies节点下添加，其中的版本建议根据最新版本修改：

        compile 'com.teaanddogdog:floattagviewlib:1.0.0'

- 本库需要依赖Recyclerview使用，所以app的build.gradle文件中，dependencies节点下还要添加recyclerview的库，版本和你项目中support的版本相同便可：

        compile 'com.android.support:recyclerview-v7:25.3.1'

## 2、代码中使用

展示界面添加以下布局
```
    <com.teaanddogdog.floattagviewlib.FloatTagRecyclerView
        android:id="@+id/left_tag"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
      />
```

FloatTagRecyclerView的adapter的item：
```
    <com.teaanddogdog.floattagviewlib.indicator.HBottomIndicatorItemView
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/indicator"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="1dp"
        android:background="@drawable/bg_indicator"
        app:init_translate_y="40dp">
    
        <ImageView
            android:id="@+id/image_view_item"
            android:layout_width="60dp"
            android:layout_height="80dp"
            android:layout_alignParentTop="true"
            android:layout_centerHorizontal="true"
            android:scaleType="centerCrop"
            />
    
        <TextView
            android:id="@+id/tv_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/image_view_item"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="5dp"
            android:maxLines="1"
            android:textSize="20sp"/>
    
    </com.teaanddogdog.floattagviewlib.indicator.HBottomIndicatorItemView>
```

和原生的RecyclerView用法相同，只是Adapter中的item的根节点的view必须是IndicatorBaseView的子类；
且FloatTagRecyclerView提供了自定义属性，用来标示是横向还是竖向排列`app:arrange_mode="V"`，有V（竖向）和H（横向）两种模式，默认是横向模式；
此模式仅供IndicatorBaseView识别用，不能用做设置RecyclerView的排列方式，具体见IndicatorBaseView的说明；
使用了自定义属性，注意在根节点内添加：`xmlns:app="http://schemas.android.com/apk/res-auto"`

库中已经默认有4种IndicatorBaseView的子类了，分别是上下左右四种，如果你要自己定义，参考他们自定义就好了：
- （1）.HBottomIndicatorItemView:当布局是横向的在底部时，用这个view作为item的根布局，对应应该在FloatTagRecyclerView中设置模式`app:arrange_mode="H"`；
- （2）.HTopIndicatorItemView:当布局是横向的在顶部时，用这个view作为item的根布局，对应应该在FloatTagRecyclerView中设置模式`app:arrange_mode="H"`；
- （3）.VLeftIndicatorItemView:当布局是竖向的在左侧时，用这个view作为item的根布局，对应应该在FloatTagRecyclerView中设置模式`app:arrange_mode="V"`；
- （4）.VRightIndicatorItemView:当布局是竖向的在右侧时，用这个view作为item的根布局，对应应该在FloatTagRecyclerView中设置模式`app:arrange_mode="V"`；

IndicatorBaseView提供了一个自定义属性`app:init_translate_y="40dp"`和`app:init_translate_x="-70dp"`，可以用来设置item开始默认隐藏的距离

## 3、说明：
- 看下demo，很好理解的


