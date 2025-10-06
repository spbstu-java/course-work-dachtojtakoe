package course.controllers;

import course.packets.lab1.FlyStrategy;
import course.packets.lab1.Hero;
import course.packets.lab1.HorseRideStrategy;
import course.packets.lab1.WalkStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class Lab1Controller {
    @FXML
    private TextField startPointTF, endPointTF;
    @FXML
    private Label resultLabel, infoLabel;
    @FXML
    private ComboBox<String> movementCB;

    Hero hero = new Hero("Герой", new WalkStrategy());

    ObservableList<String> movements = FXCollections.observableArrayList(
            "Пешком",
            "Верхом",
            "Полет"
    );

    @FXML
    private void initialize() {
        infoLabel.setText("Выберите способ перемещения:\n\nПешком\nВерхом\nПолет");
        movementCB.setItems(movements);
        movementCB.getSelectionModel().selectFirst();
    }

    public void ChangeMovement() {
        String choice = movementCB.getSelectionModel().getSelectedItem();
        switch (choice){
            case "Пешком" -> hero.setNewStrategy(new WalkStrategy());
            case "Верхом" -> hero.setNewStrategy(new HorseRideStrategy());
            case "Полет" -> hero.setNewStrategy(new FlyStrategy());
        }
    }

    public void onMoveClick() {
        resultLabel.setText(hero.move(startPointTF.getText(), endPointTF.getText()));
    }
}
