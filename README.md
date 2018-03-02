a Menu based Fab Menu implementation.

#Requirements
The library requires Android **API Level 14+**.

#How to install

*root build.gradle*

    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }

*app/build.gradle*

    dependencies {
        ...
        implementation "org.jetbrains.kotlin:kotlin-stdlib-jre7:$kotlin_version"
        implementation 'com.android.support:design:27.0.2'
        implementation 'com.android.support.constraint:constraint-layout:1.0.2'
        implementation 'com.github.guness:LingeringFabMenu:{currentVersion}'
    }

#Example usage

    <com.guness.widget.LingeringFabMenu
        android:id="@+id/fabMenu"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="8dp"
        app:drawable="@drawable/leveling_menu_icon"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:menu="@menu/menu_fab" />