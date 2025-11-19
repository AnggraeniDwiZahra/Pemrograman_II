package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Mahasiswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MahasiswaController implements Initializable {

    @FXML
    private TableView<Mahasiswa> tableMahasiswa;

    @FXML
    private TableColumn<Mahasiswa, String> colNim;

    @FXML
    private TableColumn<Mahasiswa, String> colNama;

    // 10 data hardcode
    ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa(1, "Karina", "24108172200"),
            new Mahasiswa(2, "Winter", "24108172201"),
            new Mahasiswa(3, "Giselle", "24108172202"),
            new Mahasiswa(4, "Ningning", "24108172203"),
            new Mahasiswa(5, "Lara", "24108172204"),
            new Mahasiswa(6, "Manon", "24108172205"),
            new Mahasiswa(7, "Sophia", "24108172206"),
            new Mahasiswa(8, "Daniella", "24108172207"),
            new Mahasiswa(9, "Megan", "24108172208"),
            new Mahasiswa(10, "Yoonchae", "24108172209")
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tableMahasiswa.setItems(data);
    }
}
