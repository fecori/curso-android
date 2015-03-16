package com.area51.utils;

import android.view.View;


import com.area51.session20.R;

import java.lang.reflect.Field;

/**
 * Created by Johann on 21/01/2015.
 */
public class InitViews {
    private static String ROOT = "root";

    public static void whichClass(Object object) {
        try {
            Field fieldRootView = object.getClass().getField(ROOT);
            View root = (View) fieldRootView.get(object);
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!View.class.isAssignableFrom(field.getType())
                        || field.getName().equals(fieldRootView.getName()))
                    continue;
                Field fieldIdRClass = R.id.class.getDeclaredField(field
                        .getName());
                int idView = fieldIdRClass.getInt(fieldIdRClass);
                View view = (View) root.findViewById(idView);
                field.set(object, view);
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
