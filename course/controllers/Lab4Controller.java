package course.controllers;

import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import static course.packets.lab4.StreamClass.*;
import static course.packets.lab4.StreamClass.getLastElement;


public class Lab4Controller {
    @FXML
    private TextField method1Input, method1Output;
    @FXML
    private TextField method2Input, method2Output;
    @FXML
    private TextField method3Input, method3Output;
    @FXML
    private TextField method4Input, method4Output;
    @FXML
    private TextField method5Input, method5Output;
    @FXML
    private TextField method6Input, method6Output;

    public void onCall1Click() {
        String input = method1Input.getText().trim();

        if(!input.isEmpty()){
            try{

            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

            method1Output.setText(String.valueOf( getAverage(numbers)));
            } catch (Exception e){
                method1Output.setText("Некорректный ввод! Исключение: " + e.getMessage());
            }
        }
        else{
            method1Output.setText("");
        }
    }
    public void onCall2Click() {
        String input = method2Input.getText().trim();

        if(!input.isEmpty()){
            try{
                List<String> words = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(String::toString)
                        .toList();

                words = strToUpperPrefix(words);

                String result = String.join(", ", words);
                method2Output.setText(result);
            } catch (Exception e){
                method2Output.setText("Некорректный ввод! Исключение: " + e.getMessage());
            }
        }
        else{
            method2Output.setText("");
        }
    }
    public void onCall3Click() {
        String input = method3Input.getText().trim();

        if(!input.isEmpty()){
            try{

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                numbers = squareSingleNumber(numbers);

                String result = numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));

                method3Output.setText(result);
            } catch (Exception e){
                method3Output.setText("Некорректный ввод! Исключение: " + e.getMessage());
            }
        }
        else{
            method3Output.setText("");
        }
    }
    public void onCall4Click() {
        String input = method4Input.getText().trim();

        if(!input.isEmpty()){
            try{

                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();

                method4Output.setText(getLastElement(numbers).toString());
            } catch (Exception e){
                method4Output.setText("Некорректный ввод! Исключение: " + e.getMessage());
            }
        }
        else{
            try{
                getLastElement(List.of());
            }catch (NoSuchElementException e){
                method4Output.setText("Исключение! " + e.getMessage());
            }
        }
    }
    public void onCall5Click() {
        String input = method5Input.getText().trim();
        if(!input.isEmpty()){
            try{
                int[] numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();

                method5Output.setText(String.valueOf(getEvenSum(numbers)));
            } catch (Exception e){
                method5Output.setText("Некорректный ввод! Исключение: " + e.getMessage());
            }
        }
        else{
            method5Output.setText("");
        }
    }
    public void onCall6Click() {
        String input = method6Input.getText().trim();

        if(!input.isEmpty()){
            try{
                List<String> words = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(String::toString)
                        .toList();

                method6Output.setText(getStringsMap(words).toString());
            } catch (Exception e){
                method6Output.setText("Некорректный ввод! Исключение: " + e.getMessage());
            }
        }
        else{
            method6Output.setText("");
        }
    }
}
