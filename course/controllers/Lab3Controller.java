package course.controllers;

import course.FileChooserSimple;

import course.packets.lab3.Dictionary;
import course.packets.lab3.FileReadException;
import course.packets.lab3.InvalidFileFormatException;
import course.packets.lab3.Translator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab3Controller {
    @FXML
    private TextArea textForTranslation, textTranslated;
    @FXML
    private Label dictionaryPathLabel;
    @FXML
    private Button importButton, importTextButton;

    FileChooserSimple fc = new FileChooserSimple();
    Dictionary dictionary = new Dictionary();
    Translator translator = new Translator(dictionary);

    public void onImportTextClick() {
        Stage stage = (Stage) importTextButton.getScene().getWindow();
        String filePath = fc.getFilePath(stage);

        if (filePath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                textForTranslation.setText(content.toString());

            } catch (IOException e) {
                textForTranslation.setText("Ошибка\nНе удалось прочитать файл: " + e.getMessage());
            }
        }
    }

    public void onTranslateClick() {
        try {
            String translated = translator.translate(textForTranslation.getText());
            textTranslated.setText(translated);
        } catch (Exception e) {
            textTranslated.setText("Ошибка при переводе: " + e.getMessage());
        }
    }

    public void onDictionaryImportClick() {
        Stage stage = (Stage) importButton.getScene().getWindow();
        String filePath = fc.getFilePath(stage);

        if (filePath != null) {
            dictionaryPathLabel.setText("Путь: " + filePath);
            try{
                dictionary.loadFromFile(filePath);
                translator = new Translator(dictionary);
            }catch (FileReadException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("Причина: " + e.getCause().getMessage());
                }
            } catch (InvalidFileFormatException e) {
                System.out.println("Ошибка формата файла: " + e.getMessage());
            }
        }
    }
}
