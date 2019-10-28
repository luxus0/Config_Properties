package spring_boot.spring_boot.config.Value;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;



@Route
public class CarGui extends HorizontalLayout
{

    CarRepo repo;


    private TextField textfieldName;
    private TextField textfieldMark;
    private TextField textfieldModel;
    private TextField textFieldColor;
    private TextField textFieldWage;

    private TextArea textAreaName;
    private TextArea textAreaMark;
    private TextArea textAreaModel;
    private TextArea textAreaColor;
    private TextArea textAreaWage;
    private TextArea textAreaAdd;
    private TextArea textAreaUpdate;

    private Button buttonAdd;
    private Button buttonUpdate;
    private Button buttonAdd2;


    public CarGui()
    {
        textfieldName = new TextField("Name");
        textfieldMark = new TextField("Mark");
        textfieldModel = new TextField("Model");
        textFieldColor = new TextField("Color");
        textFieldWage = new TextField("Wage");

        textAreaName = new TextArea("Name");
        textAreaMark = new TextArea("Mark");
        textAreaModel = new TextArea("Model");
        textAreaColor = new TextArea("Color");
        textAreaWage = new TextArea("Wage");
        textAreaAdd = new TextArea("Add");
        textAreaUpdate = new TextArea("Update");

        buttonAdd = new Button("ADD CAR");
        buttonUpdate = new Button("UPDATE CAR");
        buttonAdd2 = new Button("ADD CAR 2");

        //textArea All Car
        buttonAdd.addClickListener(b -> textAreaAdd.setValue(repo.showUser(textfieldName.getValue(),textfieldMark.getValue(),textfieldModel.getValue(),textFieldColor.getValue(), Integer.parseInt(textFieldWage.getValue() ) )));
        buttonUpdate.addClickListener(b -> textAreaUpdate.setValue(repo.update(new Car(textfieldName.getValue(), textfieldMark.getValue(),textfieldModel.getValue(),textFieldColor.getValue(),Integer.parseInt(textFieldWage.getValue()))).toString()));

        //textfield All Car
        buttonAdd2.addClickListener(event -> {
            Notification.show("ADD CARS FROM TextField");
            addCars();


        });


        add(textfieldName,textfieldMark,textfieldModel,textFieldColor,textFieldWage,textAreaAdd,textAreaUpdate,textAreaName,textAreaMark,textAreaModel,textAreaColor,textAreaWage,buttonAdd,buttonUpdate,buttonAdd2);
    }

    public void addCars()
    {
        Car car = new Car();
        car.setName(textfieldName.getValue());
        car.setMark(textfieldMark.getValue());
        car.setModel(textfieldModel.getValue());
        car.setColor(textFieldColor.getValue());
        car.setWage(Integer.parseInt(textFieldWage.getValue()));

        repo.save(car);

    }

}
