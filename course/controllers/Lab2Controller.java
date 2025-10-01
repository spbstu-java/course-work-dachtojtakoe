package course.controllers;

import course.packets.lab2.AnnotatedClass;
import course.packets.lab2.Repeat;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Lab2Controller {
    @FXML
    private Label resultLabel;

    private int count;

    public void onCallClick() {
        count++;
        resultLabel.setText("Количество вызовов: " + count + '\n');
        try {
            AnnotatedClass annotatedInstance = new AnnotatedClass();

            Class<?> clazz = annotatedInstance.getClass();

            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                if (method.isAnnotationPresent(Repeat.class) &&
                        (Modifier.isPrivate(method.getModifiers()) ||
                                Modifier.isProtected(method.getModifiers()))) {
                    Repeat repeat = method.getAnnotation(Repeat.class);
                    int times = repeat.value();

                    method.setAccessible(true);

                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Object[] parameters = new Object[parameterTypes.length];

                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes[i] == String.class) {
                            parameters[i] = "test";
                        } else if (parameterTypes[i] == int.class) {
                            parameters[i] = 11;
                        } else if (parameterTypes[i] == double.class) {
                            parameters[i] = 1.11;
                        } else if (parameterTypes[i] == boolean.class) {
                            parameters[i] = true;
                        } else {
                            parameters[i] = null;
                        }
                    }

                    resultLabel.setText(resultLabel.getText() + "Вызываем метод " + method.getName() + " " + times + " раз(а):\n");
                    for (int i = 0; i < times; i++) {
                        try {
                            resultLabel.setText(resultLabel.getText() + method.invoke(annotatedInstance, parameters) + '\n');
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                            resultLabel.setText("Ошибка при вызове метода: " + e.getMessage());
                        }
                    }
                }
            }

        } catch (SecurityException e) {
            resultLabel.setText("Ошибка безопасности: " + e.getMessage());
        }
    }

    public void onClearClick() {
        resultLabel.setText("");
    }
}
