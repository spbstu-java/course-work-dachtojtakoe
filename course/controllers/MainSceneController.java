package course.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainSceneController {
    @FXML
    private GridPane Lab1Panel;
    @FXML
    private GridPane Lab2Panel;
    @FXML
    private GridPane Lab3Panel;
    @FXML
    private GridPane Lab4Panel;
    @FXML
    private Label taskTitle;

    public void onTask1Click() {
        taskTitle.setText("Задание 1 - Перемещение героя");
        setActivePanel(Lab1Panel);
    }
    public void onTask2Click() {
        taskTitle.setText("Задание 2 - Аннотированные методы");
        setActivePanel(Lab2Panel);
    }
    public void onTask3Click() {
        taskTitle.setText("Задание 3 - Переводчик");
        setActivePanel(Lab3Panel);
    }
    public void onTask4Click() {
        taskTitle.setText("Задание 4 - Stream API");
        setActivePanel(Lab4Panel);
    }

    private void setActivePanel(GridPane activePanel) {
        Lab1Panel.setVisible(false);
        Lab1Panel.setManaged(false);
        Lab2Panel.setVisible(false);
        Lab2Panel.setManaged(false);
        Lab3Panel.setVisible(false);
        Lab3Panel.setManaged(false);
        Lab4Panel.setVisible(false);
        Lab4Panel.setManaged(false);

        activePanel.setVisible(true);
        activePanel.setManaged(true);
    }
}
