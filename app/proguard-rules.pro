
#ButterKnife
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepclasseswithmembernames class * {
   @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
   @butterknife.* <methods>;
}

#Retrofit
-dontwarn rx.**
-dontwarn okio.**
-dontwarn retrofit.**
-keep class retrofit.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
   @retrofit.http.* <methods>;
}

# OkHttp
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.squareup.okhttp.** { *; }
-keep interface com.squareup.okhttp.** { *; }
-dontwarn com.squareup.okhttp.**

#Febric
-dontwarn com.google.appengine.api.urlfetch.**
-keep class com.crashlytics.** { *; }
-keepattributes SourceFile,LineNumberTable

#Keep model and database classes
-keep class com.indiainfoline.models.**{ *; }
-keep class com.indiainfoline.parser.**{ *; }
-keep class com.indiainfoline.daggermodules.** {*;}
-keep class com.indiainfoline.receivers.**{ *; }

#Sugar orm
-keep public class * extends com.orm.SugarApp
-keep public class * extends com.orm.SugarRecord
-keep class com.orm.** { *; }
-keepclassmembers class com.orm.** { public <init>(...); }
-keepclassmembers class com.orm.** {
   *** set*(***);
   *** get*();
}

#Card view
-keep class android.support.v7.widget.RoundRectDrawable { *; }

#App compat v7
-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }
-keep public class * extends android.support.v4.view.ActionProvider {
   public <init>(android.content.Context);
}

#GMS
-keep class com.google.common.** { *;}
-keep interface com.google.common.** { *;}
-dontwarn com.google.common.**
-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
   @com.google.android.gms.common.annotation.KeepName *;
}

#Dagger
-dontobfuscate
-dontpreverify
-dontwarn dagger.internal.codegen.**, java.awt.**, com.sun.**, sun.**
-dontwarn com.squareup.javawriter.JavaWriter
#Keep the annotated things annotated
-keepattributes *Annotation*
#Keep the dagger annotation classes themselves
-keep @interface dagger.*,javax.inject.*
#Keep the Modules intact
-keep @dagger.Module class *
# Keep the generated classes by dagger-compile
-keep class * extends dagger.internal.Binding
-keep class * extends dagger.internal.ModuleAdapter
-keep class **$$ModuleAdapter
-keep class **$$InjectAdapter
-keep class **$$StaticInjection
-keep class javax.inject.** { *; }
#-Keep the fields annotated with @Inject of any class that is not deleted.
-keepclassmembers class * {
  @javax.inject.* <fields>;
}

#-Keep the names of classes that have fields annotated with @Inject and the fields themselves.
-keepclasseswithmembernames class * {
  @javax.inject.* <fields>;
}
-keepnames !abstract class coffee.*
-keepnames class dagger.Lazy


#Jackson
-dontskipnonpubliclibraryclassmembers
-keepattributes *Annotation*,EnclosingMethod
-keepnames class org.codehaus.jackson.** { *; }
-dontwarn javax.xml.**
-dontwarn javax.xml.stream.events.**
-dontwarn com.fasterxml.jackson.databind.**

#Gauva
# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

-keepclassmembers,allowoptimization class com.google.common.* {
    void finalizeReferent();
    void startFinalizer(java.lang.Class,java.lang.Object);
}

#StickyListHeaders
-keep class se.emilsjolander.** { *; }
-dontwarn se.emilsjolander.**

#datetimepicker
-keep class com.github.citux.datetimepicker.** { *;}

#nhaarman
-keep class com.nhaarman.listviewanimations.** {*;}
-keepclassmembers class com.nhaarman.listviewanimations.** {*;}

#swipelayout
-keep class com.daimajia.swipelayout.** {*;}
-keepclassmembers class com.daimajia.swipelayout.** {*;}

#AppsFlyer
-keep class com.appsflyer.** {*;}
-keepclassmembers class com.appsflyer.** {*;}

#Materialish
-keep class com.pnikosis.** {*;}
-keepclassmembers class com.pnikosis.** {*;}

#Joda
-dontwarn org.joda.convert.**
-keep class org.joda.time.** { *; }
-keep interface org.joda.time.** { *; }

#bottomsheet
-keep public class com.cocosw.** { *; }

#pagerslidingtabstrip
-keep public class com.astuetz.** { *; }

#material-dialogs
-keep public class com.afollestad.** { *; }

#viewpager indicator
-keep public class com.viewpagerindicator.** { *; }

#MP Chart lib
-keep public class com.github.mikephil.charting.** { *; }

#Facebook
-keep class com.facebook.** {*;}
-keepattributes Signature

-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.support.v4.app.Fragment
-keep public class * extends android.preference.Preference
-keepnames class * implements android.os.Parcelable {
   public static final ** CREATOR;
}

-keepclasseswithmembernames class * {
   native <methods>;
}
-keepclassmembers class **.R$* {
   public static <fields>;
}
-keepclasseswithmembers class * {
   public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * {
   public void *ButtonClicked(android.view.View);
}