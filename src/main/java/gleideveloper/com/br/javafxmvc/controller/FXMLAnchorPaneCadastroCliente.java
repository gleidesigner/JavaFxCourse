package gleideveloper.com.br.javafxmvc.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import gleideveloper.com.br.javafxmvc.model.dao.ClienteDAO;
import gleideveloper.com.br.javafxmvc.model.database.Database;
import gleideveloper.com.br.javafxmvc.model.database.DatabaseFactory;
import gleideveloper.com.br.javafxmvc.model.domain.Cliente;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Gleides on 26/01/2017.
 */
public class FXMLAnchorPaneCadastroCliente implements Initializable {
    @FXML
    private TableView<Cliente> tblViewClientes;
    @FXML
    private TableColumn<Object, Object> tblColClienteNome;
    @FXML
    private TableColumn<Object, Object> tblColClienteCpf;
    @FXML
    private Label lblClienteName;
    @FXML
    private Label lblClienteCpf;
    @FXML
    private Label lblClienteTelefone;
    @FXML
    private Button btnInserir;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnAlterar;
    @FXML
    private Label lblClienteCodigo;

    private List<Cliente> listClientes;
    private ObservableList<Cliente> obsListClientes;

    //Atributo para manipulação de dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clienteDAO.setConnection(connection);
        loadTableViewCliente();

        //Listener adicionado diante de quaisquer alterações na seleção de itens da tabelView
        tblViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> selectItemTableViewClients(newValue));
    }

    private void selectItemTableViewClients(Cliente cliente) {
        if (cliente != null){
            lblClienteCodigo.setText(String.valueOf(cliente.getCdCliente()));
            lblClienteName.setText(cliente.getNome());
            lblClienteCpf.setText(cliente.getCpf());
            lblClienteTelefone.setText(cliente.getTelefone());
        }else{
            lblClienteCodigo.setText("");
            lblClienteName.setText("");
            lblClienteCpf.setText("");
            lblClienteTelefone.setText("");
        }

    }

    public void loadTableViewCliente(){
        tblColClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblColClienteCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        listClientes = clienteDAO.listar();
        obsListClientes = FXCollections.observableArrayList(listClientes);
        tblViewClientes.setItems(obsListClientes);

    }
}
